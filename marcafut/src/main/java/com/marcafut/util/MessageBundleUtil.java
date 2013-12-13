package com.marcafut.util;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.inject.Inject;

import org.slf4j.Logger;

/**
 * Class responsible for reading messages from the message bundle.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
public class MessageBundleUtil {

    @Inject
    private Logger logger;
    @Inject
    private ResourceBundle resourceBundle;

    /**
     * Accesses the message bundle and returns the value of the given key.
     * 
     * @param key
     *            key to the message
     * 
     * @return if the key is found, message related to the key. If the key is
     *         not found returns ??<i>key</i>??
     */
    public String getMessage(String key) {
        StringBuilder message = new StringBuilder();

        try {
            message.append(resourceBundle.getString(key));
        } catch (MissingResourceException ex) {
            message.append("??").append(key).append("??");
            logger.warn("Chave não encontrada no arquivo de properties", ex);
        }

        return message.toString();
    }

    /**
     * Accesses the message bundle and returns the value of the given key. This
     * key contains parameters that are formatted and added to the message
     * before the message is returned.
     * 
     * @param key
     *            key to the message
     * 
     * @param parameters
     *            for the message
     * 
     * @return if the key is found, message related to the key. If the key is
     *         not found returns ??<i>key</i>??
     */
    public String getMessage(String key, Object... params) {
        String message = this.getMessage(key);

        return MessageFormat.format(message, params);
    }

}
