package com.marcafut.business.dao;

import javax.persistence.Query;

import com.marcafut.business.model.User;
import com.marcafut.infra.AbstractDAO;

/**
 * This class accesses the USERS table in the database.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
public class UserDAO extends AbstractDAO<User, Long> {

    /**
     * Find a entity (in a database) by e-mail.<br>
     * Generated <i>SQL</i> code: <i>SELECT * FROM users u WHERE u.email = email</i>.
     * 
     * @param email
     *            searched e-mail.
     * 
     * @return value of the object searched.
     */
    public User findByEmail(final String email) {
        Query query = entityManager.createNamedQuery("User.findByEmail");
        query.setParameter("email", email);

        return (User) query.getSingleResult();
    }

}
