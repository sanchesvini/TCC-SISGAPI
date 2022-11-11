<%-- 
    Document   : cadastro
    Created on : Aug 23, 2022, 8:03:22 PM
    Author     : vinic
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags/" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastrar Usuário</title>
        <link rel="stylesheet" type="text/css" href="./CSS/default.css">
        <link rel="stylesheet" type="text/css" href="./CSS/header.css">

        <script src="https://unpkg.com/phosphor-icons"></script>

        <style>

            .box{
                display: flex;
                align-self: center;
                justify-content: space-between;
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
            }
            .inputBox{
                position: relative;
                margin: 8%;


            }

            .inputUser{
                background: none;
                border: none;
                border-bottom: 1px solid black;
                outline: none;
                color: black;
                font-size: 15px;
                width: 25vw;
                letter-spacing: 2px;
            }
            .labelInput{
                position: absolute;
                top: 0px;
                left: 0px;
                pointer-events: none;
                transition: .5s;
            }
            .inputUser:focus ~ .labelInput,
            .inputUser:valid ~ .labelInput{
                top: -25px;
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

            #modalResultTrue{
                background-color: black;
                width: 50px;
            }
            #modalResultFalse{
                background-color: black;
                width: 50px;
            }
        </style>
    </head>
    <body>
        <tags:headerAdm></tags:headerAdm>

            <main>

                <div class="box">

                    <form action="CadastrarUsuario" method="POST">
                        <legend>Cadastrar Novo Usuário</legend>

                        <div class="inputBox radio-inp">
                            <input type="radio" name="tipo" id="iestudante" class="inputUser" value="3" required>
                            <label for="iestudante" class="labelInput">Estudante</label>
                        </div>
                        <div class="inputBox radio-inp">
                            <input type="radio" name="tipo" id="iorientador" class="inputUser" value="2" required>
                            <label for="iorientador" class="labelInput">Orientador</label>
                        </div>
                        <div class="inputBox radio-inp">
                            <input type="radio" name="tipo" id="iconvidado" class="inputUser" value="4" required>
                            <label for="iconvidado" class="labelInput">Convidado</label>
                        </div>

                        <div class="inputBox">
                            <input type="text" name="nome" id="inome" class="inputUser" required>
                            <label for="nome" class="labelInput">Nome completo</label>
                        </div>

                        <div class="inputBox">
                            <input type="text" name="email" id="email" class="inputUser" required>
                            <label for="email" class="labelInput">Email</label>
                        </div>

                        <div class="inputBox">
                            <input type="text" name="login" id="matricula" class="inputUser">
                            <label for="telefone" class="labelInput">Matricula</label>
                        </div>


                        <div class="inputBox">
                            <input type="password" name="senha" id="isenha" class="inputUser" required>
                            <label for="isenha" class="labelInput">Senha</label>
                        </div>

                        <div class="inputBox">
                            <input type="password" name="confirmarsenha" id="iconfirmar" class="inputUser" required>
                            <label for="estado" class="labelInput">Confirme a senha</label>
                        </div>

                        <button type="submit" name="submit" id="submit" onclick="exibirModal()">Enviar</button>


                    </form>
                </div>


            </main>

        <tags:footer></tags:footer>


    </body>

</html>




