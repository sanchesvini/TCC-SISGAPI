<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags/" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastrar Projeto</title>
        <link rel="stylesheet" type="text/css" href="./CSS/default.css">
        <link rel="stylesheet" type="text/css" href="./CSS/header.css">

        <script src="https://unpkg.com/phosphor-icons"></script>

        <style>

            .box{
                display: flex;
                align-self: center;
                justify-content: space-between;
                align-content: center;
                color: black;

                background-color: white;
                border-radius: 15px;

            }
            fieldset{
                border: 3px solid black;
            }
            legend{
                border: 1px solid black;
                padding: 10px;
                text-align: center;
                border-radius: 8px;
                width: 30vw;
                margin-top: 5%;
            }
            .inputBox{
                position: relative;
                margin: 3%;


            }
            .inputUser{
                background: none;
                border: none;
                border-bottom: 1px solid black;
                outline: none;
                color: black;
                display: block;
                width: 30vw;
                letter-spacing: 2px;
            }
            .labelInput{
                
                top: 0px;
                left: 0px;
                pointer-events: none;
                transition: .5s;
            }
            .inputUser:focus ~ .labelInput,
            .inputUser:valid ~ .labelInput{
                top: -30px;
                font-size: 12px;
                color: dodgerblue;
            }
            #submit{
                background-image: linear-gradient(to right,rgb(0, 92, 197), rgb(90, 20, 220));
                width: 100%;
                border: none;
                padding: 15px;
                color: #fff;
                font-size: 15px;
                cursor: pointer;
                border-radius: 10px;
            }
            #submit:hover{
                color: black;   /* enviar*/
            }
            select{
                margin: 4% 0;
                display: flex;
                justify-content: center;
                align-content: center;
            }
        </style>

    </head>
    <body>
        <tags:headerAdm></tags:headerAdm>
            
            <main>
                <div class="box">
                    <form action="CadastrarProjeto" method="POST">
                        <legend>Cadastrar Novo Projeto</legend>

                        <div class="inputBox">
                            <label for="estudantes" class="labelInput">Nome dos estudantes:</label>
                        <select id="estudantes" name="estudante1">
                            <option value="0">Selecione</option>
                            <c:forEach varStatus="status" var="estudante" items="${estudantes}">
                                <option value="${estudante.id}">${estudante.nome}</option>
                            </c:forEach>
                        </select>

                        <select id="estudantes" name="estudante2">
                            <option value="0">Selecione</option>
                            <c:forEach varStatus="status" var="estudante" items="${estudantes}">
                                <option value="${estudante.id}">${estudante.nome}</option>
                            </c:forEach>
                        </select>

                        <select id="estudantes" name="estudante3">
                            <option value="0">Selecione</option>
                            <c:forEach varStatus="status" var="estudante" items="${estudantes}">
                                <option value="${estudante.id}">${estudante.nome}</option>
                            </c:forEach>
                        </select>

                        <select id="estudantes" name="estudante4">
                            <option value="0">Selecione</option>
                            <c:forEach varStatus="status" var="estudante" items="${estudantes}">
                                <option value="${estudante.id}">${estudante.nome}</option>
                            </c:forEach>
                        </select>

                        
                    </div>

                    <div class="inputBox">
                        
                        <label for="orientadores" class="labelInput">Orientadores(as):</label>
                        <select name="orientador1">
                            <option value="0">Selecione</option>
                            <c:forEach varStatus="status" var="orientador" items="${orientadores}">
                                <option value="${orientador.id}">${orientador.nome}</option>
                            </c:forEach>

                        </select>
                        <select name="orientador2">
                            <option value="0">Selecione</option>
                            <c:forEach varStatus="status" var="orientador" items="${orientadores}">
                                <option value="${orientador.id}">${orientador.nome}</option>
                            </c:forEach>

                        </select>
                        <select name="orientador3">
                            <option value="0">Selecione</option>
                            <c:forEach varStatus="status" var="orientador" items="${orientadores}">
                                <option value="${orientador.id}">${orientador.nome}</option>
                            </c:forEach>

                        </select>

                        
                    </div>

                    <div class="inputBox">
                        <label for="projeto" class="labelInput">Projeto:</label>
                        <input type="text" name="projeto" id="projeto" class="inputUser" required>
                        

                    </div>

                    <div class="inputBox">
                        <label for="idescricao" class="labelInput">Descri????o do Projeto:</label>
                        <input type="text" name="descricao" id="idescricao" class="inputUser" required>
                        
                    </div>

                    <div class="inputBox">
                        <label for="informacao" class="labelInput">Informa????es:</label>
                        <select name="informacao" id="informacao">
                            <option value="1">Monografia</option><br><br>
                            <option value="2">Artigo Cient??fico</option>
                        </select>
                        
                    </div>
                    <input type="submit" name="submit" id="submit">
                </form>
            </div>

        </main>
        <tags:footer></tags:footer>
        
        <c:if test="${param.m != null}">
        <script>
            alert('${param.m}')
        </script>
        </c:if>

    </body>
</html>