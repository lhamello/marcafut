package com.projects.lham.marcafut.infraestrutura;

import com.projects.lham.marcafut.infraestrutura.excecao.CampoObrigatorioRuntimeException;
import org.apache.commons.lang3.Validate;

public final class ValidadorCampoObrigatorio {

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
