<%-- 
    Document   : cadastroProjetos.jsp
    Created on : 07/09/2022, 16:13:21
    Author     : vinic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="tags" tagdir="/WEB-INF/tags/" %>

<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Planejejar Cronograma</title>
        

        <link rel="stylesheet" type="text/css" href="CSS/default.css">
        <link rel="stylesheet" type="text/css" href="CSS/header.css">

        <script src="https://unpkg.com/phosphor-icons"></script>
        
        <style>
            
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
                top: -20px;
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
            select{
                margin-top: 20px;
                margin-bottom: 15px;
            }
            .radio{
                display: inline;
            }
        </style>
    </head>

    <body>
        <tags:headerAluno></tags:headerAluno>

            <main>
                <div class="box">
                    <form action="PlanejarCronograma" method="POST">

                        <legend><b>Planejar Atividade</b></legend>
                        <br>
                        <div class="inputBox">
                            <input type="text" name="atividade" id="atividade" class="inputUser" required>
                            <label for="atividade" class="labelInput">Atividade</label>
                        </div>
                        <br><br>
                        <div class="inputBox">
                            <input type="date" name="prazo" id="data" class="inputUser" required>
                            <label for="data" class="labelInput"></label>
                        </div>
                        <br><br>
                        <button type="submit" name="submit" id="submit">
                            Adicionar Atividade
                        </button>

                    </form>
                </div>
            </main>
        <tags:footer></tags:footer>
    </body>
</html>
