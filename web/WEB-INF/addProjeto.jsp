<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags/" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt-BR">
    <head>
        <meta charset="utf-8">
        <title>Adicionar Projeto</title>
        
        <link rel="stylesheet" type="text/css" href="CSS/cssGeral.css">
        
        <script src="https://unpkg.com/phosphor-icons"></script>
        
    </head>
    <body>
  
        <div class="sis">
               
       

           

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

    </div>


    <tags:footer></tags:footer>
</div>
</body>


</html>
