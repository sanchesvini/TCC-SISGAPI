/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.ProjetoSisgapi.MODELS;

import br.edu.ifpr.ProjetoSisgapi.DAOS.BancaDAO;
import br.edu.ifpr.ProjetoSisgapi.DAOS.UsuarioDAO;
import java.util.ArrayList;
import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Banca;
import java.sql.SQLException;
import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Usuario;

/**
 *
 * @author vinic
 */
public class BancaModel {
    
    BancaDAO bdao = new BancaDAO();
    public boolean adicionarBanca(Banca banca, ArrayList<Integer> membros, int id_projeto) throws SQLException{
        if(bdao.isBanca(id_projeto, banca.getTipo()) == false){
            bdao.adicionarBanca(banca);
            linkBancaToUsuario(membros, id_projeto);
            return true;
        }else{
            return false;
        }
        
    }
    
    public void linkBancaToUsuario(ArrayList<Integer> membros, int id_projeto) throws SQLException{
        int id_banca = bdao.getBancaByIdProjeto(id_projeto).getId();

        bdao.linkBancaToUsuario(id_banca, membros);
    }
    
    public ArrayList<Banca> getAllBancas() throws SQLException{
        return bdao.getAllBancas();
    }
    public ArrayList<Banca> getMinhasBancas(int id_usuario) throws SQLException{
        return bdao.getMinhasBancas(id_usuario);
    }
}
