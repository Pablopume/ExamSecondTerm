package dao;

import io.vavr.control.Either;
import model.errors.AppError;

public interface ClientDaoHibernate {
    Either<AppError,Integer> get(String nombre);
}
