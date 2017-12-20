package com.projects.lham.marcafut.contexto.login.efetuar;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import com.projects.lham.marcafut.infraestrutura.AbstractServicoRuntimeException;
import com.projects.lham.marcafut.infraestrutura.excecao.CampoObrigatorioRuntimeException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class EfetuarLoginStepsDef {

    private String email = null;
    private String senha = null;
    private ServicoEfetuarLogin servicoEfetuarLogin = new ServicoEfetuarLogin();
    private AbstractServicoRuntimeException servicoRuntimeException;

    @Dado("^que nao preencho o campo email$")
    public void queNaoPreenchoOCampoEmail() throws Throwable {
        this.email = "";
    }

    @Dado("^que preencho o campo senha$")
    public void quePreenchoOCampoSenha() throws Throwable {
        this.senha = "1234";
    }

    @Quando("^quando efetuo o login do sistema$")
    public void quandoEfetuoOLoginDoSistema() throws Throwable {
        try {
            servicoEfetuarLogin.acessarSistema(email, senha);
        } catch (AbstractServicoRuntimeException excecao) {
            servicoRuntimeException = excecao;
        }
    }

    @Entao("^deve ser exigido o preenchimento do campo email$")
    public void deveSerExigidoOPreenchimentoDoCampoEmail() throws Throwable {
        String mensagemErro = CampoObrigatorioRuntimeException.MENSAGEM_ERRO;
        assertThat(servicoRuntimeException.getMessage(), equalTo(String.format(mensagemErro, "E-mail")));
    }

    @Dado("^que preencho o campo email$")
    public void quePreenchoOCampoEmail() throws Throwable {
        this.email = "teste@teste.com";
    }

    @Dado("^que nao preencho o campo senha$")
    public void queNaoPreenchoOCampoSenha() throws Throwable {
        this.senha = "       ";
    }

    @Entao("^deve ser exigido o preenchimento do campo senha$")
    public void deveSerExigidoOPreenchimentoDoCampoSenha() throws Throwable {
        String mensagemErro = CampoObrigatorioRuntimeException.MENSAGEM_ERRO;
        assertThat(servicoRuntimeException.getMessage(), equalTo(String.format(mensagemErro, "Senha")));
    }
}