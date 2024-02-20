package services;

import io.vavr.control.Either;
import model.errors.AppError;
import model.modelhibernate.SubscriptionsEntity;

import java.util.List;

public interface SubscriptionServicesHibernate {
    Either<AppError,Integer> get(String nombre);
    Either<AppError,Boolean> add(List<SubscriptionsEntity> subscriptionsEntities);
}
