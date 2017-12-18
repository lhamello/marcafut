package com.projects.lham.infraestrutura.excecao;

public class CampoObrigatorioRuntimeException extends ServicoRuntimeException {
	
	public static final String MENSAGEM_ERRO = "Campo de preenchimento obrigatório não informado: %s.";
	
	private static final long serialVersionUID = 1L;

	public CampoObrigatorioRuntimeException(final String nomeCampo, final Throwable excecao) {
		super(String.format(MENSAGEM_ERRO, nomeCampo), excecao);
	}
}