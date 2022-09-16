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
        int login = Integer.parseInt(request.getParameter("login"));
        String senha = request.getParameter("senha");

        UsuarioModel model = new UsuarioModel();
        Usuario autenticado = null;
        try {
            autenticado = model.login(login, senha);

            if (autenticado == null) {
                response.sendRedirect("LogarUsuario");
                System.out.println("DEU ERRADO");
            } else {

                HttpSession sessao = request.getSession(true);
                sessao.setAttribute("autenticado", autenticado);

                if ("s".equals(request.getParameter("manter"))) {
                    Cookie cookie = new Cookie("manterLogado", "manter");
                    //Calculo referente a 30 dias 
                    // 60s*60m*24horas*30dias
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    response.addCookie(cookie);
                }
                System.out.println(autenticado.getTipo() );
                System.out.println(autenticado.getNome() );
           
                switch (autenticado.getTipo()) { 
                    
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
        } catch (SQLException ex) {
            Logger.getLogger(LogarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
