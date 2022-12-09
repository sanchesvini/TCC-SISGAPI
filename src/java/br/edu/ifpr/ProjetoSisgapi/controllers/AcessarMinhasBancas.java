/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.ProjetoSisgapi.CONTROLLERS;

import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Banca;
import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Usuario;
import br.edu.ifpr.ProjetoSisgapi.MODELS.BancaModel;
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
@WebServlet(name = "AcessarMinhasBancas", urlPatterns = {"/AcessarMinhasBancas"})
public class AcessarMinhasBancas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();
        Usuario u = (Usuario) sessao.getAttribute("autenticado");

        BancaModel bm = new BancaModel();
        ProjetoModel pmodel = new ProjetoModel();

        ArrayList<Banca> bancas = null;

        ArrayList<String> nomeProjetos = new ArrayList<>();
        int id_projeto = 0;
        String nomeProjeto;

        try {
            bancas = bm.getMinhasBancas(u.getId());
        } catch (SQLException ex) {
            Logger.getLogger(AcessarBancas.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Banca banca : bancas) {
            id_projeto = banca.getId_projeto();

            try {
                nomeProjeto = pmodel.getProjetoByIdProjeto(id_projeto).getNome();

                nomeProjetos.add(nomeProjeto);
            } catch (SQLException ex) {
                Logger.getLogger(AcessarBancas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        request.setAttribute("bancas", bancas);
        request.setAttribute("nomeProjetos", nomeProjetos);

        request.getRequestDispatcher("WEB-INF/minhasBancas.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
