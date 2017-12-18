package com.projects.lham.contexto.login.efetuar;

import com.projects.lham.infraestrutura.definicao.ServicoAplicacao;

class ServicoEfetuarLogin extends ServicoAplicacao {

	private static final long serialVersionUID = 1L;
	
	public void acessarSistema(final String email, final String senha) {
		CredencialAcessoSistema credencial = new CredencialAcessoSistema(email, senha);
	}
}
