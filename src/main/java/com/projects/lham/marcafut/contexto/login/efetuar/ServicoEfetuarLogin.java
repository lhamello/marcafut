package com.projects.lham.marcafut.contexto.login.efetuar;

import com.projects.lham.marcafut.infraestrutura.ServicoAplicacao;
import org.picocontainer.annotations.Inject;

class ServicoEfetuarLogin implements ServicoAplicacao {
    
    @Inject
    private RepositorioUsuarioSistema repositorioUsuarioSistema;
    
    public UsuarioSistemaDTO efetuarLogin(final String email, final String senha) {
        CredencialAcessoSistema credencialAcessoSistema = new CredencialAcessoSistema(email, senha);
        UsuarioSistemaDTO usuarioSistemaDTO = new UsuarioSistemaDTO();
        
        if (email.equals("admin@marcafut.com")) {
            usuarioSistemaDTO.setAministrador(true);
        } else {
            usuarioSistemaDTO.setAministrador(false);
        }
        
        return usuarioSistemaDTO;
    }
}
