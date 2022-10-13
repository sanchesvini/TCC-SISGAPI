/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.ProjetoSisgapi.CONTROLLERS;

import br.edu.ifpr.ProjetoSisgapi.DAOS.AtividadeDAO;
import br.edu.ifpr.ProjetoSisgapi.DAOS.UsuarioDAO;
import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Atividade;
import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Usuario;
import br.edu.ifpr.ProjetoSisgapi.MODELS.AtividadeModel;
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
@WebServlet(name = "AbrirCronograma", urlPatterns = {"/AbrirCronograma"})
public class AbrirCronograma extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession();
        Usuario u = (Usuario) sessao.getAttribute("autenticado");
        
        UsuarioDAO udao = new UsuarioDAO();
        
        try {
            int id_projeto = udao.getUserProject(u);
            
            AtividadeDAO adao = new AtividadeDAO();
            
            
            ArrayList<Atividade> atividades = adao.getAllProjectAtivitiesById_Project(id_projeto);
            
            AtividadeModel amodel = new AtividadeModel();
            ArrayList<Integer> meses = new ArrayList<>(); 
            
            for (int i = 0; i < atividades.size(); i++) {
              
                meses.add(amodel.getMesAtividade(atividades.get(i)));
            }
            
            request.setAttribute("atividades", atividades);
            request.setAttribute("meses", meses);
            
            
            System.out.println(atividades.size());
            System.out.println(meses.size());
            
            request.getRequestDispatcher("WEB-INF/telaCronograma.jsp").forward(request, response);
            
            for (Integer mes : meses) {
                System.out.println("Atividade contida no mês: " + mes);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbrirCronograma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
