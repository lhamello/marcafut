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
     *            mensagem tratada do erro.
     */
    public RNException(String mensagem) {
        super(mensagem);
    }

    /**
     * Recebe uma mensagem de erro para ser mostrado ao usuario e também a
     * exceção que causou o erro.
     * 
     * @param mensagem
     *            menssagem tratada do erro.
     * @param ex
     *            exceção que gerou o erro.
     */
    public RNException(String mensagem, Exception ex) {
        super(mensagem, ex);
    }

}
