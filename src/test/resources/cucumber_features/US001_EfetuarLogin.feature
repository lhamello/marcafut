# language: pt
# encoding: iso-8859-1
Funcionalidade: Efetuar Login
  
  Como um administrador ou um usuario comum
  Eu quero efetuar o login
  Para que eu possa ter acesso ao sistema Marcafut

  Cenario: Nao permitir logar sem informar campo email
    Dado que nao preencho o campo	e-mail
    E que preencho o campo senha
    Quando tento logar no sistema
    Entao deve ser exigido o preenchimento do campo email
