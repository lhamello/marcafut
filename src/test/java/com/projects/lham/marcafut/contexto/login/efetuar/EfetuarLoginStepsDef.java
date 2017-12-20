package com.projects.lham.marcafut.contexto.login.efetuar;

//import com.projects.lham.contexto.login.efetuar.ServicoEfetuarLogin;
//import com.projects.lham.infraestrutura.excecao.CampoObrigatorioRuntimeException;
//import com.projects.lham.infraestrutura.excecao.ServicoRuntimeException;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class EfetuarLoginStepsDef {

    private String email = null;
    private String senha = null;
    // private ServicoEfetuarLogin servicoEfetuarLogin = new
    // ServicoEfetuarLogin();
    // private ServicoRuntimeException servicoRuntimeException;

    @Dado("^que nao preencho o campo	e-mail$")
    public void queNaoPreenchoOCampoEMail() throws Throwable {
        this.email = "";
    }

    @Dado("^que preencho o campo senha$")
    public void quePreenchoOCampoSenha() throws Throwable {
        this.senha = "1234";
    }

    @Quando("^tento logar no sistema$")
    public void tentoLogarNoSistema() throws Throwable {
        // try {
        // servicoEfetuarLogin.acessarSistema(email, senha);
        // } catch (ServicoRuntimeException excecao) {
        // servicoRuntimeException = excecao;
        // }
    }

    @Entao("^deve ser exigido o preenchimento do campo email$")
    public void deveSerExigidoOPreenchimentoDoCampoEmail() throws Throwable {
        // String mensagemErro = CampoObrigatorioRuntimeException.MENSAGEM_ERRO;
        // assertThat(servicoRuntimeException.getMessage(),
        // is(equalTo(String.format(mensagemErro, "E-mail"))));
    }
}
