package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {

    private static final String PERSISTENCE_UNIT_NAME = "tasklist";
    private static EntityManagerFactory emf;

    public static EntityManager createEntityManager(){
        return _getEntityManageerFactory().createEntityManager();
    }

    private static EntityManagerFactory _getEntityManageerFactory(){
        if (emf==null){
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }

        return emf;
    }

}
