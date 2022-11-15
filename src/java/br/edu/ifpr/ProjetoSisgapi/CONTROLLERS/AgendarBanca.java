/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.ProjetoSisgapi.CONTROLLERS;

import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Banca;
import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Projeto;
import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Usuario;
import br.edu.ifpr.ProjetoSisgapi.MODELS.BancaModel;
import br.edu.ifpr.ProjetoSisgapi.MODELS.ProjetoModel;
import br.edu.ifpr.ProjetoSisgapi.MODELS.UsuarioModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
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
        UsuarioModel umodel = new UsuarioModel();

        HttpSession sessao = request.getSession();
        Usuario u = (Usuario) sessao.getAttribute("autenticado");
        int id_curso = u.getId_curso();

        try {
            ArrayList<Projeto> projetos = pmodel.getAllProjetosByIdCurso(id_curso);
            ArrayList<Usuario> membros = umodel.getAllOrientadoresEMembros();

            System.out.println(membros.get(0));

            request.setAttribute("projetos", projetos);
            request.setAttribute("membros", membros);
            request.getRequestDispatcher("WEB-INF/agendarBanca.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AgendarBanca.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");

        //id_projeto, local, membros, tipo, data
        int id_projeto = Integer.valueOf(request.getParameter("projeto"));
        String local = request.getParameter("local");

        ArrayList<Integer> membros = new ArrayList<>();//criar uma tabela nova no bd para adicionar os membros pq pode ser que alguns não estejam cadastrados no sistema
        String membro1, membro2, membro3, membro4, membro5;
        int membro11, membro22, membro33, membro44, membro55;

        membro2 = request.getParameter("membro2");
        membro1 = request.getParameter("membro1");
        membro3 = request.getParameter("membro3");
        membro4 = request.getParameter("membro4");
        membro5 = request.getParameter("membro5");

        if (!membro1.equals("selecione")) {
            membro11 = Integer.parseInt(membro1);
            membros.add(membro11);
        } else if (!membro2.equals("selecione")) {
            membro22 = Integer.parseInt(membro2);
            membros.add(membro22);
        } else if (!membro3.equals("selecione")) {
            membro33 = Integer.parseInt(membro3);
            membros.add(membro33);
        } else if (!membro4.equals("selecione")) {
            membro44 = Integer.parseInt(membro4);
            membros.add(membro44);
        } else if (!membro5.equals("selecione")) {
            membro55 = Integer.parseInt(membro5);
            membros.add(membro55);
        } else {
            System.out.println("Nenhum membro informado.");
        }

        int tipo = Integer.parseInt(request.getParameter("tipoBanca"));

        String data = request.getParameter("data");

        LocalDate data2 = LocalDate.parse(data);

        Date data3 = Date.valueOf(data2);

        Banca banca = new Banca(id_projeto, data3, local, tipo);

        BancaModel bmodel = new BancaModel();

        try {
            bmodel.adicionarBanca(banca, membros, id_projeto);

            response.sendRedirect("AgendarBanca?m=Banca agendada com sucesso.");

            

        } catch (SQLException ex) {
            Logger.getLogger(AgendarBanca.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("AgendarBanca?m=Erro ao agendar banca.");
        }

    }

}
