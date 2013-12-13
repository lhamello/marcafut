package com.marcafut.business.service;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import com.marcafut.business.dao.UserDAO;
import com.marcafut.business.model.User;
import com.marcafut.exception.ServiceException;
import com.marcafut.infra.AbstractService;

/**
 * This class contains the rules for the application users.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class UserService extends AbstractService<User, Long> {

    private static final long serialVersionUID = 1L;
    @Inject
    private UserDAO userDAO;

    @Override
    @PostConstruct
    public void initDAO() {
        super.setDAO(userDAO);
    }

    /**
     * Authenticates the user in the application.
     * 
     * @param email user e-mail.
     * 
     * @param password user password.
     * 
     * @return the logged user.
     */
    public User signIn(final String email, final String password) {
        if (StringUtils.isBlank(email)) {
            throw new ServiceException(bundle.getMessage("user.exception.enter.email"));
        } else if (StringUtils.isBlank(password)) {
            throw new ServiceException(bundle.getMessage("user.exception.enter.password"));
        }

        User user;
        try {
            user = userDAO.findByEmail(email);
        } catch (NoResultException ex) {
            throw new ServiceException(bundle.getMessage("user.exception.wrong.email.password"), ex);
        }

        String encryptedPassword = DigestUtils.sha512Hex(password);

        if (!encryptedPassword.equalsIgnoreCase(user.getPassword())) {
            throw new ServiceException(bundle.getMessage("user.exception.wrong.email.password"));
        }

        return user;
    }

}
