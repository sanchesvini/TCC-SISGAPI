<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="tags" tagdir="/WEB-INF/tags/" %>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="utf-8">
        <title>Minhas Bancas</title>
        <link rel="stylesheet" type="text/css" href="pagcommenu.css">
        <link rel="stylesheet" type="text/css" href="CSS/telaBancaEstudantes.css">

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
            <div class="banca">
                <u><label for="">Minhas Bancas</label></u>
            </div>
            <div class="parent">

                <div class="qualificacao">


                    <u><label for="bancaQualificacao">Banca de QualificaÃ§Ã£o</label></u>
                    <div>
                        <div >
                            <label for="nomeProjeto">Nome do Projeto:</label>

                        </div>

                        <label for="orientandos">Orientados:</label>
                    </div>

                    <div>
                        <label for="orientadores">Orientadores:</label>
                    </div>

                    <div>
                        <label for="membrosBanca">Membros da Banca:</label>
                    </div>
                    <div>
                        <label for="data">Data:</label>
                    </div>

                    <label for="local">Local:</label>
                </div>



                <div class="defesa">
                    <div class="qualificacao">

                        <u> <label for="bancaDefesa">Banca de Defesa</label></u>
                        <div>

                            <div >
                                <label for="nomeProjeto">Nome do Projeto:</label>

                            </div>
                            <label for="orientandos">Orientados:</label>
                        </div>

                        <div>
                            <label for="orientadores">Orientadores:</label>
                        </div>

                        <div>
                            <label for="membrosBanca">Membros da Banca:</label>
                        </div>
                        <div>
                            <label for="data">Data:</label>
                        </div>

                        <label for="local">Local:</label>
                    </div>
                </div>



                <tags:footer></tags:footer>

            </div>
    </body>

    <script>
        function displayMenu() {
            var menu = document.getElementById('menu');
            menu.classList.toggle("active");

        }
    </script>
</html>
