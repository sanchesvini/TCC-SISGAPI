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
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Planejejar Cronograma</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        <link rel="stylesheet" type="text/css" href="CSS/tudo.css">
        <link rel="stylesheet" type="text/css" href="CSS/planejarCronograma.css">


    </head>

    <body>
            <header>
        <div class = "head">
          <h1>SISGAPI</h1>  
        </div>              
      </header>

            <div class="main">
                <div class="box">
                    <form action="">
                      
                            <legend><b>Planejar Atividade</b></legend>
                            <br>
                            <div class="inputBox">
                                <input type="text" name="atividade" id="inome" class="inputUser" required>
                                <label for="Atividade" class="labelInput">Atividade</label>
                            </div>
                            <br><br>
                            <div class="inputBox">
                                <input type="date" name="data" id="data" class="inputUser" required>
                                <label for="email" class="labelInput"></label>
                            </div>
                            <br><br>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                                Adicionar Atividade
                            </button>



                    
                    </form>
                </div>
            </div>
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Sucesso</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Atividade adicionada com sucesso ao cronograma. Acesse a página de cronograma para ver todas as atividades.
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                                Cronograma
                            </button>
                        </div>
                    </div>
                </div>
            </div>

            <footer>
                Copywrite SISGAPI © 2022 - Todos os direitos reservados
            </footer>

        </div>
</body>
</html>
<script>
    function displayMenu() {
        var menu = document.getElementById('menu');
        menu.classList.toggle("active");

    }
</script>
