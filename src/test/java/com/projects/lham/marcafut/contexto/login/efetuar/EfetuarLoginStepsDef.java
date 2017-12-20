package com.projects.lham.marcafut.contexto.login.efetuar;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
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
    private UsuarioSistemaDTO usuarioSistemaDTO;

    @Dado("^que nao preencho o campo email$")
    public void queNaoPreenchoOCampoEmail() throws Throwable {
        this.email = "";
    }

    @Dado("^que preencho o campo senha$")
    public void quePreenchoOCampoSenha() throws Throwable {
        this.senha = "1234";
    }

    @Quando("^efetuo o login no sistema$")
    public void efetuoOLoginNoSistema() throws Throwable {
        try {
            usuarioSistemaDTO = servicoEfetuarLogin.efetuarLogin(email, senha);
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

    @Dado("^que sou um administrador do sistema$")
    public void queSouUmAdministradorDoSistema() throws Throwable {
        this.email = "admin@marcafut.com";
        this.senha = "admin123";
    }

    @Entao("^devo ter acesso a administracao do mesmo$")
    public void devoTerAcessoAAdministracaoDoMesmo() throws Throwable {
        assertThat(usuarioSistemaDTO.isAministrador(), is(true));
    }

    @Dado("^que sou um usuario comum$")
    public void queSouUmUsuarioComum() throws Throwable {
        this.email = "usuario.comum@marcafut.com";
        this.senha = "usuario.comum.123";
    }

    @Entao("^nao devo ter acesso a administracao do mesmo$")
    public void naoDevoTerAcessoAAdministracaoDoMesmo() throws Throwable {
        assertThat(usuarioSistemaDTO.isAministrador(), is(false));
    }
}