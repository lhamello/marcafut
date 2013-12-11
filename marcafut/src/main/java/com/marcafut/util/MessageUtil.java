package com.marcafut.util;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.inject.Inject;

import org.slf4j.Logger;

public class MessageUtil {
    
    @Inject
    private Logger logger;
    @Inject
    private ResourceBundle resourceBundle;

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

    public String getMessage(String key, Object... params) {
        String message = this.getMessage(key);
        
        return MessageFormat.format(message, params);
    }
    
}
