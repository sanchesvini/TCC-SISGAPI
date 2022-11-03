 <!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags/" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt-BR">
    <head>
        <meta charset="utf-8">
        <title>Adicionar Projeto</title>

        <link rel="stylesheet" type="text/css" href="./CSS/default.css">
        <link rel="stylesheet" type="text/css" href="./CSS/header.css">

        <script src="https://unpkg.com/phosphor-icons"></script>

    </head>
    <body>

        <tags:headerAluno></tags:headerAluno>

            <main class="addprojeto">
                <div id="estudantes">
                    <h4>Estudantes</h4>
                    <div id="nome-estudantes">
                    <c:forEach varStatus="status" var="estudante" items="${estudantes}">
                        ${estudante.nome}
                    </c:forEach>
                </div>
            </div>
            <br><br>
            <div id="orientadores">
                <h3>Orientadores</h3>
                <div id="nome-orientadores">
                    <c:forEach varStatus="status" var="orientador" items="${orientadores}">
                        ${orientador.nome}
                    </c:forEach>
                </div>
            </div>
            <br><br>
            <div id="trab-em-andamento">
                <fieldset>
                    <legend>Trabalho em andamento</legend>
                    <div class="file">
                        <form method="post" action="AdicionarProjeto" enctype="multipart/form-data">
                            <input type="file" name="trabalho" value="Enviar">

                            <input type="submit" name="enviar" value="Enviar">
                        </form>
                    </div>
                    <div>
                        Comentários do Professor do Projeto Integrador
                    </div>


                </fieldset>
            </div>
            <br><br>
        </main>

        <tags:footer></tags:footer>
    </body>
</html>