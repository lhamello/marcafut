package com.marcafut.util;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class responsible for producing objects that will be injected into other
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
public class ProducesUtil {

    /**
     * Returns a @ code Logger} object that can be injected into other classes
     * to manage the messages that are displayed to the user or the system
     * console.
     * 
     * @param ip
     *            object containing the annotation injection
     * 
     * @return object {@code Logger}
     */
    @Produces
    public Logger loggerProduces(final InjectionPoint ip) {
        return LoggerFactory.getLogger(ip.getMember().getDeclaringClass().getCanonicalName());
    }

    /**
     * Retorna um objeto {@code ResourceBundle} que poderá ser injetado em
     * outras classes para a leitura das mensagem do bundle de mensagem.
     * 
     * @return objeto {@code ResourceBundle}.
     */
    @Produces
    public ResourceBundle resourceBundleProduces() {
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
