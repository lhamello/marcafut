package com.projects.lham.marcafut.contexto.login.efetuar;

import com.projects.lham.marcafut.infraestrutura.ServicoAplicacao;

class ServicoEfetuarLogin implements ServicoAplicacao {

    public void acessarSistema(final String email, final String senha) {
        new CredencialAcessoSistema(email, senha);
    }
}
