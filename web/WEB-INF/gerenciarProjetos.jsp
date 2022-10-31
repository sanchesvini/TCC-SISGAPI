<%-- 
    Document   : gerenciarProjetos
    Created on : 12/10/2022, 11:05:31
    Author     : vinic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags/" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Gerenciar Projetos</title>
        
        <link rel="stylesheet" type="text/css" href="./CSS/default.css">
        <link rel="stylesheet" type="text/css" href="./CSS/header.css">
        
        <script src="https://unpkg.com/phosphor-icons"></script>
    </head>

    <body>
        <div class="page">
            <tags:headerAdm></tags:headerAdm>

            <div class="corpo">
                <h1>Gerenciar Projetos</h1>
                <c:forEach varStatus="status" var="projeto" items="${projetos}">

                    <form class="form" action="GerenciarProjeto?id=${projeto.id}" method="post">
                        <div id="infos-projeto">
                            <h3>${projeto.nome}</h3>
                            <p>${projeto.descricao}</p>
                            <c:choose>
                                <c:when test="${projeto.id_curso == 1}">
                                    <p>Técnico em Informática</p>
                                </c:when>
                                <c:when test="${projeto.id_curso == 2}">
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
