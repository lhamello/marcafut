package com.marcafut.util;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe respons�vel por produzir objetos que ser�o injetados em outras
 * classes.
 * 
 * @author Luiz Mello
 * 
 */
public class ProducesUtil {

    /**
     * Retorna um objeto {@code Logger} que poder� ser injetado em outras
     * classes para gerenciar as mensagens que ser�o mostradas na console do
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
     * Retorna um objeto {@code ResourceBundle} que poder� ser injetado em
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
