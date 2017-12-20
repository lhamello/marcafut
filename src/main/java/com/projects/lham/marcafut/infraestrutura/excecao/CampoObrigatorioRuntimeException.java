package com.projects.lham.marcafut.infraestrutura.excecao;

import com.projects.lham.marcafut.infraestrutura.AbstractServicoRuntimeException;

public class CampoObrigatorioRuntimeException extends AbstractServicoRuntimeException {

    public static final String MENSAGEM_ERRO = "Campo de preenchimento obrigatório não informado: %s.";

    private static final long serialVersionUID = 1L;

    public CampoObrigatorioRuntimeException(final String nomeCampo) {
        super(String.format(MENSAGEM_ERRO, nomeCampo));
    }
}
