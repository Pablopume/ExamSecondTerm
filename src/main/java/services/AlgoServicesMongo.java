package services;

import io.vavr.control.Either;
import model.errors.AppError;
import model.modelmongo.GymServicesMongo;

public interface AlgoServicesMongo {
    Either<AppError, GymServicesMongo> get(String name);
}
