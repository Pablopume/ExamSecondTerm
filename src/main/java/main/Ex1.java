package main;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import model.modelhibernate.SubscriptionsEntity;
import services.ClienteServicesHibernate;
import services.SubscriptionServicesHibernate;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        SeContainerInitializer initializer=SeContainerInitializer.newInstance();
        final SeContainer container = initializer.initialize();
        final SeContainer container2 = initializer.initialize();
        SubscriptionServicesHibernate aggregationsServices = container.select(SubscriptionServicesHibernate.class).get();
        ClienteServicesHibernate clienteServicesHibernate=container2.select(ClienteServicesHibernate.class).get();

        int nombre=clienteServicesHibernate.get("Sarah").get();
        List<SubscriptionsEntity> subs=new ArrayList<>();
        subs.add(new SubscriptionsEntity(nombre, Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.of(2025,12,1)),0));
        subs.add(new SubscriptionsEntity(nombre, Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.of(2025,12,1)),0));
        aggregationsServices.add(subs);

    }
}
