package com.projects.lham.infraestrutura.objetovalor;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class EnderecoEmail {

//	private static final String ENDERECO_EMAIL_PATTERN = "^(?!\.)(\"([^\"\r\\]|\\[\"\r\\])*\"|([-a-z0-9!#$%&\'*+/=?^_`{|}~] |(?@[a-z0-9][\w\.-]*[a-z0-9]\.[a-z][a-z\.]*[a-z]$";
	private String enderecoEmail;

	public EnderecoEmail(final String enderecoEmail) {
//		boolean valido = EmailValidator.getInstance().isValid(enderecoEmail);
		
		try {
			InternetAddress enderecoInternet = new InternetAddress(enderecoEmail);
			enderecoInternet.validate();
			this.enderecoEmail = enderecoEmail;
		} catch (AddressException e) {
			throw new RuntimeException("E-mail inválido.");
		}
		
//		if (valido) {
//			this.enderecoEmail = enderecoEmail;
//		} else {
//			throw new RuntimeException("E-mail inválido.");
//		}
		
//		if (this.isValido(enderecoEmail)) {
//			this.enderecoEmail = enderecoEmail;
//		}
	}

//	private boolean isValido(final String enderecoEmail) {
//		Pattern pattern = Pattern.compile("");
//		Matcher matcher = pattern.matcher(enderecoEmail);
//
//		boolean emailValido = matcher.matches();
//
//		if (!emailValido) {
//			throw new RuntimeException("E-mail inválido.");
//		}
//
//		return true;
//	}

	public String getEnderecoEmail() {
		return enderecoEmail;
	}
}
