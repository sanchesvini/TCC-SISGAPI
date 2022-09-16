<%-- 
    Document   : telaCronograma
    Created on : 31/08/2022, 08:02:11
    Author     : vinic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <style>
            * {
                margin: 0;
                padding: 1;
            }
            header{
                background-color: SteelBlue;
                height: 70px;
                font-weight: bold;
                padding: 20px;
            }

            .topo{
                font-size: 50px;
                font-family: "Verdana";
                letter-spacing: 10px;
            }
            .entrar{
                float: right;
                align-content: center;
            }
            table, td, th {
                border: 1px solid black;
            }
            table, td, th {
                border: 2px solid black;
            }

            table {
                border-collapse: collapse;
                width: 100%;
            }

            th {
                height: 50px;
            }
            footer{
                position: absolute;
                bottom: 0;
                background: SteelBlue;
                width: 100%;
                padding-top: 40px;
                text-align: center;
                font-size: 22px;
            }

            .button{
                float: right;
            }
        </style>
    </head>
    <body>
        <header>
            <div class="topo"> SISGAPI </div>
            <div class="entrar"> <button type="button" name="button"><a href="login.html">Entrar</a></button></div>
        </header>
        <table>
            <tr>
                <th>Alunos</th>
                <th>Projeto</th>
                <th>Banca</th>
                <th>Data</th>
                <th>Hora</th>
                <th>Local</th>

            </tr>
            <c:forEach varStatus="status" var="" items="${}">
                <tr>
                    <td>${}</td>
                    <td>${}</td>
                    <td>${}</td>
                    <td>${}</td>
                    <td>${}</td>
                    <td>${}</td>
                    <td>${}</td>
                </tr>
            </c:forEach>
        </table>
        <footer>
            Copywrite SISGAPI  2022 - Todos os direitos reservados
            <div class="button">
                <button type="button" name="button"><a href="index.html">Voltar</a></button>
            </div>
        </footer>
    </body>
</html>
