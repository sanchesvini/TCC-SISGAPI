<%-- 
    Document   : agendarBanca
    Created on : 14/09/2022, 13:42:38
    Author     : vinic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Agendar banca</title>
        <link rel="stylesheet" type="text/css" href="CSS/tudo.css">
        <link rel="stylesheet" type="text/css" href="CSS/AgendarBanca.css">


    </head>

    <body>

        <header>
            <input type="checkbox" id="check">
            <label for="check">
                <img src="menubotao.png" onclick="displayMenu()">
            </label>
            <div class="topo"> SISGAPI </div>
        </header>
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

        <fieldset>
            <legend>Agendar Banca</legend>

            <div class="parent">

                <form method="POST" action="AgendarBanca">
                    <label for="projeto">Projeto<br>
                    <select name="projeto">
                        <c:forEach varStatus="status" var="projeto" items="${projetos}">
                            <option value="${projeto.id}">${projeto.nome}</option>
                        </c:forEach>
                </label>



                <input type="text" name="local" value=""placeholder="Digite o local da banca" required>
                <label for="ilocal">Local:</label>


                <input id="imembros" type="text" name="membro1" placeholder="Digite a matricula do membro da banca" required>
                <input id="imembros" type="text" name="membro2" placeholder="Digite a matricula do membro da banca">
                <input id="imembros" type="text" name="membro3" placeholder="Digite a matricula do membro da banca">
                <input id="imembros" type="text" name="membro4" placeholder="Digite a matricula do membro da banca"> 
                <input id="imembros" type="text" name="membro5" placeholder="Digite a matricula do membro da banca">
                <label for="imembros">Membros:</label>

                <input type="radio" name="opcao" value="1"> Qualificação <br>
                <input type="radio" name="opcao" value="2"> Defesa <br>

                <input type="date" name="data" value="data"> Data <br>
                <input type="submit" name="enviar" value="Enviar">
                </form>
                

            </div>
        </fieldset>


        <footer>
            Copywrite SISGAPI © 2022 - Todos os direitos reservados
        </footer>
    </body>>
</html>>
