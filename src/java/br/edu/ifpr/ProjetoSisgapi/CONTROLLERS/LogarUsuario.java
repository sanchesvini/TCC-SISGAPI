/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.ProjetoSisgapi.CONTROLLERS;

import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Usuario;
import br.edu.ifpr.ProjetoSisgapi.MODELS.UsuarioModel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author usuario
 */
@WebServlet(name = "LogarUsuario", urlPatterns = {"/LogarUsuario"})
public class LogarUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long login = Long.parseLong(request.getParameter("login"));
        String senha = request.getParameter("senha");

        UsuarioModel model = new UsuarioModel();
        Usuario u = null;
        try {
            u = model.login(login, senha);

            if (u == null) {
                response.sendRedirect("LogarUsuario");
           
            } else {

                HttpSession sessao = request.getSession(true);
                sessao.setAttribute("autenticado", u);
                

               
           
                response.sendRedirect("AcessarIndex");

            }
        } catch (SQLException ex) {
            Logger.getLogger(LogarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
