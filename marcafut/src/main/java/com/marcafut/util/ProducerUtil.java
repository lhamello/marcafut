package com.marcafut.util;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe respons�vel por produzir objetos que ser�o injetados em outras
 * classes.
 * 
 * @author Luiz Mello
 * 
 */
public class ProducerUtil {

    /**
     * Retorna um objeto {@code Logger} que poder� ser injetado em outras
     * classes para gerenciar as mensagens que ser�o mostradas na console do
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
