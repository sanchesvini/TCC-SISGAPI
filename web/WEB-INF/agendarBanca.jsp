<%-- 
    Document   : agendarBanca
    Created on : 14/09/2022, 13:42:38
    Author     : vinic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>cadastro de Projetos</title>
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


                <label for="projeto">Projeto<br>
                    <select name="informacao">
                        <option value="sisgapi">SISGAPI</option>
                        <option value="sisgapi">SISGAPI</option>
                </label>



                <input type="text" name="local" value=""placeholder="Digite o local da banca" required>
                <label for="ilocal">Local:</label>


                <input type="text" name="membros" value=""placeholder="Digite os membros da banca" required>
                <label for="ilocal">Membros:</label>

                <input type="radio" name="opcao" value="qualificacao"> Qualificação <br>
                <input type="radio" name="opcao" value="defesa"> Defesa <br>

                <input type="date" name="opcao" value="data"> Data <br>
                <button  >Enviar</button>

            </div>
        </fieldset>


        <footer>
            Copywrite SISGAPI © 2022 - Todos os direitos reservados
        </footer>
    </body>>
</html>>
