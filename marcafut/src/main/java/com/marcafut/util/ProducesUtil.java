package com.marcafut.util;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe responsável por produzir objetos que serão injetados em outras
 * classes.
 * 
 * @author Luiz Mello
 * 
 */
public class ProducesUtil {

    /**
     * Retorna um objeto {@code Logger} que poderá ser injetado em outras
     * classes para gerenciar as mensagens que serão mostradas na console do
     * sistema.
     * 
     * @param ip
     *            objeto que marcado com o <i>annotation</i> {@code Inject}.
     * 
     * @return objeto {@code Logger}.
     */
    @Produces
    public Logger loggerProduces(final InjectionPoint ip) {
        return LoggerFactory.getLogger(ip.getMember().getDeclaringClass().getCanonicalName());
    }

    /**
     * Retorna um objeto {@code ResourceBundle} que poderá ser injetado em
     * outras classes para a leitura das mensagem do bundle de mensagem.
     * 
     * @param ip
     *            objeto que marcado com o <i>annotation</i> {@code Inject}.
     * 
     * @return objeto {@code ResourceBundle}.
     */
    @Produces
    public ResourceBundle resourceBundleProduces(final InjectionPoint ip) {
        ResourceBundle resourceBundle = null;
        FacesContext context = FacesContext.getCurrentInstance();

        if (context == null) {
            resourceBundle = ResourceBundle.getBundle("messages", Locale.getDefault());
        } else {
            resourceBundle = context.getApplication().getResourceBundle(context, "msg");
        }

        return resourceBundle;
    }

}
