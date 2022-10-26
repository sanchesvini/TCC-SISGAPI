/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.ProjetoSisgapi.DAOS;

import java.util.ArrayList;
import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Banca;
import br.edu.ifpr.ProjetoSisgapi.FACTORIES.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vinic
 */
public class BancaDAO {
    
    
    public void adicionarBanca(Banca banca) throws SQLException{
        String sql = "INSERT INTO BANCAS (id_projeto, data, local, tipo) VALUES (?,?,?,?)";
        
        try (Connection connection = new ConnectionFactory().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
           
       
            stmt.setInt(1, banca.getId_projeto());
            stmt.setDate(2, (Date) banca.getData());
            stmt.setString(3, banca.getLocal());
            stmt.setInt(4, banca.getTipo());
            stmt.execute();
            

            stmt.close();

            connection.close();
        }
    }
    public void linkBancaToUsuario(int id_banca, ArrayList<Integer> membros) throws SQLException {

        String sql = "INSERT INTO USUARIOSBANCAS (ID_USUARIO, ID_BANCA) VALUES (?,?)";

        Connection connection = new ConnectionFactory().getConnection();

        for (int i = 0; i < membros.size(); i++) {
            PreparedStatement stmt = connection.prepareStatement(sql); 
            stmt.setInt(1, membros.get(i));
            stmt.setInt(2, id_banca);
            stmt.execute();
            stmt.close();

            
        }
    }
    
    public Banca getBancaByIdProjeto(int id_projeto) throws SQLException{
        
        String sql = "SELECT id, data, local, tipo FROM BANCAS WHERE id_projeto = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql); 
        
        stmt.setInt(1, id_projeto);
        
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            Banca banca = new Banca(rs.getInt("ID"), id_projeto, rs.getDate("data"), rs.getString("LOCAL"), rs.getInt("TIPO"));
            return banca;
            
        }
        
        return null;
        
    }
    
    public boolean isBanca(int id_projeto, int tipo_banca) throws SQLException{
        
        String sql = "SELECT id FROM BANCAS WHERE id_projeto = ? AND tipo = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql); 
        
        stmt.setInt(1, id_projeto);
        stmt.setInt(2, tipo_banca);
        
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            return true;
            
        }
        return false;
        
    }
    public ArrayList<Banca> getAllBancas() throws SQLException{
        String sql = "SELECT id, id_projeto, data, local, tipo FROM BANCAS";
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql); 
       
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<Banca> bancas = new ArrayList();
        
        Banca banca = null;
        while(rs.next()){
            banca = new Banca(rs.getInt("ID"), rs.getInt("ID_PROJETO"), rs.getDate("DATA"), rs.getString("LOCAL"), rs.getInt("TIPO"));
            bancas.add(banca);
            
        }
        return bancas;
    }
    
}

