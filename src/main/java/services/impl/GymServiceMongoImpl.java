package services.impl;

import dao.GymServicesDaoMongo;
import dao.GymSubscriptionsDaoMongo;
import io.vavr.control.Either;
import jakarta.inject.Inject;
import model.errors.AppError;
import model.modelmongo.GymSubscriptionMongo;
import services.GymServiceMongo;

public class GymServiceMongoImpl implements GymServiceMongo {
private final GymSubscriptionsDaoMongo gym;
    @Inject
    public GymServiceMongoImpl(GymSubscriptionsDaoMongo gym) {
        this.gym = gym;
    }

    @Override
    public Either<AppError, Boolean> update(GymSubscriptionMongo gm) {
        return gym.update(gm);
    }
}
