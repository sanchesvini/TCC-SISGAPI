<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="tags" tagdir="/WEB-INF/tags/" %>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="utf-8">
        <title>Projeto</title>

        <script src="https://unpkg.com/phosphor-icons"></script>
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
        <!--<nav id="menu" class="active2">
          <ul>
            <li> <a href="index.html">meu projeto</a></li>
            <li><a href="#"> atividades</a></li>
            <li> <a href="#"> documentos</a></li>
            <li><a href="#"> apoio ao projeto</a></li>
            <li><a href="#"> cronograma</a></li>
            <li> <a href="cadastro.html">Cadastro</a></li>
          </ul>
        </nav>-->
        <div class="grid">
            <div class="fieldext">

                <fieldset>

                    <div class="field">
                        <h3>${projeto.nome}</h3>
                        <p>${projeto.descricao}</p>
                        <!-- adicionar info de qual curso o projeto está-->>
                    </div>


                    <div class="fieldint1">
                        <h3>Estudante(s)</h3>
                        <c:forEach  var="estudante" items="${estudantes}">
                            <p>${estudante.nome}</p>
                        </c:forEach>
                    </div>

                    <br>

                    <div class="fieldint2">
                        <h3>Orientadores</h3>
                        <c:forEach var="orientador" items="${orientadores}">
                            <p>${orientador.nome}</p>
                        </c:forEach>
                    </div>

                    <br>

                    <div class="fieldint3">
                        <h3>Professor do Projeto Integrador</h3>
                        <p>${adm.nome}</p>
                    </div>

                    <br>

                    <button type="submit" name="Adicionar Projeto">Adicionar Projeto</button>

                </fieldset>
            </div>
        </div>
        <tags:footer></tags:footer>
    </body>

    <!--<script>
      function displayMenu(){
        var menu = document.getElementById('menu');
        menu.classList.toggle("active");
  
      }
    </script>-->
</html>
