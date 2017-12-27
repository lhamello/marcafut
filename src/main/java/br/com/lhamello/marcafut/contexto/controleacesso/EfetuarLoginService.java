package br.com.lhamello.marcafut.contexto.controleacesso;

import br.com.lhamello.marcafut.infraestrutura.AbstractApplicationService;

final class EfetuarLoginService extends AbstractApplicationService {
    
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unused")
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
