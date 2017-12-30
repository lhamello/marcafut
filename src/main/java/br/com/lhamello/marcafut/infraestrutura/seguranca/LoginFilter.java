package br.com.lhamello.marcafut.infraestrutura.seguranca;


import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Named;

import br.com.lhamello.marcafut.infraestrutura.util.FacesMessageUtil;
import com.github.adminfaces.template.session.AdminSession;
import org.omnifaces.util.Faces;

@Named
@SessionScoped
@Specializes
public class LoginFilter extends AdminSession implements Serializable {

    private static final long serialVersionUID = 1L;
    private String currentUser;
    private String email;
    private String password;
    private boolean remember;


    public void login() throws IOException {
        currentUser = email;
        FacesMessageUtil.addDetailMessage("Logged in successfully as <b>" + email + "</b>", null);
        Faces.getExternalContext().getFlash().setKeepMessages(true);
        Faces.redirect("index.xhtml");
    }

    @Override
    public boolean isLoggedIn() {

        return currentUser != null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }
}
