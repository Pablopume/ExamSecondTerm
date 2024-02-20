package services.impl;

import dao.ClientDaoHibernate;
import io.vavr.control.Either;
import jakarta.inject.Inject;
import model.errors.AppError;
import services.ClienteServicesHibernate;

public class ClienteServicesHibernateImpl implements ClienteServicesHibernate {
    private final ClientDaoHibernate clientDaoHibernate;
    @Inject
    public ClienteServicesHibernateImpl(ClientDaoHibernate clientDaoHibernate) {
        this.clientDaoHibernate = clientDaoHibernate;
    }

    @Override
    public Either<AppError, Integer> get(String nombre) {
        return clientDaoHibernate.get(nombre);
    }
}
