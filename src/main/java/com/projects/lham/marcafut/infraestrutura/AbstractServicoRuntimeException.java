package com.projects.lham.marcafut.infraestrutura;

public abstract class AbstractServicoRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AbstractServicoRuntimeException(final String mensagemErro, final Throwable excecao) {
        super(mensagemErro, excecao);
    }
}
