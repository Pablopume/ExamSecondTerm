package dao.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import dao.GymSubscriptionsDaoMongo;
import dao.adapters.LocalDateAdapter;
import dao.adapters.LocalDateTimeAdapter;
import dao.adapters.ObjectIdAdapter;
import io.vavr.control.Either;
import model.errors.AppError;
import model.modelmongo.GymServicesMongo;
import model.modelmongo.GymSubscriptionMongo;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

import static com.mongodb.client.model.Filters.eq;

public class GymSubscriptionsDaoMongoImpl implements GymSubscriptionsDaoMongo {

    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .registerTypeAdapter(ObjectId.class, new ObjectIdAdapter())
            .create();

    public Either<AppError, Boolean> update(GymSubscriptionMongo gm) {
        Either<AppError, Boolean> result;
        try (MongoClient mongo = MongoClients.create("mongodb://root:root@localhost:27017")) {
            MongoDatabase db = mongo.getDatabase("exam");
            MongoCollection<Document> customers = db.getCollection("GymSubscriptions");

            Bson filter = Filters.eq("client.name", gm.getClientMongo().getName());            // Find the document with the specified ID
            Document gymServiceDocument = customers.find(filter).first();

            if (gymServiceDocument != null) {
                // Convert Document to Customer using Gson
                List<Document> documents = (List<Document>) gymServiceDocument.get("services");

                Document doc = new Document();
                doc.put("", gm.getGymServicesMongo().get_id());
                documents.add(doc);
                Bson update = Updates.set("services", documents);
                customers.updateOne(filter, update);
                result = Either.right(true);
            } else {
                result = Either.left(new AppError(1, "Error obtaining service"));
            }
        } catch (Exception e) {

            result = Either.left(new AppError(1, "Error obtaining service"));
        }
        return result;
    }

}
