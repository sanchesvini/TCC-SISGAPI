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
@WebServlet(name = "DownloadProjeto", urlPatterns = {"/DownloadProjeto"})
public class DownloadProjeto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        int id_projeto = Integer.parseInt(request.getParameter("id"));

        ProjetoModel model = new ProjetoModel();

        try {
            //adm tem acesso a todos os projetos do curso que ele é adm 
            HttpSession sessao = request.getSession();

            Usuario u = (Usuario) sessao.getAttribute("autenticado");

            Projeto p = model.getProjetoByIdProjeto(id_projeto);

            response.setContentType(p.getTipo_arquivo());

            byte[] arquivoProjeto = p.getProjeto();
            if (arquivoProjeto == null) {
                response.sendRedirect("GerenciarProjeto?id=" + id_projeto +"&m=Não existe arquivo disponível para visualização.");
            } else {
                response.getOutputStream().write(p.getProjeto());
            }

            

        } catch (SQLException ex) {
            Logger.getLogger(DownloadProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
