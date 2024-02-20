package dao;

import io.vavr.control.Either;
import model.errors.AppError;

public interface AggregationsDao {
    Either<AppError, String> a();
}
