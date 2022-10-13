/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.ProjetoSisgapi.MODELS;

import br.edu.ifpr.ProjetoSisgapi.DAOS.AtividadeDAO;
import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Atividade;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author vinic
 */
public class AtividadeModel {
    AtividadeDAO adao = new AtividadeDAO();
    
    public void create(Atividade atv) throws SQLException{
        if(atv.getAtividade().equals("")){
            System.out.println("Descrição da atividade inválida");
        }
        else if(atv.getPrazo() == null){
            System.out.println("Prazo inválido");
        }
        else{
            adao.adicionar(atv);
        }
       
    }
    
        public int getMesAtividade(Atividade atv){
        
        Date prazo = atv.getPrazo();
        
        LocalDate prazo2 = LocalDate.parse(prazo.toString());
        
        int mes = prazo2.getMonthValue();
        
        return mes;
        
    }
}
