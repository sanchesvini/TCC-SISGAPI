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
        <title>cadastro de Projetos</title>

        <link rel="stylesheet" type="text/css" href="CSS/tudo.css">
        <link rel="stylesheet" type="text/css" href="CSS/cadastroProjetos2.css">

    </head>

    <body>
        <div class="page">
            <header>
                <nav id="menu" class="active2">
                    <ul>
                        <li> <a href="CadastrarProjeto">meu projeto</a></li>
                        <li><a href="#"> atividades</a></li>
                        <li> <a href="#"> documentos</a></li>
                        <li><a href="#"> apoio ao projeto</a></li>
                        <li><a href="#"> cronograma</a></li>
                        <li> <a href="cadastro.html">Cadastro</a></li>
                    </ul>
                </nav>
                <input type="checkbox" id="check">
                <label for="check">
                    <i class="ph-list" onclick="displayMenu()"></i>
                </label>
                <div class="topo"> SISGAPI </div>

            </header>

            <div class="corpo">
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
                    </div>
                


            </div>
            <footer>
                Copywrite SISGAPI © 2022 - Todos os direitos reservados
            </footer>
        </div>
    </body>
</html>
<script>
    function displayMenu() {
        var menu = document.getElementById('menu');
        menu.classList.toggle("active");

    }
</script>
