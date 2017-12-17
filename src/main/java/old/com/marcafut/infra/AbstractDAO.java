package old.com.marcafut.infra;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Abstract <i>DAO</i> for the system <i>DAO</i> classes.<br>
 * This class contains the persistence unit and provides default methods for
 * accessing the database.
 * 
 * @author Luiz Henrique A. Mello
 * 
 * @param <E>
 *            entity managed by the class.
 * 
 * @param <K>
 *            primary key type.
 */
public class AbstractDAO<E extends AbstractModel<K>, K> {

    private Class<E> entity;
    @PersistenceContext
    protected EntityManager entityManager;
    
    /**
     * Set the entity that will be managed by the class.
     */
    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entity = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
    }
    
    /**
     * Find a entity (in the database) by primary key.<br>
     * Generated <i>SQL</i> code: <i>SELECT * FROM entity e WHERE e.id = primaryKey</i>.
     * 
     * @param primaryKey
     *            primary key for the searched object.
     * 
     * @return value of the entity searched.
     */
    @SuppressWarnings("unchecked")
    public E findById(final K primaryKey) {
        final String namedQuery = entity.getSimpleName() + ".findById";
        
        Query query = entityManager.createNamedQuery(namedQuery);
        query.setParameter("id", primaryKey);
        
        return (E) query.getSingleResult();
    }
    
    /**
     * Insert an entity in the database.
     * 
     * @param entity entity that will be to insert.
     * 
     * @return the inserted entity.
     */
    public E insert(final E entity) {
        entityManager.persist(entity);
        entityManager.flush();
        
        return entity;
    }
    
}
