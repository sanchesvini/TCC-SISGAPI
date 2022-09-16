/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.ProjetoSisgapi.DAOS;

import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Projeto;
import br.edu.ifpr.ProjetoSisgapi.FACTORIES.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vinic
 */
public class ProjetoDAO {

    public void adicionarProjeto(Projeto p) throws SQLException {
        String sql = "INSERT INTO PROJETOS (nome, descricao, tipo)"
                + " VALUES (?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
           
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setInt(3, p.getTipo());
            stmt.execute();

            stmt.close();

            connection.close();

        }
    }
    
    public int getIdProjeto(Projeto p) throws SQLException{
        String sql = "SELECT ID FROM PROJETOS WHERE nome = ? AND descricao = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getDescricao());
        
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            int id = rs.getInt("ID");
            return id;
        }
        return 0;
        
    }

    public void linkProjectToUser(int id_projeto, ArrayList<Integer> usuarios) throws SQLException {
        
        
        
        
        String sql2 = "INSERT INTO USUARIOSPROJETOS (ID_USUARIO, ID_PROJETO) VALUES (?,?)";
        
        Connection connection = new ConnectionFactory().getConnection();
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(usuarios.get(i));
        }

        for (int i = 0; i < usuarios.size(); i++) {
            PreparedStatement stmt2 = connection.prepareStatement(sql2); //a cada usuario teremos que abrir uma nova conexão para cadastrar um por um
            stmt2.setInt(1, usuarios.get(i));
            stmt2.setInt(2, id_projeto); 
            stmt2.execute();
            stmt2.close();

            //tive que fazer esses métodos separados do adicionar porque estava dando esse erro: INSERT na tabela 'USUARIOSPROJETOS' causou uma violação na restrição de chave estrangeira 'FK_PROJETOS_USUARIOS' para a chave (0).  A instrução foi desfeita.
        }
    }
}

