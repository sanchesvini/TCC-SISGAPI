<%-- 
    Document   : telaCronograma
    Created on : 31/08/2022, 08:02:11
    Author     : vinic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="tags" tagdir="/WEB-INF/tags/" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Cronograma </title>

        <link rel="stylesheet" type="text/css" href="./CSS/default.css">
        <link rel="stylesheet" type="text/css" href="./CSS/header.css">
        <script src="https://unpkg.com/phosphor-icons"></script>
        

        <style>
            * {
                margin: 0;
                padding: 1;
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



            #cronograma{
                padding: 3%;
            }
            #titulo-projeto{
                padding: 3% 1%;
            }

        </style>
    </head>
    <body>
        <c:choose>
            <c:when test="${autenticado.tipo == 1}">
                <tags:headerAdm></tags:headerAdm>
            </c:when>
            <c:when test="${autenticado.tipo == 2}">
                <tags:headerOrient></tags:headerOrient>
            </c:when>
            <c:when test="${autenticado.tipo == 3}">
                <tags:headerAluno></tags:headerAluno>
            </c:when>
        </c:choose>

        <div id="cronograma">
            <div id="titulo-projeto"> <h2> Cronograma do Projeto ${projeto.nome} </h2></div>

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
                        <td>${atividade.atividade}</td>
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
        </div>
        <tags:footer></tags:footer>
    </body>
</html>
