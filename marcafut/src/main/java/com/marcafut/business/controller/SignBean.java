package com.marcafut.business.controller;

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
public class SignBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SIGN_IN_UP_NAVIGATION = "index.xhtml?face-redirect=true";
    @Inject
    private User user;
    @Inject
    private UserService userService;

    public String signIn() {
        final String email = user.getEmail();
        final String password = user.getPassword();

        User usuario = userService.signIn(email, password);
        // sessaoUsuarioController.setUsuarioED(usuario);
        return SIGN_IN_UP_NAVIGATION;
    }

    public String signUp() {
        userService.register(user);
        return SIGN_IN_UP_NAVIGATION;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
