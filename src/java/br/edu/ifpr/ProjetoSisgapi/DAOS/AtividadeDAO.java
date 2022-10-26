/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.ProjetoSisgapi.DAOS;

import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Atividade;
import br.edu.ifpr.ProjetoSisgapi.FACTORIES.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author vinic
 */
public class AtividadeDAO {
    
    public void adicionar(Atividade atv) throws SQLException{
        System.out.println(atv.getAtividade());
        String sql = "INSERT INTO ATIVIDADE_CRONOGRAMA (atividade, id_projeto, prazo) VALUES (?,?,?)";
        
        try (Connection connection = new ConnectionFactory().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
           
       
            stmt.setString(1, atv.getAtividade());
            stmt.setInt(2, atv.getId_projeto());
            stmt.setDate(3, (Date) atv.getPrazo());
            stmt.execute();
            

            stmt.close();

            connection.close();

        }
    }
    
    public Atividade getAtividadeById_Project(int id_projeto) throws SQLException{
        
        String sql = "SELECT * FROM ATIVIDADE_CRONOGRAMA WHERE ID_PROJETO = ?";
        
        Connection conn = new ConnectionFactory().getConnection();

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setLong(1, id_projeto);
      

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Atividade atv = new Atividade(rs.getInt("ID"), rs.getString("ATIVIDADE"), rs.getDate("PRAZO"), rs.getInt("ID_PROJETO"));
            return atv;
        }
        
        return null;
        
    }
    
    public ArrayList<Atividade> getAllProjectAtivitiesById_Project(int id_projeto) throws SQLException{
        
        String sql = "SELECT * FROM ATIVIDADE_CRONOGRAMA WHERE ID_PROJETO = ?";
        
        ArrayList<Atividade> atividades = new ArrayList<>();
        
        Connection conn = new ConnectionFactory().getConnection();

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setLong(1, id_projeto);
      

        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            Atividade atv = new Atividade(rs.getInt("ID"), rs.getString("ATIVIDADE"), rs.getDate("PRAZO"), rs.getInt("ID_PROJETO"));
            atividades.add(atv);
        }
        int qntAtividades = 0;
        for (int i = 0; i < atividades.size(); i++) {
            qntAtividades =+ 1;
        }
        if(qntAtividades > 0){
            return atividades;
        }
        
        return null;
        
        
        
    }
}
