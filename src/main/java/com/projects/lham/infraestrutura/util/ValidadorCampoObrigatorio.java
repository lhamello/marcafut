package com.projects.lham.infraestrutura.util;

import org.apache.commons.lang3.Validate;

import com.projects.lham.infraestrutura.excecao.CampoObrigatorioException;

public class ValidadorCampoObrigatorio {

	private ValidadorCampoObrigatorio() {
		throw new IllegalStateException("Classe utilitária.");
	}

	public static void verificarPreenchimento(final String campo, final String nomeCampo) {
		try {
			Validate.notBlank(campo);
		} catch (NullPointerException | IllegalArgumentException excecao) {
			throw new CampoObrigatorioException(nomeCampo, excecao);
		}
	}
}
