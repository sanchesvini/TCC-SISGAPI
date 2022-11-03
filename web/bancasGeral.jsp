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
                <th>Projeto</th>
                <th>Local</th>
                <th>Data</th>
                <th>Tipo</th>


            </tr>
            <c:forEach varStatus="status" var="banca" items="${bancas}">

                <tr>
                    <td>

                        <%
                            int id_projeto = {banca.id_projeto};
                            ProjetoModel pmodel = new ProjetoModel();
                            String projeto = pmodel.getProjetoByIdProjeto(id_projeto).getNome();


                        %>

                        ${projeto}
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
        <tags:footer></tags:footer>
    </body>
</html>
