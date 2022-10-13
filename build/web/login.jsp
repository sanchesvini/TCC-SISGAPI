<%-- 
    Document   : login
    Created on : 10/08/2022, 15:14:21
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="tags" tagdir="/WEB-INF/tags/" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Entrar</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./CSS/login.css">
    </head>
    <body>
        <header>
            <div class="topo"> SISGAPI </div>
        </header>
        <div class="conteudo">
            <div class="form">
                <form method="post" action="LogarUsuario">

                    <p class="p-inputs"> <label for="imatricula" > <img class="icons" src="CSS/login-alt.png""> </label>
                        <input type="number" size="40px" name="login" id="imatricula" placeholder="Digite sua matrícula" required>
                    </p> <br>
                    <p class="p-inputs"> <label for="isenha"> <img class="icons" src="CSS/trancar.png""> </label>
                        <input type="password" size="40px" name="senha" id="isenha" placeholder="Digite sua senha" required>
                        <br>

                    <p class="p-inputs"> <input id="inp-entrar" type="submit" name="enviar" value="Entrar">

                </form>
            </div>
        </div>
        <tags:footer></tags:footer>
    </body>

</html>

