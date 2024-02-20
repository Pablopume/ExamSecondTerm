package services.impl;

import dao.SubscriptionsDaoHibernate;
import io.vavr.control.Either;
import jakarta.inject.Inject;
import model.errors.AppError;
import model.modelhibernate.SubscriptionsEntity;
import services.SubscriptionServicesHibernate;

import java.util.List;

public class SubscriptionServicesHibernateImpl implements SubscriptionServicesHibernate {
    private final SubscriptionsDaoHibernate subscriptionsDaoHibernate;
    @Inject
    public SubscriptionServicesHibernateImpl(SubscriptionsDaoHibernate subscriptionsDaoHibernate) {
        this.subscriptionsDaoHibernate = subscriptionsDaoHibernate;
    }

    @Override
    public Either<AppError, Integer> get(String nombre) {
        return subscriptionsDaoHibernate.get(nombre);
    }

    @Override
    public Either<AppError, Boolean> add(List<SubscriptionsEntity> subscriptionsEntities) {
        return subscriptionsDaoHibernate.add(subscriptionsEntities);
    }


}
