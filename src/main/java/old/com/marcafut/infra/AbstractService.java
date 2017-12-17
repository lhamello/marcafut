package old.com.marcafut.infra;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import old.com.marcafut.exception.ServiceException;
import old.com.marcafut.util.MessageBundleUtil;

/**
 * Abstract class for the system service classes.<br>
 * This class provides the defaults methods for the service classes.
 * 
 * @author Luiz Henrique A. Mello
 * 
 * @param <E>
 *            entity managed by the class.
 * 
 * @param <K>
 *            primary key type.
 */
public abstract class AbstractService<E extends AbstractModel<K>, K> implements Serializable {

    private static final long serialVersionUID = 1L;
    private AbstractDAO<E, K> dao;
    @Inject
    protected MessageBundleUtil bundle;
    
    /**
     * Must be implemented by subclasses to inform the parent class the
     * {@code AbstractDAO} that will be used by this class.
     */
    @PostConstruct
    public abstract void initDAO();

    /**
     * Call the <i>DAO</i> class to perform the search by primaryKey.<br>
     * The primary key can't no be {@code null}.
     * 
     * @param primaryKey
     *            primary key for entity.
     * 
     * @return the value of entity searched.
     * 
     * @see old.com.marcafut.infra.AbstractDAO#findById(Object)
     */
    public E findById(final K primaryKey) {
        if (primaryKey == null) {
            throw new ServiceException(bundle.getMessage("abstract.exception.enter.primaryKey"));
        }
        
        return dao.findById(primaryKey);
    }

    /**
     * Sets the {@code AbstractDAO} object that will be used by this class.
     * 
     * @param dao the {@code AbstractDAO} object that will be used by this class.
     */
    public void setDAO(final AbstractDAO<E, K> dao) {
        this.dao = dao;
    }
    
}
