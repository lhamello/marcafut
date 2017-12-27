package br.com.lhamello.marcafut.infraestrutura.excecao;

import br.com.lhamello.marcafut.infraestrutura.AbstractServiceException;

public class CampoObrigatorioException extends AbstractServiceException {

    public static final String MENSAGEM_ERRO = "Campo de preenchimento obrigat�rio n�o informado: %s.";

    private static final long serialVersionUID = 1L;

    public CampoObrigatorioException(final String nomeCampo) {
        super(String.format(MENSAGEM_ERRO, nomeCampo));
    }
}
