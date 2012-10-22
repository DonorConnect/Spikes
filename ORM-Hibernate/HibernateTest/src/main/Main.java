package main;

import models.Charity;
import models.Project;
import org.hibernate.ejb.HibernatePersistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        PersistenceProvider persistenceProvider = new HibernatePersistence();
        EntityManagerFactory entityManagerFactory = persistenceProvider.createEntityManagerFactory("NewPersistenceUnit", new HashMap());
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Project project = new Project("projectName");
        Charity charity = new Charity("charityName", "charityType");
        charity.addProject(project);

        entityManager.getTransaction().begin();
//        entityManager.persist(project);
        entityManager.persist(charity);

        entityManager.flush();
        entityManager.getTransaction().commit();

        entityManager.close();




    }

}
