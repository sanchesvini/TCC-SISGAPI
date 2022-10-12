<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Visualizar Projeto</title>
        <link rel="stylesheet" type="text/css" href="pagcommenu.css">
        <link rel="stylesheet" type="text/css" href="CSS/addProjeto.css">
    </head>
    <body>
        <div class="sis">
            <header>
                <input type="checkbox" id="check">
                <label for="check">
                    <img src="menubotao.png" onclick="displayMenu()">
                </label>
                <div class="topo"> SISGAPI </div>
            </header>
        </div>
        <!--
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
        -->              
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


        <footer>
            Copywrite SISGAPI Â© 2022 - Todos os direitos reservados
        </footer>
    </div>
</body>

<script>
    function displayMenu() {
        var menu = document.getElementById('menu');
        menu.classList.toggle("active");

    }
    
    function visualizarArquivo(){
        let modal = document.getElementById('dialog-arquivo');
        modal.showModal();
    }
</script>
</html>
