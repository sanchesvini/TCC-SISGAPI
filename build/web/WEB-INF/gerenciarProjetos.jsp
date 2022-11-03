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
        <tags:headerAdm></tags:headerAdm>

            <main class="gerenciar">
            <c:forEach varStatus="status" var="projeto" items="${projetos}">

                <form class="form" action="GerenciarProjeto?id=${projeto.id}" method="post">
                    <fieldset>
                        <legend> ${projeto.nome}</legend>
                        <br>
                        <div id="infos-projeto">

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
                        <br><br>

                        <div id="prof-pi">
                            <h4>Professor do Projeto Integrador</h4>
                            <div>
                                ${adm.nome}
                            </div>
                        </div>
                        <br><br>

                        <div class="botao">
                            <button type="submit" class="botao" name="acessar projeto">Acessar Projeto</button>
                        </div>
                    </fieldset>
                </form>
            </c:forEach>

        </main>
        <tags:footer></tags:footer>
    </div>
</body>

</html>