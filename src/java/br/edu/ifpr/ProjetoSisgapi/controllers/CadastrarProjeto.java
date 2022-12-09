/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.ProjetoSisgapi.CONTROLLERS;

import br.edu.ifpr.ProjetoSisgapi.DAOS.ProjetoDAO;
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
@WebServlet(name = "CadastrarProjeto", urlPatterns = {"/CadastrarProjeto"})
public class CadastrarProjeto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //estudantes e orientador

        UsuarioModel umodel = new UsuarioModel();

        ArrayList<Usuario> estudantes = null;
        ArrayList<Usuario> orientadores = null;
        try {
            estudantes = umodel.getAllEstudantesSemProjeto();
            orientadores = umodel.getAllOrientadores();
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarProjeto.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("estudantes", estudantes);
        request.setAttribute("orientadores", orientadores);

        request.getRequestDispatcher("WEB-INF/cadastroProjetos.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        ArrayList<Integer> estudantes = new ArrayList<>();
        ArrayList<Integer> orientadores = new ArrayList<>();
        int estudante11, estudante22, estudante33, estudante44, orientador11, orientador22, orientador33;
        String estudante1, estudante2, estudante3, estudante4, orientador1, orientador2, orientador3;
        String nome_projeto, descricao;
        int tipo, id_curso;

        estudante1 = request.getParameter("estudante1");
        estudante2 = request.getParameter("estudante2");
        estudante3 = request.getParameter("estudante3");
        estudante4 = request.getParameter("estudante4");

        if (!estudante1.equals("0")) {
            estudante11 = Integer.parseInt(estudante1);
            estudantes.add(estudante11);
        } if (!estudante2.equals("0")) {
            estudante22 = Integer.parseInt(estudante2);
            estudantes.add(estudante22);
        } if (!estudante3.equals("0")) {
            estudante33 = Integer.parseInt(estudante3);
            estudantes.add(estudante33);
        } if (!estudante4.equals("0")) {
            estudante44 = Integer.parseInt(estudante4);
            estudantes.add(estudante44);
        } else {
            System.out.println("Nenhum estudante informado.");
        }

        orientador1 = request.getParameter("orientador1");
        orientador2 = request.getParameter("orientador2");
        orientador3 = request.getParameter("orientador3");

        if (!orientador1.equals("0")) {
            orientador11 = Integer.parseInt(orientador1);
            orientadores.add(orientador11);
        } if (!orientador2.equals("0")) {
            orientador22 = Integer.parseInt(orientador2);
            orientadores.add(orientador22);
        } if (!orientador3.equals("0")) {
            orientador33 = Integer.parseInt(orientador3);
            orientadores.add(orientador33);
        } else {
            System.out.println("Nenhum orientador informado.");
        }

        descricao = request.getParameter("descricao");

        nome_projeto = request.getParameter("projeto");

        tipo = Integer.parseInt(request.getParameter("informacao"));

        HttpSession sessao = request.getSession();
        Usuario adm = (Usuario) sessao.getAttribute("autenticado");
        id_curso = adm.getId_curso();

        Projeto projeto = new Projeto(nome_projeto, descricao, tipo, id_curso);

        ProjetoModel pmodel = new ProjetoModel();

        try { 
            pmodel.createProject(projeto, estudantes, orientadores);
            response.sendRedirect("CadastrarProjeto?m=Projeto cadastrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarProjeto.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("CadastrarProjeto?m=Erro ao cadastrar projeto.");
        }

    }

}
