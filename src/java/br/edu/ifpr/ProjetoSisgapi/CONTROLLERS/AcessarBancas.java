/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.ProjetoSisgapi.CONTROLLERS;

import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Banca;
import br.edu.ifpr.ProjetoSisgapi.MODELS.BancaModel;
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

/**
 *
 * @author vinic
 */
@WebServlet(name = "AcessarBancas", urlPatterns = {"/AcessarBancas"})
public class AcessarBancas extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        BancaModel bm = new BancaModel();
        ArrayList<Banca> bancas = null;
        try {
            bancas = bm.getAllBancas();
        } catch (SQLException ex) {
            Logger.getLogger(AcessarBancas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("bancas", bancas);
        request.getRequestDispatcher("bancasGeral.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
