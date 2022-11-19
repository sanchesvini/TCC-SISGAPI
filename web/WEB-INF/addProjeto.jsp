 <!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags/" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt-BR">
    <head>
        <meta charset="utf-8">
        <title>gerenciar Projeto</title>

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
                        <div>
                            ${estudante.nome}
                        </div>
                    </c:forEach>
                </div>
            </div>
            
            <div id="orientadores">
                <h3>Orientadores</h3>
                <div id="nome-orientadores">
                    <c:forEach varStatus="status" var="orientador" items="${orientadores}">
                        <div>
                            ${orientador.nome}
                        </div>
                    </c:forEach>
                </div>
            </div>
            
            <div id="trab-em-andamento">
                <fieldset>
                    <legend>Trabalho em andamento</legend>
                    
                    <div id="trab-andamento-interno">
                        <form method="post" action="AdicionarProjeto" enctype="multipart/form-data">
                            <i class="ph-folder-open" style="font-size: 2em"></i>
                            <input type="file" name="trabalho" value="Enviar">

                            <input type="submit" name="enviar" value="Enviar" id="sub-file">
                        </form>
                    </div>
                    


                </fieldset>
            </div>
            <br><br>
        </main>

        <tags:footer></tags:footer>
        <c:if test="${param.m != null}">
        <script>
            alert('${param.m}')
        </script>
        </c:if>
        
    </body>
</html>