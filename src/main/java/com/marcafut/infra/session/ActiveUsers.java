package com.marcafut.infra.session;

import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import com.marcafut.business.model.User;

/**
 * 
 * 
 * @author Luiz Henrique A. Mello
 */
@ApplicationScoped
public class ActiveUsers {

    private Map<User, Long> users;

    public void addUser(User user) {
        users.put(user, user.getId());
    }

    public void removeUser(User user) {
        users.remove(user);
    }

}
