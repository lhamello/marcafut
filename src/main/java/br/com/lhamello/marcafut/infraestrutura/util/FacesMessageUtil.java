package br.com.lhamello.marcafut.infraestrutura.util;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;

import org.omnifaces.util.Messages;

/**
 * Created by rmpestano on 07/02/17.
 */
@ApplicationScoped
public class FacesMessageUtil implements Serializable {

    private static final long serialVersionUID = 1L;

    public static void addDetailMessage(String message, FacesMessage.Severity severity) {
        FacesMessage facesMessage = Messages.create("").detail(message).get();
        
        if (severity != null && severity != FacesMessage.SEVERITY_INFO) {
            facesMessage.setSeverity(severity);
        } else {
            Messages.add(null, facesMessage);
        }
    }
}
