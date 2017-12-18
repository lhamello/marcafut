package com.projects.lham.infraestrutura.excecao;

public class ServicoRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServicoRuntimeException(final String mensagemErro, final Throwable excecao) {
		super(mensagemErro, excecao);
	}
}
