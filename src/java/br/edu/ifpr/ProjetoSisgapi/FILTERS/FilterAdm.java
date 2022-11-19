/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.ProjetoSisgapi.FILTERS;

import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Usuario;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vinic
 */
@WebFilter(filterName = "FilterAdm", servletNames = {"CadastrarUsuario", "CadastrarProjeto", "AgendarBanca"})
public class FilterAdm implements Filter {
    
 
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain filter)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        HttpSession sessao = request.getSession();
        Usuario u = (Usuario) sessao.getAttribute("autenticado");
        if(u.getTipo() == 1){
            filter.doFilter(req, res);
           
        }else{
            response.sendRedirect("index.html");
        }
    }

   
}
