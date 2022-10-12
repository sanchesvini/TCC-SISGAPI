<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Adicionar Projeto</title>
        <!--        <link rel="stylesheet" type="text/css" href="pagcommenu.css">
                <link rel="stylesheet" type="text/css" href="CSS/addProjeto.css">-->
        <!-- CSS only -->
        <!-- JavaScript Bundle with Popper -->
        <script src="https://unpkg.com/phosphor-icons"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
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

            <i class="ph-arrow-right"></i>
            <form>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1">
                </div>
                <div class="mb-3 form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

            <div class="modal" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Modal title</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <p>Modal body text goes here.</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>

<!--            <h3>${projeto.nome}</h3>

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


        </fieldset>-->
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
</script>
</html>
