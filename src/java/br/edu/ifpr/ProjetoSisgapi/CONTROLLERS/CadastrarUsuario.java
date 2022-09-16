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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        Long matricula;
        Usuario u = null;

        nome = request.getParameter("nome");
        email = request.getParameter("email");
        matricula = Long.parseLong(request.getParameter("login"));
        senha = request.getParameter("senha");
        senha2 = request.getParameter("confirmarsenha");
        tipo = 3;
        
        HttpSession sessao = request.getSession();
        Usuario adm = (Usuario) sessao.getAttribute("autenticado");
        
        System.out.println(adm.getNome() + "    cadastro usuario");
        id_curso = adm.getId_curso();
        System.out.println(id_curso + "    cadastro usuario");
        
        if(senha.equals(senha2)){
            u = new Usuario(tipo, nome, matricula, email, senha, id_curso);
          
        }
        else{
            response.sendRedirect("cadastrarUsuario.jsp");
        }
        
     
        UsuarioModel model = new UsuarioModel();

        try {
            model.create(u);

            request.getRequestDispatcher("WEB-INF/indexes/indexAdm.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

}
