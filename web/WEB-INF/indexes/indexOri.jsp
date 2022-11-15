<%-- 
    Document   : indexAdm
    Created on : 11/08/2022, 13:50:52
    Author     : usuario
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags/" %>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="utf-8">
        <title>SISGAPI - Início</title>
        <link rel="stylesheet" type="text/css" href="./CSS/default.css">
        <link rel="stylesheet" type="text/css" href="./CSS/header.css">

        <script src="https://unpkg.com/phosphor-icons"></script>
    </head>
    <body>
    <tags:headerOrient> </tags:headerOrient>


    <main>
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

        </p>

    </main>


    <tags:footer></tags:footer>
    
    <c:if test="${param.m != null}">
        <script>
            alert('${param.m}')
        </script>
        </c:if>
</div>
</body>

</html>