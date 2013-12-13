package com.marcafut.infra;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.inject.Inject;

import org.slf4j.Logger;

import com.marcafut.util.MessageBundleUtil;

/**
 * Classe abstrata que define o comportamento das classes de entidade do
 * sistema.
 * 
 * @author Luiz Mello
 * 
 * @param <K>
 *            tipo da chave primária da entidade.
 */
public abstract class AbstractModel<K> implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    protected Logger logger;
    @Inject
    protected MessageBundleUtil bundle;
    
    /**
     * Retorna a chave única da entidade, do tipo {@code K}.
     * 
     * @return chave única da entidade.
     */
    public abstract K getId();
    
    /**
     * Monta uma {@code String} que descreve a classe: contém nome de atributos
     * e seus valores.
     */
    @Override
    @SuppressWarnings("rawtypes")
    public String toString() {
        Class clazz = this.getClass();
        
        StringBuilder stObjeto = new StringBuilder(500);
        stObjeto.append(clazz.getName()).append('[');
        
        // Pega os atributos declarados na classe
        Field[] fields = clazz.getDeclaredFields();
        // itera sobre a lista de atributos para montar a string de retorno
        for (int i = 0; i < fields.length; i++) {
            if (i != 0) {
                stObjeto.append(',');
            }

            Field field = fields[i];
            field.setAccessible(true);

            try {
                stObjeto.append(field.getName()).append('=').append(field.get(this));
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                StringBuilder msgWarn = new StringBuilder();
                
                msgWarn.append(this.getClass().getSimpleName()).append('[');
                msgWarn.append(bundle.getMessage("error.attribute.access")).append(": ").append(field);
                msgWarn.append(']');
                
                logger.warn(msgWarn.toString(), ex);
            }
        }

        stObjeto.append(']');
        return stObjeto.toString();
    }
    
}
