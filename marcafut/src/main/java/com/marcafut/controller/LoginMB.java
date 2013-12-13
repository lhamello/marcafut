package com.marcafut.controller;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import com.marcafut.business.model.User;
import com.marcafut.business.service.UserService;

/**
 * Classe que controla o login do usuário na aplicação.
 * 
 * @author Luiz Mello
 * 
 */
@Named
@ViewAccessScoped
public class LoginMB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private User usuarioED;
    @Inject
    private UserService usuarioRN;

    public String efetuarLogin() {
        final String email = usuarioED.getEmail();
        final String senha = usuarioED.getSenha();

        User usuario = usuarioRN.findUser(email, senha);
        // sessaoUsuarioController.setUsuarioED(usuario);
        return "index.xhtml?face-redirect=true";
    }

    public User getUsuarioED() {
        return usuarioED;
    }

    public void setUsuarioED(User usuarioED) {
        this.usuarioED = usuarioED;
    }

}
