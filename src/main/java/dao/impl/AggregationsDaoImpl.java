package dao.impl;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dao.AggregationsDao;
import io.vavr.control.Either;
import model.errors.AppError;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Accumulators.sum;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Sorts.descending;

public class AggregationsDaoImpl implements AggregationsDao {

    public Either<AppError, String> a() {
        Either<AppError, String> result;
        try (
                MongoClient mongo = MongoClients.create("mongodb://root:root@localhost:27017")) {
            MongoDatabase db = mongo.getDatabase("exam");
            MongoCollection<Document> menuItems = db.getCollection("GymSubscriptions");
            List<Document> documents=menuItems.aggregate(Arrays.asList(unwind("$services"),unwind("$client"),group("$services",sum("total",20)),match(eq("services",3)))).into(new ArrayList<>());

            String json = documents.get(0).toJson();
            result = Either.right(json);
        } catch (
                Exception e) {
            result = Either.left(new AppError(1,e.getMessage()));

        }
        return result;
    }
}
