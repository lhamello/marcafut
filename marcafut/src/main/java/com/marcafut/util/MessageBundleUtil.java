package com.marcafut.util;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.inject.Inject;

import org.slf4j.Logger;

/**
 * Classe responsável por ler as mensagens do <i>bundle</i> de mensagens.
 * 
 * @author Luiz Mello
 * 
 */
public class MessageBundleUtil {

    @Inject
    private Logger logger;
    @Inject
    private ResourceBundle resourceBundle;

    /**
     * Recebe uma chave e retorna o valor para esta chave contido no
     * <i>bundle</i> de mensagens.
     * 
     * @param key
     *            chave para a mensagem.
     * 
     * @return se a chave for encontrada a mensagem relacionada é retornada,
     *         senão retorna ??<i>Key</i>??.
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
     * Recebe uma chave para uma mensagem que contenha parâmetros. Este
     * parâmetros são usados como parte da mensagem de retorno.
     * 
     * @param key
     *            chave para a mensagem.
     * @param params
     *            parâmetros a serem incorporados na mensagem.
     * 
     * @return se a chave for encontrada a mensagem relacionada é retornada já
     *         com os parâmetros formatados, senão retorna ??<i>Key</i>??.
     */
    public String getMessage(String key, Object... params) {
        String message = this.getMessage(key);

        return MessageFormat.format(message, params);
    }

}
