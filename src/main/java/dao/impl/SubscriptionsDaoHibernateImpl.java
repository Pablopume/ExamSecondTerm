package dao.impl;

import dao.SubscriptionsDaoHibernate;
import dao.JPAUtil;
import io.vavr.control.Either;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.errors.AppError;
import model.modelhibernate.ServicesEntity;
import model.modelhibernate.SubscriptionServicesEntity;
import model.modelhibernate.SubscriptionsEntity;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionsDaoHibernateImpl implements SubscriptionsDaoHibernate {

    private final JPAUtil jpaUtil;
    private EntityManager em;

    @Inject
    public SubscriptionsDaoHibernateImpl(JPAUtil jpaUtil) {
        this.jpaUtil = jpaUtil;
    }


   public Either<AppError,Integer> get(String nombre){
        Either<AppError, Integer> result=null;
        em= jpaUtil.getEntityManager();
        try {
            ServicesEntity servicesEntity =  em.createQuery("SELECT se FROM ServicesEntity se WHERE se.name= :nombre",ServicesEntity.class).setParameter("nombre",nombre).getSingleResult();
            if (servicesEntity != null) {

                result = Either.right(servicesEntity.getId());
            } else {
                result = Either.left(new AppError(1, "No service found"));
            }
        }
        catch (Exception e){
            result= Either.left(new AppError(1, "Fail in the database"));
        }

        return result;
    }

    public Either<AppError,Boolean> add(List<SubscriptionsEntity> subscriptionsEntities){
        int yoga=get("Yoga Classes").get();
        int personal=get("Personal Training").get();
        em = jpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Either<AppError, Boolean> result=null;
        try {
            tx.begin();

            List<Integer>list=new ArrayList<>();
            list.add(yoga);
            list.add(personal);
            for (int i = 0; i <subscriptionsEntities.size() ; i++) {
                em.persist(subscriptionsEntities.get(i));
                SubscriptionServicesEntity subs=new SubscriptionServicesEntity(subscriptionsEntities.get(i).getId(),list.get(i));
                em.persist(subs);
            }
            tx.commit();
            result = Either.right(true);
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            result = Either.left(new AppError(1,"Error adding Subscription"));
        } finally {
            if (em != null) em.close();
        }
        return result;
    }
}
