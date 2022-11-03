/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.ProjetoSisgapi.MODELS;

import br.edu.ifpr.ProjetoSisgapi.DAOS.ProjetoDAO;
import br.edu.ifpr.ProjetoSisgapi.DAOS.UsuarioDAO;
import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Projeto;
import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author vinic
 */
public class ProjetoModel {
    ProjetoDAO pdao = new ProjetoDAO();
    
    public void createProject(Projeto p) throws SQLException{
        
        
        try {
            pdao.addProjeto(p);
            
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void linkProject(Projeto p, ArrayList<Integer> estudantes, ArrayList<Integer> orientadores) throws SQLException{
     
        int id_projeto = pdao.getIdProjetoByProjeto(p);
        if(id_projeto != 0){
            pdao.linkProjetoToUsuario(id_projeto, estudantes, orientadores);
        }
        else{
            System.out.println("Projeto inexistente.");
        }
    }
    
    public void anexarTrabalho(byte[] trabalho, String tipo, int id_projeto) throws SQLException{
        pdao.anexarProjeto(trabalho, tipo, id_projeto);
        
    }
    public int getIdProjetoByProjeto(Projeto p) throws SQLException{
        return pdao.getIdProjetoByProjeto(p);
    }
    public ArrayList<Projeto> getProjetosByIdUsuario(int id_usuario) throws SQLException{
       return pdao.getProjetosByIdUsuario(id_usuario);
    }
    
    public ArrayList<Projeto> getAllProjetosByIdCurso(int id_curso) throws SQLException{
        return pdao.getAllProjetosByIdCurso(id_curso);
    }
    public Projeto getProjetoByIdProjeto(int id_projeto) throws SQLException{
       return pdao.getProjetoByIdProjeto(id_projeto);
    }
    
    
    
    
}
