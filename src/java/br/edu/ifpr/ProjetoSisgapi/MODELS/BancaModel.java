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
    public boolean adicionarBanca(Banca banca, ArrayList<Long> membros, int id_projeto) throws SQLException{
        if(bdao.isBanca(id_projeto, banca.getTipo()) == false){
            bdao.adicionarBanca(banca);
            linkBancaToUsuario(membros, id_projeto);
            return true;
        }else{
            return false;
        }
        
    }
    
    public boolean linkBancaToUsuario(ArrayList<Long> membros, int id_projeto) throws SQLException{
        int id_banca = bdao.getBancaByIdProjeto(id_projeto).getId();
        
        ArrayList<Integer> id_membros = new ArrayList<>();
        
        UsuarioDAO udao = new UsuarioDAO();
        
        ArrayList<Usuario> usuarios_projeto = udao.getAllUsersProject(id_projeto);
        Usuario membroUsuario = null;
        for (Long membro : membros) {
            membroUsuario = udao.getUserForMatricula(membro);
            if(membroUsuario != null){
                id_membros.add(membroUsuario.getId());
                return true;
            
            }
            
        }
        Usuario estud_ori = null;
        for (Usuario usuario : usuarios_projeto) {
            estud_ori = udao.getUserForMatricula(usuario.getMatricula());
            if(estud_ori != null){
                id_membros.add(estud_ori.getId());
                return true;
            }
        }
        
        
        
        bdao.linkBancaToUsuario(id_banca, id_membros);
        return false;
    }
    
    public ArrayList<Banca> getAllBancas() throws SQLException{
        return bdao.getAllBancas();
    }
}
