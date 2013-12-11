package com.marcafut.util;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe responsável por produzir objetos que serão injetados em outras
 * classes.
 * 
 * @author Luiz Mello
 * 
 */
public class ProducerUtil {

    /**
     * Retorna um objeto {@code Logger} que poderá ser injetado em outras
     * classes para gerenciar as mensagens que serão mostradas na console do
     * sistema.
     * 
     * @param ip
     * 
     * @return objeto {@code Logger}.
     */
    @Produces
    public Logger produceLogger(final InjectionPoint ip) {
        return LoggerFactory.getLogger(ip.getMember().getDeclaringClass().getCanonicalName());
    }

}
