package old.com.marcafut.exception;

/**
 * This exception extends {@code RuntimeException}.<br>
 * Should be thrown from the business layer.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
//@ApplicationException(rollback = true)
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Sets the error message.<br>
     * This message should be displayed to the user.
     * 
     * @param message error message.
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * Sets the error message and the exception that led to the error.<br>
     * This message should be displayed to the user.
     * 
     * @param message
     *            error message.
     * 
     * @param ex
     *            exception that led to the error.
     */
    public ServiceException(String message, Exception ex) {
        super(message, ex);
    }

}
