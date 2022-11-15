/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.ProjetoSisgapi.CONTROLLERS;

import br.edu.ifpr.ProjetoSisgapi.DAOS.ProjetoDAO;
import br.edu.ifpr.ProjetoSisgapi.DAOS.UsuarioDAO;
import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Projeto;
import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Usuario;
import br.edu.ifpr.ProjetoSisgapi.MODELS.ProjetoModel;
import br.edu.ifpr.ProjetoSisgapi.MODELS.UsuarioModel;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author vinic
 */
@MultipartConfig(maxFileSize = 8 * 1024 * 1024 * 5)
@WebServlet(name = "AdicionarProjeto", urlPatterns = {"/AdicionarProjeto"})
public class AdicionarProjeto extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //nome do projeto, estudantes, orientadores, comentários do adm
        
        HttpSession sessao = request.getSession();
        Usuario estudante = (Usuario) sessao.getAttribute("autenticado");
        
        ProjetoModel pmodel = new ProjetoModel();
        UsuarioDAO udao = new UsuarioDAO();
        UsuarioModel umodel = new UsuarioModel();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Usuario> estudantes = new ArrayList<>();
        ArrayList<Usuario> orientadores = new ArrayList<>();
        
        try {
            ArrayList<Projeto> projeto = pmodel.getProjetosByIdUsuario(estudante.getId());
            
            usuarios = udao.getAllUsersProject(projeto.get(0).getId());
            
            for (Usuario usuario : usuarios) {
                if(umodel.isEstudante(usuario)){
                    estudantes.add(usuario);
                }else if(umodel.isOrientador(usuario)){
                    orientadores.add(usuario);
                }
            }
            
            request.setAttribute("estudantes", estudantes);
            request.setAttribute("orientadores", orientadores);
            request.setAttribute("projeto", projeto);
            //comentários do adm
            
            for(int i=0; i<estudantes.size(); i++) {
                System.out.println(estudantes.get(i).getNome());
            }
            request.getRequestDispatcher("WEB-INF/addProjeto.jsp").forward(request, response); 
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AdicionarProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        Part part = request.getPart("trabalho");
        
        String tipo = part.getContentType();
        
        byte[] trabalho = new byte[part.getInputStream().available()];
        
        part.getInputStream().read(trabalho);
        
        ProjetoModel pmodel = new ProjetoModel();
        
        HttpSession sessao = request.getSession();
        Usuario u = (Usuario) sessao.getAttribute("autenticado");
        
        
        
        int id_projeto;
        try {
            id_projeto = pmodel.getProjetosByIdUsuario(u.getId()).get(0).getId();
            
            pmodel.anexarTrabalho(trabalho, tipo, id_projeto);
            
            response.sendRedirect("GerenciarProjeto?m=Projeto anexado com sucesso.");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AdicionarProjeto.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("GerenciarProjeto?m=Erro ao anexar projeto.");
        }
        
        

        
    }

}
