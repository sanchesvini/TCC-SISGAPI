<%-- 
    Document   : indexAdm
    Created on : 11/08/2022, 13:50:52
    Author     : usuario
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Início</title>
        <link rel="stylesheet" type="text/css" href="./CSS/pagWithMenu.css">
        <link rel="stylesheet" type="text/css" href="./CSS/indexes.css">
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
                    <img class="icons" src="./CSS/do-utilizador.png">
                    <div>
                        ${autenticado.nome} <br> 
                        <c:choose>
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
                        <button><a href="Sair">Sair</a></button>
                    </div>
                </div>
            </header>
            <nav id="menu" class="active2">
                <ul>
                    <li> <a href="index.html">meu projeto</a></li>
                    <li><a href="#"> atividades</a></li>
                    <li> <a href="#"> documentos</a></li>
                    <li><a href="#"> apoio ao projeto</a></li>
                    <li><a href="#"> cronograma</a></li>
                    <li> <a href="CadastrarUsuario">cadastrar novo usuário</a></li>
                    <li> <a href="CadastrarProjeto">cadastrar novo projeto</a></li>
                    <li> <a href="AgendarBanca">Agendar Banca</a></li>
                    
                    <li> <a href="PlanejarCronograma">Planejar Cronograma</a></li>
                    <li> <a href="GerenciarProjetos">Gerenciar Projetos</a></li>
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
                    
                    <a href="CadastrarProjeto">cadastrar novo projeto</a>
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
