package old.com.marcafut.business.dao;

import javax.persistence.Query;

import old.com.marcafut.business.model.User;
import old.com.marcafut.infra.AbstractDAO;

/**
 * This class accesses the USERS table in the database.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
public class UserDAO extends AbstractDAO<User, Long> {

    /**
     * Find a entity (in a database) by e-mail and password.<br>
     * Generated <i>SQL</i> code: <i>SELECT * FROM users u WHERE u.email = email AND u.password = password</i>.
     * 
     * @param email
     *            searched e-mail.
     * 
     * @param password
     *            searched password.
     * 
     * @return value of the object searched.
     */
    public User findByEmailPassword(final String email, final String password) {
        Query query = entityManager.createNamedQuery("User.findByEmailPassword");
        query.setParameter("email", email);
        query.setParameter("password", password);
        
        return (User) query.getSingleResult();
    }

}
