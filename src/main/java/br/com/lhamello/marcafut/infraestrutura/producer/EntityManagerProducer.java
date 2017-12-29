package br.com.lhamello.marcafut.infraestrutura.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EntityManagerProducer {

    @PersistenceContext
    EntityManager entityManager;

    @Produces
    public EntityManager produce() {
        return entityManager;
    }
}
