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

    public boolean create(Usuario u) throws SQLException {

        dao.adicionar(u);
        System.out.println("CHEGUEI AQUI+++++++++++MODEL USUARIO --- create");
        return true;

    }
    public boolean createConvidado(Usuario u) throws SQLException{
        dao.adicionarConvidado(u);
        System.out.println("CHEGUEI AQUI+++++++++++MODEL USUARIO --- createConvidado");
        return true;
    }

    public Usuario login(String email, String senha) throws SQLException {
        return dao.login(email, senha);

    }

    public boolean isEstudante(Usuario u) {
        if (u.getTipo() == 3) {
            return true;
        }
        return false;

    }

    public boolean isOrientador(Usuario u) {
        if (u.getTipo() == 2) {
            return true;
        }
        return false;
    }

    public boolean isAdm(Usuario u) {
        if (u.getTipo() == 1) {
            return true;
        }
        return false;
    }
    public ArrayList<Usuario> getAllEstudantesSemProjeto() throws SQLException{
        return dao.getAllEstudantesSemProjeto();
    }
    public ArrayList<Usuario> getAllOrientadores() throws SQLException{
        return dao.getAllOrientadores();
    }
    public ArrayList<Usuario> getAllOrientadoresEMembros() throws SQLException{
        return dao.getAllOrientadoresEMembros();
    }
}
