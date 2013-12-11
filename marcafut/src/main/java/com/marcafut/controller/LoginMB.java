package com.marcafut.controller;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import com.marcafut.business.model.UsuarioED;
import com.marcafut.business.service.UsuarioRN;

/**
 * 
 * @author Luiz Mello
 *
 */
@Named
@ViewAccessScoped
public class LoginMB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private UsuarioED usuarioED;
    @Inject
    private UsuarioRN usuarioService;
    
    public String efetuaLogin() {
        final String email = usuarioED.getEmail();
        final String senha = usuarioED.getSenha();
        
        UsuarioED usuario = usuarioService.efetuarLogin(email, senha);
//        sessaoUsuarioController.setUsuarioED(usuario);
        return "index.xhtml?face-redirect=true";
    }

    public UsuarioED getUsuarioED() {
        return usuarioED;
    }

    public void setUsuarioED(UsuarioED usuarioED) {
        this.usuarioED = usuarioED;
    }

}
