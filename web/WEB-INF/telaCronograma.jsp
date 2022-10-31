<%-- 
    Document   : telaCronograma
    Created on : 31/08/2022, 08:02:11
    Author     : vinic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Cronograma </title>
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

        </header>
        <table>
            <tr>
                <th>Atividade</th>
                <th>Janeiro</th>
                <th>Fevereiro</th>
                <th>Março</th>
                <th>Abril</th>
                <th>Maio</th>
                <th>Junho</th>
                <th>Julho</th>
                <th>Agosto</th> 
                <th>Setembro</th> 
                <th>Outubro</th>
                <th>Novembro</th> 
                <th>Dezembro</th>

            </tr>
            <c:forEach varStatus="status" var="atividade" items="${atividades}">
                
                    <tr>
                        <td>${atividade.atividade} ${atividade.prazo.month}</td>
                        <td>
                            <c:choose>

                                <c:when test="${atividade.prazo.month == 0}">

                                    ${atividade.prazo}

                                </c:when>


                            </c:choose>
                        </td>
                        <td>
                            <c:choose>

                                <c:when test="${atividade.prazo.month == 1}">

                                    ${atividade.prazo}

                                </c:when>


                            </c:choose>
                        </td>
                        <td>
                            <c:choose>

                                <c:when test="${atividade.prazo.month == 2}">

                                    ${atividade.prazo}

                                </c:when>


                            </c:choose>
                        </td>
                        <td>
                            <c:choose>

                                <c:when test="${atividade.prazo.month == 3}">

                                    ${atividade.prazo}

                                </c:when>


                            </c:choose>
                        </td>
                        <td>
                            <c:choose>

                                <c:when test="${atividade.prazo.month == 4}">

                                    ${atividade.prazo}

                                </c:when>


                            </c:choose>
                        </td>
                        <td>
                            <c:choose>

                                <c:when test="${atividade.prazo.month == 5}">

                                    ${atividade.prazo}

                                </c:when>


                            </c:choose>
                        </td>
                        <td>
                            <c:choose>

                                <c:when test="${atividade.prazo.month == 6}">

                                    ${atividade.prazo}

                                </c:when>


                            </c:choose>
                        </td>
                        <td>
                            <c:choose>

                                <c:when test="${atividade.prazo.month == 7}">

                                    ${atividade.prazo}

                                </c:when>


                            </c:choose>
                        </td>
                        <td>
                            <c:choose>

                                <c:when test="${atividade.prazo.month == 8}">

                                    ${atividade.prazo}

                                </c:when>


                            </c:choose>
                        </td>
                        <td>
                            <c:choose>

                                <c:when test="${atividade.prazo.month == 9}">

                                    ${atividade.prazo}

                                </c:when>


                            </c:choose>
                        </td>
                        <td>
                            <c:choose>

                                <c:when test="${atividade.prazo.month == 10}">

                                    ${atividade.prazo}

                                </c:when>


                            </c:choose>
                        </td>
                        <td>
                            <c:choose>

                                <c:when test="${atividade.prazo.month == 11}">

                                    ${atividade.prazo}

                                </c:when>


                            </c:choose>
                        </td>

                    </tr>
         

            </c:forEach>
        </table>
        <footer>
            Copywrite SISGAPI  2022 - Todos os direitos reservados

        </footer>
    </body>
</html>
