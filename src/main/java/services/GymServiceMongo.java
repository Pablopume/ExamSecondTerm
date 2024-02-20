package services;

import io.vavr.control.Either;
import model.errors.AppError;
import model.modelmongo.GymSubscriptionMongo;

public interface GymServiceMongo {
    Either<AppError, Boolean> update(GymSubscriptionMongo gm);
}
