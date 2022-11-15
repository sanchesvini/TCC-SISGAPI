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
        
        <style>
            .box-projeto{
                width: 30vw;
                padding: 2%;
                margin: 1%;
                border: 1px solid black;
                height: 25vh;
                
                
            }
            .gerenciar{
                display: flex;
                flex-wrap: wrap;
                align-content: center;
                justify-content: space-between;
            }
        </style>
    </head>

    <body>
       <c:choose>
            <c:when test="${autenticado.tipo == 1}">
                <tags:headerAdm></tags:headerAdm>
            </c:when>
            <c:when test="${autenticado.tipo == 2}">
                <tags:headerOrient></tags:headerOrient>
            </c:when>
            <c:when test="${autenticado.tipo == 3}">
                <tags:headerAluno></tags:headerAluno>
            </c:when>
        </c:choose>

            <main class="gerenciar">
            <c:forEach varStatus="status" var="projeto" items="${projetos}">

                <form class="form" action="GerenciarProjeto?id=${projeto.id}" method="post">
                    <div class="box-projeto">
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

                        <div class="botao">
                            <button type="submit" class="botao">Acessar Projeto</button>
                        </div>
                    </div>
                </form>
            </c:forEach>

        </main>
        <tags:footer></tags:footer>
    
</body>

</html>