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
    public void linkProject(Projeto p, ArrayList<Long> estudantes, ArrayList<Long> orientadores) throws SQLException{
        UsuarioDAO udao = new UsuarioDAO();
        ArrayList<Integer> id_estudantes = new ArrayList<>();
        ArrayList<Integer> id_orientadores = new ArrayList<>();
        //removendo valores nulos
        for(int i=0; i<estudantes.size(); i++){
            if(estudantes.get(i).equals("") || estudantes.get(i) == null){
                estudantes.remove(i);
            }
        }
        //adicionando id dos usuarios na lista
        Usuario estudante = new Usuario();
        for(int i = 0; i<estudantes.size(); i++){
            estudante = udao.getUserForMatricula(estudantes.get(i));
            int id_estudante = estudante.getId();
            boolean isEstudante = estudante.isEstudante(estudantes.get(i));
            boolean isExistingUserOnProject = udao.isExistingUserOnProject(estudante.getId());
            if(isEstudante == true && isExistingUserOnProject == false) {
                id_estudantes.add(id_estudante);
            }
            else{
                System.out.println("O usuário digitado no campo de estudante já possui um projeto ou não é um estudante válido.");
                
            }
            
        }
        
        //removendo valores nulos
        for(int i=0; i<orientadores.size(); i++){
            if(orientadores.get(i).equals("") || orientadores.get(i) == null){
                orientadores.remove(i);
            }
        }
        //adicionando id dos usuarios na lista
        int id = 0;
         Usuario orientador = new Usuario();
        for(int i = 0; i<orientadores.size(); i++){
            orientador = udao.getUserForMatricula(orientadores.get(i));
            if(orientador.isOrientador(orientadores.get(i)) == true) {
                id_orientadores.add(orientador.getId());
            }
            else{
                System.out.println("O usuário digitado no campo de orientador não é um orientador válido.");
            }
            
        }
        
        
        int id_projeto = pdao.getIdProjetoByProjeto(p);
        if(id_projeto != 0){
            pdao.linkProjetoToUsuario(id_projeto, id_estudantes, id_orientadores);
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
    public Projeto getProjetoByIdUsuario(int id_usuario) throws SQLException{
       return pdao.getProjetoByIdUsuario(id_usuario);
    }
    
    public ArrayList<Projeto> getAllProjetosByIdCurso(int id_curso) throws SQLException{
        return pdao.getAllProjetosByIdCurso(id_curso);
    }
    public Projeto getProjetoByIdProjeto(int id_projeto) throws SQLException{
       return pdao.getProjetoByIdProjeto(id_projeto);
    }
    
    
    
}
