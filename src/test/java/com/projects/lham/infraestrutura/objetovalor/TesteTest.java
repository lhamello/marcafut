package com.projects.lham.infraestrutura.objetovalor;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class TesteTest {

	@Test
	public void teste() {
		assertThat(true, is(true));
	}
}
