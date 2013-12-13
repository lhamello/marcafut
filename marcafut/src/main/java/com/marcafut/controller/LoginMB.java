package com.marcafut.controller;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import com.marcafut.business.model.User;
import com.marcafut.business.service.UserService;

/**
 * This class control the user login in the application.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
@Named
@ViewAccessScoped
public class LoginMB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private User user;
    @Inject
    private UserService userService;

    public String efetuarLogin() {
        final String email = user.getEmail();
        final String password = user.getPassword();

        User usuario = userService.login(email, password);
        // sessaoUsuarioController.setUsuarioED(usuario);
        return "index.xhtml?face-redirect=true";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
