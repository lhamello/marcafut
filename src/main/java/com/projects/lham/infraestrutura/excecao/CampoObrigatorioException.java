package com.projects.lham.infraestrutura.excecao;

public class CampoObrigatorioException extends ServicoRuntimeException {
	
	public static final String MENSAGEM_ERRO = "Campo de preenchimento obrigatório não informado: %s.";
	
	private static final long serialVersionUID = 1L;

	public CampoObrigatorioException(final String nomeCampo, final Throwable excecao) {
		super(String.format(MENSAGEM_ERRO, nomeCampo), excecao);
	}
}
