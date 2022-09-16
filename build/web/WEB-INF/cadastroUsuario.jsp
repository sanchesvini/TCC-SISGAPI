<%-- 
    Document   : cadastro
    Created on : Aug 23, 2022, 8:03:22 PM
    Author     : vinic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Cadastrar</title>
    <link rel="stylesheet" type="text/css" href="">
  </head>
  <body>
    <header>
    <div class="topo"> SISGAPI </div>
    </header>
    <div class="form">
      <form action="CadastrarUsuario" method="post">
          <p> <label for="inome"> Nome: </label>
          <input type="text" size="40px" name="nome" id="inome" placeholder="Digite seu nome completo">
        </p> <br>
        <p> <label for="iemail"> E-mail: </label>
          <input type="email" size="40px" name="email" id="iemail" placeholder="Digite um e-mail válido">
        </p> <br>
        <p> <label for="imatricula"> Login: </label>
          <input type="text" size="40px" name="login" id="imatricula" placeholder="Digite sua matrícula">
        </p> <br>
        <p> <label for="isenha"> Senha: </label>
          <input type="password" size="40px" name="senha" id="isenha" placeholder="Digite sua senha">
        </p> <br>
        <p> <label for="iconfirmar"> Confirmar Senha: </label>
          <input type="password" size="40px" name="confirmarsenha" id="iconfirmar" placeholder="Confirme sua senha">
        </p> <br>
         <input type="submit" name="enviar" value="Enviar">
      </form>
    </div>

    <footer>
      Copywrite SISGAPI  2022 - Todos os direitos reservado
    </footer>
  </body>
</html>
