package br.edu.ifpr.ProjetoSisgapi.MODELS;

import br.edu.ifpr.ProjetoSisgapi.DAOS.UsuarioDAO;
import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author usuario
 */
public class UsuarioModel {
    UsuarioDAO dao = new UsuarioDAO();
    public void create(Usuario u) throws SQLException {
        
        if (u.getEmail() == null || u.getEmail() == "") {
            return;
        }

        if (u.getSenha() == null || u.getSenha() == "") {
            return;
        }

        
        dao.adicionar(u);
        System.out.println("CHEGUEI AQUI+++++++++++MODEL USUARIO");
    }
    public Usuario login(Long login, String senha) throws SQLException{
        return dao.login(login, senha);
        
    }
}