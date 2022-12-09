/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.ProjetoSisgapi.MODELS;

import br.edu.ifpr.ProjetoSisgapi.DAOS.ProjetoDAO;
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

    public void createProject(Projeto p, ArrayList<Integer> id_estudantes, ArrayList<Integer> id_orientadores) throws SQLException {

        try {
            pdao.linkProjetoToUsuario(p, id_estudantes, id_orientadores);

        } catch (SQLException ex) {
            Logger.getLogger(ProjetoModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void anexarTrabalho(byte[] trabalho, String tipo, int id_projeto) throws SQLException {
        pdao.anexarProjeto(trabalho, tipo, id_projeto);

    }

    public int getIdProjetoByProjeto(Projeto p) throws SQLException {
        return pdao.getIdProjetoByProjeto(p);
    }

    public ArrayList<Projeto> getProjetosByIdUsuario(int id_usuario) throws SQLException {
        return pdao.getProjetosByIdUsuario(id_usuario);
    }

    public ArrayList<Projeto> getAllProjetosByIdCurso(int id_curso) throws SQLException {
        return pdao.getAllProjetosByIdCurso(id_curso);
    }

    public Projeto getProjetoByIdProjeto(int id_projeto) throws SQLException {
        return pdao.getProjetoByIdProjeto(id_projeto);
    }

    public boolean isEstudanteComProjeto(int id_usuario) throws SQLException {
        return pdao.isEstudanteComProjeto(id_usuario);
    }

}
