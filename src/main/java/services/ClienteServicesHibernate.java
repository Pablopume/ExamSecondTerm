package services;

import io.vavr.control.Either;
import model.errors.AppError;

public interface ClienteServicesHibernate {
    Either<AppError,Integer> get(String nombre);

}
