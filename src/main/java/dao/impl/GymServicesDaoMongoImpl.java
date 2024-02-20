package dao.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dao.GymServicesDaoMongo;
import dao.adapters.LocalDateAdapter;
import dao.adapters.LocalDateTimeAdapter;
import dao.adapters.ObjectIdAdapter;
import io.vavr.control.Either;
import model.errors.AppError;
import model.modelmongo.GymServicesMongo;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.mongodb.client.model.Filters.eq;

public class GymServicesDaoMongoImpl implements GymServicesDaoMongo {

    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .registerTypeAdapter(ObjectId.class, new ObjectIdAdapter())
            .create();

    public Either<AppError,GymServicesMongo> get(String name){
        Either<AppError,GymServicesMongo> result;
        try (MongoClient mongo = MongoClients.create("mongodb://root:root@localhost:27017")) {
            MongoDatabase db = mongo.getDatabase("exam");
            MongoCollection<Document> customers = db.getCollection("GymServices");

            // Find the document with the specified ID
                Document gymServiceDocument = customers.find(eq("name",name)).first();

            if (gymServiceDocument != null) {
                // Convert Document to Customer using Gson
                GymServicesMongo gymServicesMongo = gson.fromJson(gymServiceDocument.toJson(), GymServicesMongo.class);
                result = Either.right(gymServicesMongo);
            } else {
                result = Either.left(new AppError(1,"Error obtaining service"));
            }
        } catch (Exception e) {

            result = Either.left(new AppError(1,"Error obtaining service"));
        }
        return result;
    }
}
