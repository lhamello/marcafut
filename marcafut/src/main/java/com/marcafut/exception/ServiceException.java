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
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Recebe uma mensagem de erro para ser mostrada ao usu�rio.
     * 
     * @param mensagem
     *            mensagem tratada do erro.
     */
    public ServiceException(String mensagem) {
        super(mensagem);
    }

    /**
     * Recebe uma mensagem de erro para ser mostrado ao usuario e tamb�m a
     * exce��o que causou o erro.
     * 
     * @param mensagem
     *            menssagem tratada do erro.
     * @param ex
     *            exce��o que gerou o erro.
     */
    public ServiceException(String mensagem, Exception ex) {
        super(mensagem, ex);
    }

}
