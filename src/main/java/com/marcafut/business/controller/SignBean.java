package com.marcafut.business.controller;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import com.marcafut.infra.session.UserSession;
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
    private static final String SIGN_IN_UP_NAVIGATION = "index.xhtml?faces-redirect=true";
    @Inject
    private User user;
    @Inject
    private UserService userService;
    @Inject
    private UserSession userSession;
    
    public String redirectSignUp() {
        return "/public/register.xhtml?faces-redirect=true";
    }
    
    public String signIn() {
        final String email = user.getEmail();
        final String password = user.getPassword();

        user = userService.signIn(email, password);
        userSession.setUser(user);

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