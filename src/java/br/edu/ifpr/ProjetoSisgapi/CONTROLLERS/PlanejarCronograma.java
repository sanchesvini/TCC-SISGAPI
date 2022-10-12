/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.ProjetoSisgapi.CONTROLLERS;

import br.edu.ifpr.ProjetoSisgapi.DAOS.UsuarioDAO;
import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Usuario;
import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Atividade;
import br.edu.ifpr.ProjetoSisgapi.MODELS.AtividadeModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
@WebServlet(name = "PlanejarCronograma", urlPatterns = {"/PlanejarCronograma"})
public class PlanejarCronograma extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/planejarCronograma.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String atividade = request.getParameter("atividade");
        String prazo = request.getParameter("prazo");
        
        LocalDate prazo2 = LocalDate.parse(prazo);
        
        Date prazo3 = Date.valueOf(prazo2);
        //String prazoFormatado = prazo2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        
        HttpSession sessao = request.getSession();
        Usuario u = (Usuario) sessao.getAttribute("autenticado");
        
        UsuarioDAO udao = new UsuarioDAO();
        int id_projeto = 0;
        try {
            id_projeto = udao.getUserProject(u);
            Atividade atv = new Atividade(atividade, prazo3, id_projeto);
            AtividadeModel am = new AtividadeModel();
            am.create(atv);
            response.sendRedirect("WEB-INF/indexes/indexAluno.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(PlanejarCronograma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }


}
