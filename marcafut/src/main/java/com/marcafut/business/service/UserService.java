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
 * Classe de regra de neg�cios dos usu�rios do sistema.
 * 
 * @author Luiz Mello
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class UserService extends AbstractService<User, Long> {

    private static final long serialVersionUID = 1L;
    @Inject
    private UserDAO usuarioDAO;

    @Override
    @PostConstruct
    public void initDAO() {
        super.setBD(usuarioDAO);
    }

    /**
     * Efetuar o login de um usu�rio na aplica��o.
     * 
     * @param email
     *            e-mail do usu�rio.
     * 
     * @param password
     *            senha do usu�rio.
     * 
     * @return o dados do usu�rio.
     */
    public User findUser(final String email, final String password) {
        if (StringUtils.isBlank(email)) {
            throw new ServiceException(bundle.getMessage("user.exception.enter.email"));
        } else if (StringUtils.isBlank(password)) {
            throw new ServiceException(bundle.getMessage("user.exception.enter.password"));
        }

        User usuarioED;
        try {
            usuarioED = usuarioDAO.consultarPorEmail(email);
        } catch (NoResultException ex) {
            throw new ServiceException(bundle.getMessage("user.exception.wrong.email.password"), ex);
        }

        String senhaEncriptada = DigestUtils.sha512Hex(password);

        if (!senhaEncriptada.equalsIgnoreCase(usuarioED.getPassword())) {
            throw new ServiceException(bundle.getMessage("user.exception.wrong.email.password"));
        }

        return usuarioED;
    }

}
