package services;

import io.vavr.control.Either;
import model.errors.AppError;

public interface AggregationsService {
    Either<AppError, String> a();
}
