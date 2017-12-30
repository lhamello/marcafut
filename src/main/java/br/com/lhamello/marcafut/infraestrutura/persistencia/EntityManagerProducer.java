package br.com.lhamello.marcafut.infraestrutura.persistencia;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EntityManagerProducer {

    @PersistenceContext
    private EntityManager entityManager;

    @Produces
    public EntityManager produce() {
        return entityManager;
    }
}
