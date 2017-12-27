package br.com.lhamello.marcafut.contexto.controleacesso;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/historias_usuario_features/US001_EfetuarLogin.feature", 
                 glue = "br.com.projects.lham.contexto.controleacesso", 
                 monochrome = true, 
                 plugin = { "pretty", "html:target/html", "json:cucumber.json" }, 
                 snippets = SnippetType.CAMELCASE)
public class EfetuarLoginTest {

}
