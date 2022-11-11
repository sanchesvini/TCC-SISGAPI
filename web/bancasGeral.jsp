<%-- 
    Document   : telaCronograma
    Created on : 31/08/2022, 08:02:11
    Author     : vinic
--%>

<%@page import="br.edu.ifpr.ProjetoSisgapi.MODELS.ProjetoModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="tags" tagdir="/WEB-INF/tags/" %>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>

        <link rel="stylesheet" type="text/css" href="CSS/default.css"/>
        <link rel="stylesheet" type="text/css" href="./CSS/header.css">
        
        <script src="https://unpkg.com/phosphor-icons"></script>

        <style>
            * {
                margin: 0;
                padding: 0;
            }




            table, td, th {
                border: 1px solid black;
            }

            table {
               
                border-collapse: collapse;
                width: 70vw;
            }

            th, td {

                padding: 2%;
            }

            .button{
                float: right;
            }
            #bancas{
                padding: 3%;
            }

            #titulo{
                padding: 3% 1%;
            }
        </style>
    </head>
    <body>
        <header> 
            <div id="header-cima">
<!--                <div class="btn-voltar">
                    <i class="ph-skip-back" style="font-size: 2.8em;"></i>
                </div>-->
                <div class="logo"> 
                    SISGAPI
                </div>
            </div>
        </header>
        <main>


            <div id="bancas">
                <div id="titulo"> <h2> Bancas </h2></div>
                <table>
                    <tr>
                        <th>Projeto</th>
                        <th>Local</th>
                        <th>Data</th>
                        <th>Tipo</th>


                    </tr>
                    <c:forEach varStatus="status" var="banca" items="${bancas}">
                        <tr>
                            <td>

                                ${nomeProjetos[status.index]}
                            </td>
                            <td>
                                ${banca.local}
                            </td>
                            <td>
                                ${banca.data}
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${banca.tipo == 1}">
                                        Qualificação
                                    </c:when>
                                    <c:when test="${banca.tipo == 2}">
                                        Defesa
                                    </c:when>


                                </c:choose>

                            </td>

                        </tr>
                    </c:forEach>
                </table>
            </div>



        </main>
        <tags:footer></tags:footer>
    </body>
</html>
