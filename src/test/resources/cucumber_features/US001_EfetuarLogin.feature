# language: pt
# encoding: iso-8859-1
Funcionalidade: Efetuar Login
  
  Como um administrador ou um usuario comum
  Eu quero efetuar o login
  Para que eu possa ter acesso ao sistema marcafut

  Cenario: Nao permitir logar sem informar o campo email
    Dado que nao preencho o campo email
    E que preencho o campo senha
    Quando quando efetuo o login do sistema
    Entao deve ser exigido o preenchimento do campo email

  Cenario: Nao permitir logar sem informar o campo senha
    Dado que preencho o campo email
    E que nao preencho o campo senha
    Quando quando efetuo o login do sistema
    Entao deve ser exigido o preenchimento do campo senha

  @NaoAutomatizar
  Cenario: Nao permitir logar sem informar os campos email e senha
    Dado que nao preencho o campo email
    E que nao preencho o campo senha
    Quando quando efetuo o login do sistema
    Entao deve ser exigido o preenchimento do campo email
    E deve ser exigido o preenchimento do campo senha
