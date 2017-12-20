package com.projects.lham.marcafut.infraestrutura;


import com.projects.lham.marcafut.infraestrutura.excecao.CampoObrigatorioRuntimeException;

public final class ValidadorCampoObrigatorio {

    private ValidadorCampoObrigatorio() {
        throw new IllegalStateException("Classe utilitária.");
    }

    public static void verificarPreenchimento(final String campo, final String nomeCampo) {
        if (ehNulo(campo) || ehVazio(campo) || contemSomenteEspacoesEmBranco(campo)) {
            throw new CampoObrigatorioRuntimeException(nomeCampo);
        }
    }

    private static boolean ehNulo(final String campo) {
        return campo == null;
    }

    private static boolean ehVazio(final String campo) {
        return campo.length() == 0;
    }

    private static boolean contemSomenteEspacoesEmBranco(final String campo) {
        boolean contemSomenteEspacosEmBranco = true;
        
        for (int i = 0; i < campo.length(); i++) {

            if (!Character.isWhitespace(campo.charAt(i))) {
                contemSomenteEspacosEmBranco = false;
                break;
            }
        }

        return contemSomenteEspacosEmBranco;
    }
}
