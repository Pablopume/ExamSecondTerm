package dao;

import io.vavr.control.Either;
import model.errors.AppError;
import model.modelmongo.GymServicesMongo;

public interface GymServicesDaoMongo {
    Either<AppError, GymServicesMongo> get(String name);
}
