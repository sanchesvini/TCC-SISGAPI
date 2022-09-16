<%-- 
    Document   : cadastroProjetos.jsp
    Created on : 07/09/2022, 16:13:21
    Author     : vinic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>cadastro de Projetos</title>
        <link rel="stylesheet" type="text/css" href="CSS/pagWithMenu.css">
        <link rel="stylesheet" type="text/css" href="CSS/cadastroProjetos2.css">
        <link rel="stylesheet" type="text/css" href="CSS/tudo.css">

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
                <li> <a href="">Cadastro</a></li>
                <li> <a href="CadastrarProjeto">cadastrar novo projeto</a></li>
            </ul>
        </nav>
        <div class="form">
            <form action="CadastrarProjeto" method="post" class="formCadProj">
                <!--<fieldset>-->


                    
                    <div class="estudantes">
                        <label>Adicionar Projeto</label>
                        <label for="iestudante">Estudante(s):</label><br><br>
                        <input type="text" name="estudante1" id="iestudante" placeholder="Digite o nome do estudante" required><br>
                        <input type="text" name="estudante2" placeholder="Digite a matricula do estudante"><br>
                        <input type="text" name="estudante3" placeholder="Digite a matricula do estudante" ><br>
                        <input type="text" name="estudante4" placeholder="Digite a matricula do estudante"><br>
                    </div>

                    <div class="orientadores">
                        <label for="iorientador1">Orientador(es):</label><br><br>
                        <input type="text" name="iorientador1" id="iorientador" placeholder="digite a matricula do orientador" required><br>
                        <input type="text" name="iorientador2" placeholder="digite a matricula do orientador"><br>
                        <input type="text" name="iorientador3" placeholder="digite a matricula do orientador"><br><br>

                    </div>

                    <div class="projeto">
                        <label for="iprojeto">Projeto:
                            <input type="text" name="projeto" id="iprojeto" placeholder="digite o nome do projeto">
                        </label>
                    </div>

                    <div class="texto">
                        <label for="informacoes">Informações:<br>
                            <select name="informacao">
                                <option value="monografia">Monografia</option>
                                <option value="artigo">Artigo Científico</option>
                        </label>
                        </select>
                    </div>

                    <button  class="button" type="submit" name="cadastrarProjeto">Cadastrar</button>
                <!--</fieldset>-->
            </form>
        </div>

        <footer>
            Copywrite SISGAPI © 2022 - Todos os direitos reservados
        </footer>
    </body>
</html>
<script>
    function displayMenu() {
        var menu = document.getElementById('menu');
        menu.classList.toggle("active");

    }
</script>
