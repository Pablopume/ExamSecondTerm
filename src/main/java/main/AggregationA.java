package main;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import model.modelhibernate.SubscriptionsEntity;
import services.AggregationsService;
import services.ClienteServicesHibernate;
import services.SubscriptionServicesHibernate;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AggregationA {
    public static void main(String[] args) {
        SeContainerInitializer initializer=SeContainerInitializer.newInstance();
        final SeContainer container = initializer.initialize();

        AggregationsService aggregationsServices = container.select(AggregationsService.class).get();
        System.out.println(aggregationsServices.a());


    }
}
