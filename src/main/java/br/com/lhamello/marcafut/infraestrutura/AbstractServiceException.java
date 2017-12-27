package br.com.lhamello.marcafut.infraestrutura;

public abstract class AbstractServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AbstractServiceException(final String mensagemErro) {
        super(mensagemErro);
    }
}
