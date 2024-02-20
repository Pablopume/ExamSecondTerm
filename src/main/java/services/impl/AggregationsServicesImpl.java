package services.impl;

import dao.AggregationsDao;
import io.vavr.control.Either;
import jakarta.inject.Inject;
import model.errors.AppError;
import services.AggregationsService;

public class AggregationsServicesImpl implements AggregationsService {
   private final AggregationsDao aggregationsDao;
    @Inject
    public AggregationsServicesImpl(AggregationsDao aggregationsDao) {
        this.aggregationsDao = aggregationsDao;
    }

    @Override
    public Either<AppError, String> a() {
        return aggregationsDao.a();
    }
}
