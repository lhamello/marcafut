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
    private UserDAO usuarioBD;

    @Override
    @PostConstruct
    public void initBD() {
        super.setBD(usuarioBD);
    }

    /**
     * Efetuar o login de um usu�rio na aplica��o.
     * 
     * @param email
     *            e-mail do usu�rio.
     * 
     * @param senha
     *            senha do usu�rio.
     * 
     * @return o dados do usu�rio.
     */
    public User efetuarLogin(final String email, final String senha) {
        if (StringUtils.isBlank(email)) {
            throw new ServiceException(messageUtil.getMessage("usuario.informe.email"));
        } else if (StringUtils.isBlank(senha)) {
            throw new ServiceException(messageUtil.getMessage("usuario.informe.senha"));
        }

        User usuarioED;
        try {
            usuarioED = usuarioBD.consultarPorEmail(email);
        } catch (NoResultException ex) {
            throw new ServiceException(messageUtil.getMessage("usuario.naoEncontrado"), ex);
        }

        String senhaEncriptada = DigestUtils.sha512Hex(senha);

        if (!senhaEncriptada.equalsIgnoreCase(usuarioED.getSenha())) {
            throw new ServiceException(messageUtil.getMessage("usuario.senha.invalida"));
        }

        return usuarioED;
    }

}
