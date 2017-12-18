package com.projects.lham.contexto.login.efetuar;

import com.projects.lham.infraestrutura.util.ValidadorCampoObrigatorio;

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

	private void setSenha(String senha) {
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
