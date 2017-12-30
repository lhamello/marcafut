package br.com.lhamello.marcafut.contexto.controleacesso;

import br.com.lhamello.marcafut.infraestrutura.validacao.ValidadorCampoObrigatorio;

class CredencialAcessoSistema {

    private String email;
    private String senha;

    public CredencialAcessoSistema(final String email, final String senha) {
        this.setEmail(email);
        this.setSenha(senha);
    }

    private void setEmail(final String email) {
        ValidadorCampoObrigatorio.verificarPreenchimento(email, "E-mail");
        this.email = email;
    }

    private void setSenha(final String senha) {
        ValidadorCampoObrigatorio.verificarPreenchimento(senha, "Senha");
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
