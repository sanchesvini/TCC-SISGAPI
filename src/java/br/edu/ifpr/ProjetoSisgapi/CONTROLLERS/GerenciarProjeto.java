/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.ProjetoSisgapi.CONTROLLERS;

import br.edu.ifpr.ProjetoSisgapi.DAOS.UsuarioDAO;
import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Projeto;
import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Usuario;
import br.edu.ifpr.ProjetoSisgapi.MODELS.ProjetoModel;
import br.edu.ifpr.ProjetoSisgapi.MODELS.UsuarioModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "GerenciarProjeto", urlPatterns = {"/GerenciarProjeto"})
public class GerenciarProjeto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        int id_projeto = Integer.valueOf(request.getParameter("id"));

        ProjetoModel pmodel = new ProjetoModel();
        UsuarioDAO udao = new UsuarioDAO();
        UsuarioModel umodel = new UsuarioModel();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Usuario> estudantes = new ArrayList<>();
        ArrayList<Usuario> orientadores = new ArrayList<>();

        try {
            Projeto p = pmodel.getProjetoByIdProjeto(id_projeto);

            usuarios = udao.getAllUsersProject(p.getId());

            for (Usuario usuario : usuarios) {
                if (umodel.isEstudante(usuario)) {
                    estudantes.add(usuario);
                } else if (umodel.isOrientador(usuario)) {
                    orientadores.add(usuario);
                }
            }

            request.setAttribute("estudantes", estudantes);
            request.setAttribute("orientadores", orientadores);
            //comentários do adm
            request.setAttribute("projeto", p);
            request.getRequestDispatcher("WEB-INF/gerenciarProjeto.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(GerenciarProjetos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
