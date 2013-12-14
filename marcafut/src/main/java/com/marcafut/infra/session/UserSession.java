package com.marcafut.infra.session;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import com.marcafut.business.model.User;

/**
 * This class is responsible for control the user session.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
@SessionScoped
public class UserSession implements Serializable {

    private static final long serialVersionUID = 1L;

    private User user;

    /**
     * Indicates if the user is logged or not.
     * 
     * @return {@code true} if the user is logged or {@code false} if the user
     *         is not logged.
     */
    public boolean isUserLogged() {
        boolean logged = false;

        if (user != null) {
            logged = true;
        }

        return logged;
    }
}
