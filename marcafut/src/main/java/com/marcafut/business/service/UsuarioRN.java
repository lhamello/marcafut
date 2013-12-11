package com.marcafut.business.service;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import com.marcafut.business.dao.UsuarioBD;
import com.marcafut.business.model.UsuarioED;
import com.marcafut.exception.RNException;
import com.marcafut.infra.AbstractRN;

/**
 * Classe de regra de negócios dos usuários do sistema.
 * 
 * @author Luiz Mello
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class UsuarioRN extends AbstractRN<UsuarioED, Long> {

    private static final long serialVersionUID = 1L;
    @Inject
    private UsuarioBD usuarioBD;

    @Override
    @PostConstruct
    public void initBD() {
        super.setBD(usuarioBD);
    }

    /**
     * Efetuar o login de um usuário na aplicação.
     * 
     * @param email
     *            e-mail do usuário.
     * 
     * @param senha
     *            senha do usuário.
     * 
     * @return o dados do usuário.
     */
    public UsuarioED efetuarLogin(final String email, final String senha) {
        if (StringUtils.isBlank(email)) {
            throw new RNException(messageUtil.getMessage("usuario.informe.email"));
        } else if (StringUtils.isBlank(senha)) {
            throw new RNException(messageUtil.getMessage("usuario.informe.senha"));
        }

        UsuarioED usuarioED;
        try {
            usuarioED = usuarioBD.consultarPorEmail(email);
        } catch (NoResultException ex) {
            throw new RNException(messageUtil.getMessage("usuario.naoEncontrado"), ex);
        }

        String senhaEncriptada = DigestUtils.sha512Hex(senha);

        if (!senhaEncriptada.equalsIgnoreCase(usuarioED.getSenha())) {
            throw new RNException(messageUtil.getMessage("usuario.senha.invalida"));
        }

        return usuarioED;
    }

}
