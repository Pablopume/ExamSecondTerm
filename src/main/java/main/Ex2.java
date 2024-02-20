package main;

import dao.GymServicesDaoMongo;
import dao.GymSubscriptionsDaoMongo;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import model.modelmongo.ClientMongo;
import model.modelmongo.GymServicesMongo;
import model.modelmongo.GymSubscriptionMongo;
import org.bson.types.ObjectId;
import services.AlgoServicesMongo;
import services.ClienteServicesHibernate;
import services.GymServiceMongo;
import services.SubscriptionServicesHibernate;

import java.time.LocalDate;

public class Ex2 {
    public static void main(String[] args) {
        SeContainerInitializer initializer=SeContainerInitializer.newInstance();
        final SeContainer container = initializer.initialize();
        final SeContainer container2 = initializer.initialize();
        GymServiceMongo aggregationsServices = container.select(GymServiceMongo.class).get();
        AlgoServicesMongo clienteServicesHibernate=container2.select(AlgoServicesMongo.class).get();

        ClientMongo client=new ClientMongo("Sarah",0);
        GymServicesMongo gm=clienteServicesHibernate.get("Yoga Classes").get();
        GymSubscriptionMongo gymSubscriptionMongo=new GymSubscriptionMongo(new ObjectId(), LocalDate.now(),LocalDate.now(),client,gm);
        GymServicesMongo gm2=clienteServicesHibernate.get("Personal Training").get();
        GymSubscriptionMongo gymSubscriptionMongo2=new GymSubscriptionMongo(new ObjectId(), LocalDate.now(),LocalDate.now(),client,gm2);
        aggregationsServices.update(gymSubscriptionMongo);
        aggregationsServices.update(gymSubscriptionMongo2);
    }
}
