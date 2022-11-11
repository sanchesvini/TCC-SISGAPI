<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags/" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt-BR">
    <head>
        <meta charset="utf-8">
        <title>Visualizar Projeto</title>

        <link rel="stylesheet" type="text/css" href="CSS/addProjeto.css">

        <link rel="stylesheet" type="text/css" href="./CSS/default.css">
        <link rel="stylesheet" type="text/css" href="./CSS/header.css">

        <script src="https://unpkg.com/phosphor-icons"></script>
    </head>
    <body>
        <tags:headerAdm></tags:headerAdm>
            <main>

                <div class="parent">

                    <h3>${projeto.nome}</h3>

                <div id="estudantes">
                    <h3>Estudantes</h3>
                    <div id="nome-estudantes">
                        <c:forEach varStatus="status" var="estudante" items="${estudantes}">
                            ${estudante.nome}
                        </c:forEach>
                    </div>
                </div>
                <div id="orientadores">
                    <h3>Orientadores</h3>
                    <div id="nome-orientadores">
                        <c:forEach varStatus="status" var="orientador" items="${orientadores}">
                            ${orientador.nome}
                        </c:forEach>
                    </div>
                </div>
                <div id="trab-em-andamento">
                    <fieldset>
                        <legend>Trabalho em andamento</legend>
                        <div>
                            <form method="post" action="DownloadProjeto?id=${projeto.id}">
                                ICONE ARQUIVO

                                <button type="submit" > Download</button>


                            </form>
                        </div>
                        <div>
                            Comentários do Professor do Projeto Integrador
                        </div>


                    </fieldset>
                </div>

            </div>
        </main>


        <tags:footer></tags:footer>
    
</body>

</html>
