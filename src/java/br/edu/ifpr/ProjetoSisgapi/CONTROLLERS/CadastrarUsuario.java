package br.edu.ifpr.ProjetoSisgapi.CONTROLLERS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Usuario;
import br.edu.ifpr.ProjetoSisgapi.MODELS.UsuarioModel;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/CadastrarUsuario"})
public class CadastrarUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/cadastroUsuario.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nome, email, senha, senha2;
        int tipo, id_curso;
        String matricula;
        Long matriculaSucess;
        Usuario u = null;
        boolean result = false;

        nome = request.getParameter("nome");
        email = request.getParameter("email");
        matricula = request.getParameter("login");
        senha = request.getParameter("senha");
        senha2 = request.getParameter("confirmarsenha");
        tipo = Integer.parseInt(request.getParameter("tipo"));

        HttpSession sessao = request.getSession();
        Usuario adm = (Usuario) sessao.getAttribute("autenticado");

        id_curso = adm.getId_curso();

        if (tipo == 2 || tipo == 3) {

            if (matricula.equals("") || matricula == null) {
//                result = false;
//                request.setAttribute("result", result);
//                System.out.println("deu erro 1");

                response.sendRedirect("AcessarIndex");
            } else {
                matriculaSucess = Long.parseLong(matricula);
                if (senha.equals(senha2)) {
                    u = new Usuario(tipo, nome, matriculaSucess, email, senha, id_curso);
                    UsuarioModel model = new UsuarioModel();
                    try {
                        result = model.create(u);
                        if (result == true) {
//                            request.setAttribute("result", result);
//                           System.out.println("deu certo 2");

                            response.sendRedirect("AcessarIndex");
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
//                    result = false;
//                    request.setAttribute("result", result);
//                    System.out.println("deu erro 3");
                    response.sendRedirect("AcessarIndex");
                }
            }

        } else if (senha.equals(senha2)) {
            u = new Usuario(tipo, nome, email, senha, id_curso);
            UsuarioModel model = new UsuarioModel();
            try {
                result = model.createConvidado(u);
                if (result == true) {
                    response.sendRedirect("AcessarIndex");
                }
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            response.sendRedirect("AcessarIndex");
        }

    }

}
