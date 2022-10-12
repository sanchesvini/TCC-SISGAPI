<%-- 
    Document   : index2
    Created on : 28/07/2022, 13:46:01
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Index 2</title>
        <link rel="stylesheet" type="text/css" href="./CSS/pagcommenu.css">
        <link rel="stylesheet" type="text/css" href="./CSS/index2.css">
    </head>
    <body>
        <div class="sis">
            <header>
                <input type="checkbox" id="check">
                <label for="check">
                    <img src="./CSS/menubotao.png" onclick="displayMenu()">
                </label>

                <div class="topo"> SISGAPI </div>
                <div id="infos-usuario">
                    ${autenticado.nome} </br>
                    
                    <<c:choose>
                        <c:when test="${autenticado.tipo == 1}">
                            Administrador
                        </c:when>
                        <c:when test="${autenticado.tipo == 2}">
                            Orientador
                        </c:when>
                        <c:when test="${autenticado.tipo == 3}">
                            Estudante
                        </c:when>
                    </c:choose>
                </div>
            </header>
            <nav id="menu" class="active2">
                <ul>
                    <li> <a href="index.html">meu projeto</a></li>
                    <li><a href="#"> atividades</a></li>
                    <li> <a href="#"> documentos</a></li>
                    <li><a href="#"> apoio ao projeto</a></li>
                    <li><a href="#"> cronograma</a></li>
                    <li> <a href="cadastro.html">Cadastro</a></li>
                    <li> <a href="PlanejarCronograma">Planejar Cronograma</a></li>
                    <li> <a href="AbrirCronograma">Ver Cronograma</a></li>
                    <li> <a href="AdicionarProjeto">Adicionar projeto</a></li>
                </ul>
            </nav>

            <div class="container">
                <p>
                    Sistema de Gerenciamento
                </p>
                <p>
                    do
                </p>
                <p>
                    Projeto Integrador
                </p>
                <br>
                <p>
                    Organize seu projeto de conclusão
                </p>
                <p>
                    de curso com sua equipe!
                </p>
            </div>
            <br>
            <div class="button">
                <input type="button" value="Escolher curso" <a href="cursos.html"></a>
            </div>

            <footer>
                Copywrite SISGAPI © 2022 - Todos os direitos reservados
            </footer>
        </div>
    </body>

    <script>
        function displayMenu() {
            var menu = document.getElementById('menu');
            menu.classList.toggle("active");

        }
    </script>
</html>

