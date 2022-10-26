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
        
        int id_projeto = Integer.valueOf(request.getParameter("projeto"));
        String local = request.getParameter("local");
        
        ArrayList<Long> membros = new ArrayList<>();//criar uma tabela nova no bd para adicionar os membros pq pode ser que alguns não estejam cadastrados no sistema
        String membro1, membro2, membro3, membro4, membro5;
        Long membro11, membro22, membro33, membro44, membro55;
        
        membro2 = request.getParameter("membro2");
        membro1 = request.getParameter("membro1");
        membro3 = request.getParameter("membro3");
        membro4 = request.getParameter("membro4");
        membro5 = request.getParameter("membro5");
        
        if(!membro1.equals("")){
            membro11 = Long.parseLong(membro1);
            membros.add(membro11);
        }
        else if(!membro2.equals("")){
            membro22 = Long.parseLong(membro2);
            membros.add(membro22);
        }
        else if(!membro3.equals("")){
            membro33 = Long.parseLong(membro3);
            membros.add(membro33);
        }
        else if(!membro4.equals("")){
            membro44 = Long.parseLong(membro4);
            membros.add(membro44);
        }
        else if(!membro5.equals("")){
            membro55 = Long.parseLong(membro5);
            membros.add(membro55);
        }
        
        int tipo = Integer.parseInt(request.getParameter("opcao"));
        
        String data = request.getParameter("data");
        
        LocalDate data2 = LocalDate.parse(data);
        
        Date data3 = Date.valueOf(data2);
        
        Banca banca = new Banca(id_projeto, data3, local, tipo);
        
        BancaModel bmodel = new BancaModel();
        
        try {
            if(bmodel.adicionarBanca(banca, membros, id_projeto)){
                response.sendRedirect("AcessarIndex");
            }else{
                System.out.println("Deu errado! ");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AgendarBanca.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }


}
