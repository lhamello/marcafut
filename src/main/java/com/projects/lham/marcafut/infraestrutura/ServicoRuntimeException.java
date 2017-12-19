package com.projects.lham.marcafut.infraestrutura;

public abstract class ServicoRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServicoRuntimeException(final String mensagemErro, final Throwable excecao) {
		super(mensagemErro, excecao);
	}
}
