/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.ProjetoSisgapi.MODELS;

import br.edu.ifpr.ProjetoSisgapi.DAOS.ProjetoDAO;
import br.edu.ifpr.ProjetoSisgapi.DAOS.UsuarioDAO;
import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Projeto;
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
            pdao.adicionarProjeto(p);
            
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void linkProject(Projeto p, ArrayList<Long> usuarios) throws SQLException{
        
        ArrayList<Integer> id_usuarios = new ArrayList<>();
     
        for(int i=0; i<usuarios.size(); i++){
            if(usuarios.get(i).equals("") || usuarios.get(i) == null){
                usuarios.remove(i);
            }
        }
        int id = 0;
        UsuarioDAO udao = new UsuarioDAO();
        for(int i = 0; i<usuarios.size(); i++){
            id = udao.getUserForMatricula(usuarios.get(i));
            if(id != 0) {
                id_usuarios.add(id);
            }
            
        }
        int id_projeto = pdao.getIdProjeto(p);
        if(id_projeto != 0){
            pdao.linkProjectToUser(id_projeto, id_usuarios);
        }
        else{
            System.out.println("Projeto inexistente.");
        }
    }
}
