package com.marcafut.exception;

import javax.ejb.ApplicationException;

/**
 * Exce��o que estende {@code RuntimeException}. Dever� ser lan�ada a partir da
 * camada de neg�cio.
 * 
 * @author Luiz Mello
 * 
 */
@ApplicationException(rollback = true)
public class RNException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Recebe uma mensagem de erro para ser mostrada ao usu�rio.
     * 
     * @param mensagem
     *            mensagem de erro.
     */
    public RNException(String mensagem) {
        super(mensagem);
    }

}
