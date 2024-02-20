package dao.impl;

import dao.ClientDaoHibernate;
import dao.JPAUtil;
import io.vavr.control.Either;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import model.errors.AppError;
import model.modelhibernate.ClientsEntity;

public class ClientDaoHibernateImpl implements ClientDaoHibernate {

    private final JPAUtil jpaUtil;
    private EntityManager em;

    @Inject
    public ClientDaoHibernateImpl(JPAUtil jpaUtil) {
        this.jpaUtil = jpaUtil;
    }


   public Either<AppError,Integer> get(String nombre){
        Either<AppError, Integer> result=null;
        em= jpaUtil.getEntityManager();
        try {
            ClientsEntity clientesEntity =  em.createQuery("SELECT se FROM ClientsEntity se WHERE se.name= :nombre", ClientsEntity.class).setParameter("nombre",nombre).getSingleResult();
            if (clientesEntity != null) {

                result = Either.right(clientesEntity.getId());
            } else {
                result = Either.left(new AppError(1, "No service found"));
            }
        }
        catch (Exception e){
            result= Either.left(new AppError(1, "Fail in the database"));
        }
        finally {
            if(em!=null)em.close();
        }
        return result;
    }
}
