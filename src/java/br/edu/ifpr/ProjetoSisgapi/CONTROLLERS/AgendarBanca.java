/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.ProjetoSisgapi.CONTROLLERS;

import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Projeto;
import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Usuario;
import br.edu.ifpr.ProjetoSisgapi.MODELS.ProjetoModel;
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
@WebServlet(name = "AgendarBanca", urlPatterns = {"/AgendarBanca"})
public class AgendarBanca extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ProjetoModel pmodel = new ProjetoModel();
        
        HttpSession sessao = request.getSession();
        Usuario u = (Usuario) sessao.getAttribute("autenticado");
        int id_curso = u.getId_curso();
        
        try {
            ArrayList<Projeto> projetos = pmodel.getAllProjetosByIdCurso(id_curso);
            
            request.setAttribute("projetos", projetos);
            request.getRequestDispatcher("WEB-INF/agendarBanca.jsp").forward(request, response); 
        } catch (SQLException ex) {
            Logger.getLogger(AgendarBanca.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //id_projeto, local, membros, tipo, data
    }


}
