<%-- 
    Document   : gerenciarProjetos
    Created on : 12/10/2022, 11:05:31
    Author     : vinic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Gerenciar Projetos</title>
    </head>

    <body>
        <div class="page">
            <header>
                <nav id="menu" class="active2">
                    <ul>
                        <li> <a href="index.html">meu projeto</a></li>
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
                <h1>Gerenciar Projetos</h1>
                <c:forEach varStatus="status" var="projeto" items="${projetos}">

                    <form class="form" action="GerenciarProjeto?id=${projeto.id}" method="post">
                        <div id="infos-projeto">
                            <h3>${projeto.nome}</h3>
                            <p>${projeto.descricao}</p>
                            <c:choose>
                                <c:when test="${curso == 1}">
                                    <p>Técnico em Informática</p>
                                </c:when>
                                <c:when test="${curso == 2}">
                                    <p>Técnico em Produção de Moda</p>
                                </c:when>
                            </c:choose>
                        
                        </div>


                        <div id="prof-pi">
                            <h3>Professor do Projeto Integrador</h3>
                            <div>
                                ${adm.nome}
                            </div>
                        </div>



                        <div>
                            <input type="submit" value="acessar projeto">
                        </div>
                    </form>
                </c:forEach>

            </div>


            <footer>
                Copywrite SISGAPI © 2022 - Todos os direitos reservados
            </footer>
        </div>
    </body>

</html>
