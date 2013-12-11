package com.marcafut.exception;

import javax.ejb.ApplicationException;

/**
 * Exceção que estende {@code RuntimeException}. Deverá ser lançada a partir da
 * camada de negócio.
 * 
 * @author Luiz Mello
 * 
 */
@ApplicationException(rollback = true)
public class RNException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Recebe uma mensagem de erro para ser mostrada ao usuário.
     * 
     * @param mensagem
     *            mensagem de erro.
     */
    public RNException(String mensagem) {
        super(mensagem);
    }

}
