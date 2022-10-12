<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Planejar Cronograma</title>
        <link rel="stylesheet" type="text/css" href="pagcommenu.css">
        <link rel="stylesheet" type="text/css" href="CSS/planejarCronograma.css">
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

            <form method="post" action="PlanejarCronograma">
                <fieldset>
                    <legend>Planejar Cronograma</legend>


                    <div class="form inuput">
                        <div class="atividade">
                            <label for="atividade">Atividade:</label>
                            <input type="text" name="atividade" placeholder=" Digite o nome da atividade"required >
                        </div>

                        <label for="dataAti">Prazo</label>
                        <input type="date" name="prazo">

                        <button type="submit" name="button">Adicionar Atividade</button>
                    </div>
                </fieldset>

            </form>


            <footer>
                Copywrite SISGAPI © 2022 - Todos os direitos reservados
            </footer>
        </div>
    </body>

    <script>
        function displayMenu() {
            var menu = document.getElementById('menu');
            menu.classList.toggle("active");

        }
    </script>
</html>
