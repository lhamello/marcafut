package com.projects.lham.contexto.login.efetuar;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
		"src/test/resources/cucumber_features/US001_EfetuarLogin.feature" }, snippets = SnippetType.CAMELCASE)
public class EfetuarLoginTest {

}
