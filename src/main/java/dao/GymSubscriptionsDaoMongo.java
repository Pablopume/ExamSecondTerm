package dao;

import io.vavr.control.Either;
import model.errors.AppError;
import model.modelmongo.GymServicesMongo;
import model.modelmongo.GymSubscriptionMongo;

public interface GymSubscriptionsDaoMongo {
    Either<AppError, Boolean> update(GymSubscriptionMongo gm);
}
