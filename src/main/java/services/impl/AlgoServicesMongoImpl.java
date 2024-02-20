package services.impl;

import dao.GymServicesDaoMongo;
import io.vavr.control.Either;
import jakarta.inject.Inject;
import model.errors.AppError;
import model.modelmongo.GymServicesMongo;
import services.AlgoServicesMongo;

public class AlgoServicesMongoImpl implements AlgoServicesMongo {
    private final GymServicesDaoMongo gymServicesDaoMongo;
    @Inject
    public AlgoServicesMongoImpl(GymServicesDaoMongo gymServicesDaoMongo) {
        this.gymServicesDaoMongo = gymServicesDaoMongo;
    }


    @Override
    public Either<AppError, GymServicesMongo> get(String name) {
        return gymServicesDaoMongo.get(name);
    }
}
