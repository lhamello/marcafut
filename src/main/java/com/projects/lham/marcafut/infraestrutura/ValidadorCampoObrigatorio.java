package com.projects.lham.marcafut.infraestrutura;

import org.apache.commons.lang3.Validate;

import com.projects.lham.marcafut.infraestrutura.excecao.CampoObrigatorioRuntimeException;

public class ValidadorCampoObrigatorio {

    private ValidadorCampoObrigatorio() {
        throw new IllegalStateException("Classe utilitária.");
    }

    public static void verificarPreenchimento(final String campo, final String nomeCampo) {
        try {
            Validate.notBlank(campo);
        } catch (NullPointerException | IllegalArgumentException excecao) {
            throw new CampoObrigatorioRuntimeException(nomeCampo, excecao);
        }
    }
}
