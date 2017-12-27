package br.com.lhamello.marcafut.infraestrutura;


import br.com.lhamello.marcafut.infraestrutura.excecao.CampoObrigatorioException;

public final class ValidadorCampoObrigatorio {

    private ValidadorCampoObrigatorio() {
        throw new IllegalStateException("Esta classe n�o pode ser instanciada.");
    }

    public static void verificarPreenchimento(final String campo, final String nomeCampo) {
        if (ehNulo(campo) || ehVazio(campo) || contemSomenteEspacoesEmBranco(campo)) {
            throw new CampoObrigatorioException(nomeCampo);
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
