<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags/" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt-BR">
    <head>
        <meta charset="utf-8">
        <title>Visualizar Projeto</title>

        <link rel="stylesheet" type="text/css" href="./CSS/default.css">
        <link rel="stylesheet" type="text/css" href="./CSS/header.css">

        <script src="https://unpkg.com/phosphor-icons"></script>

        <style>
            #erro{
                color: #ff9900;
            }
            #nome-estudantes, #nome-orientadores{
                margin: 2% 0;
            }
            #titulo-projeto{
                margin: 2% 0;
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
            <main>

                <div class="parent">

                    <h3 id="titulo-projeto">${projeto.nome}</h3>

                <div id="estudantes">
                    <h3>Estudantes</h3>
                    <div id="nome-estudantes">
                        <c:forEach varStatus="status" var="estudante" items="${estudantes}">
                            <div>${estudante.nome}</div>
                        </c:forEach>
                    </div>
                </div>
                <div id="orientadores">
                    <h3>Orientadores</h3>
                    <div id="nome-orientadores">
                        <c:forEach varStatus="status" var="orientador" items="${orientadores}">
                            <div>${orientador.nome}</div>
                        </c:forEach>
                    </div>
                </div>
                <div id="trab-em-andamento">
                    <fieldset>
                        <legend>Trabalho em andamento</legend>
                        <div id="trab-andamento-interno">
                            <form method="post" action="DownloadProjeto?id=${projeto.id}">
                                <i class="ph-folder-open" style="font-size: 2em"></i>

                                ${nomeArquivo}

                                <button type="submit" id="sub-file"> Download</button>
                                <div hidden id="erro">Não existe arquivo disponível para visualização.</div>

                            </form>
                        </div>
                        


                    </fieldset>
                </div>

            </div>
        </main>
        <tags:footer></tags:footer>
        <c:if test="${param.m != null}">
            <script>


                document.getElementById('erro').hidden = false;

            </script>

        </c:if>
    </body>

</html>
