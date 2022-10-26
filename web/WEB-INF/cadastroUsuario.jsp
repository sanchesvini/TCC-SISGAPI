<%-- 
    Document   : cadastro
    Created on : Aug 23, 2022, 8:03:22 PM
    Author     : vinic
--%>


<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastrar Usuário</title>
         <link rel="stylesheet" type="text/css" href="CSS/tudo.css">
        
        <style>
            body{
                font-family: Arial, Helvetica, sans-serif;

            }
            .box{
                color: black;
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%,-50%);
                background-color: white;
                border-radius: 15px;
                width: 30%;
            }
            fieldset{
                border: 3px solid black;
            }
            legend{
                border: 1px solid black;
                padding: 10px;
                text-align: center;
                border-radius: 8px;
            }
            .inputBox{
                position: relative;
            }
            .inputUser{
                background: none;
                border: none;
                border-bottom: 1px solid black;
                outline: none;
                color: black;
                font-size: 15px;
                width: 100%;
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
                top: -30px;
                font-size: 12px;
                color: dodgerblue;
            }
            #submit{
                background-image: linear-gradient(to right,rgb(0, 92, 197), rgb(90, 20, 220));
                width: 100%;
                border: none;
                padding: 15px;
                color: black;
                font-size: 15px;
                cursor: pointer;
                border-radius: 10px;
            }
            #submit:hover{
                color: orange;   /* enviar*/
            }
        </style>
    </head>
    <body>
        <header>
            <div class = "head">
                <h1>SISGAPI</h1>  
            </div>              
        </header>
        <div class="box">
            <form action="">
                    <legend><b>Cadastrar Novo Usuário</b></legend>
                    <br>
                    <div class="inputBox">
                        <input type="text" name="nome" id="inome" class="inputUser" required>
                        <label for="nome" class="labelInput">Nome completo</label>
                    </div>
                    <br><br>
                    <div class="inputBox">
                        <input type="text" name="email" id="email" class="inputUser" required>
                        <label for="email" class="labelInput">Email</label>
                    </div>
                    <br><br>
                    <div class="inputBox">
                        <input type="text" name="login" id="matricula" class="inputUser" required>
                        <label for="telefone" class="labelInput">Matricula</label>
                    </div>

                    <br><br><br>
                    <div class="inputBox">
                        <input type="password" name="senha" id="isenha" class="inputUser" required>
                        <label for="cidade" class="labelInput">Senha</label>
                    </div>
                    <br><br>
                    <div class="inputBox">
                        <input type="password" name="confirmarsenha" id="iconfirmar" class="inputUser" required>
                        <label for="estado" class="labelInput">Confirme a senha</label>
                    </div>
                    <br><br>
                    <input type="submit" name="submit" id="submit">
            </form>
        </div>

    </body>
    <footer>
        Copywrite SISGAPI © 2022 - Todos os direitos reservados
    </footer>
</html>