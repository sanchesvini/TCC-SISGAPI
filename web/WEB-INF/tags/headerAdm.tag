<%-- 
    Document   : headerAdm
    Created on : 14/09/2022, 14:57:26
    Author     : vinic
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Header do sistema" pageEncoding="UTF-8"%>

<header>

    <div id="header-cima">
        <div class="logo"> 
            SISGAPI
        </div>


        <div id="logado">
            <i class="ph-identification-card" style="font-size: 2.8em;"></i>

            <div id="nome-logado">
                ${autenticado.nome}

                <div id="tipo-logado">
                    <c:choose>
                        <c:when test="${autenticado.tipo == 1}">
                            Administrador
                        </c:when>
                        <c:when test="${autenticado.tipo == 2}">
                            Orientador
                        </c:when>
                        <c:when test="${autenticado.tipo == 3}">
                            Estudante
                        </c:when>
                    </c:choose>
                </div>
            </div>

            <div id="sair">
                sair
            </div>

            <div id="btn-sair">
                <a href="Sair"><i class="ph-sign-out" style="font-size: 2em;"></i></a>
            </div>

        </div>
    </div>


    <nav>
        <ul class="menu">
            <li class="menu-item">
                <a href="CadastrarProjeto">Cadastrar Projeto</a>
            </li>
            <li class="menu-item">
                <a href="GerenciarProjetos">Gerenciar Projeto</a>
            </li>
            <li class="menu-item">
                <a href="CadastrarUsuario">Cadastrar Usuário</a>
            </li>


        </ul>
    </nav>





</header> 
