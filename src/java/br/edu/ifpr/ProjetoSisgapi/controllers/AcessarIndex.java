/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.ProjetoSisgapi.CONTROLLERS;

import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vinic
 */
@WebServlet(name = "AcessarIndex", urlPatterns = {"/AcessarIndex"})
public class AcessarIndex extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession(true);
        Usuario u = (Usuario) sessao.getAttribute("autenticado");
        switch (u.getTipo()) { 
                    
                    case 1:
                        request.getRequestDispatcher("WEB-INF/indexes/indexAdm.jsp").forward(request, response);
                        break;
                    case 2:
                        request.getRequestDispatcher("WEB-INF/indexes/indexOri.jsp").forward(request, response);
                        break;
                    case 3:
                        request.getRequestDispatcher("WEB-INF/indexes/indexAluno.jsp").forward(request, response);
                        break;
                    default:
                        break;
                }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  
}
