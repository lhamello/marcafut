package com.projects.lham.infraestrutura.objetovalor;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class EnderecoEmailTest {

	@ParameterizedTest
	@ValueSource(strings = { "prettyandsimple@example.com", 
							 "very.common@example.com", 
							 "disposable.style.email.with+symbol@example.com",
							 "other.email-with-dash@example.com",
							 "fully-qualified-domain@example.com",
							 "user.name+tag+sorting@example.com", // (will go to user.name@example.com inbox)
							 "x@example.com (one-letter local-part)",
							 "example-indeed@strange-example.com",
							 "admin@mailserver1", // (local domain name with no TLD, although ICANN highly discourages dotless email addresses)
							 "#!$%&'*+-/=?^_`{}|~@example.org",
							 "\"()<>[]:,;@\\\"!#$%&'-/=?^_`{}| ~.a\"@example.org",
							 "example@s.solutions (see the List of Internet top-level domains)",
							 "user@localserver",
							 "user@[2001:DB8::1]", 
							 "Abc\\@def@example.com",
							 "Fred\\ Bloggs@example.com",
							 "Joe.\\Blow@example.com",
							 "\"Abc@def\"@example.com",
							 "\"Fred Bloggs\"@example.com",
							 "customer/department=shipping@example.com",
							 "$A12345@example.com",
							 "!def!xyz%abc@example.com",
							 "_somename@example.com"})
	public void deveGerarEmailValido(final String enderecoEmail) {
		EnderecoEmail email = new EnderecoEmail(enderecoEmail);
		assertThat(email.getEnderecoEmail(), is(equalTo(enderecoEmail)));
	}
	
	// TODO: corrigir a classe e-mail para também passar nos testes que estão comentados
	@ParameterizedTest
	@ValueSource(strings = { "Abc.example.com", // (no @ character) 
							 "A@b@c@example.com", // (only one @ is allowed outside quotation marks)
							 "a\"b(c)d,e:f;g<h>i[j\\k]l@example.com", // (none of the special characters in this local-part are allowed outside quotation marks)
							 "just\"not\"right@example.com", // (quoted strings must be dot separated or the only element making up the local-part)
							 "this is\"not\\allowed@example.com", // (spaces, quotes, and backslashes may only exist when within quoted strings and preceded by a backslash)
							 "this\\ still\\\"not\\\\allowed@example.com", // (even if escaped (preceded by a backslash), spaces, quotes, and backslashes must still be contained by quotes)
							 "john.doe@example..com", // (double dot after @)
							 "Duy"
						   })
	public void naoDeveGerarEmailValido(final String enderecoEmail) {
		assertThrows(RuntimeException.class, () -> new EnderecoEmail(enderecoEmail));
	}
}
