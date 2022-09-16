/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.ProjetoSisgapi.DAOS;

import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Usuario;
import br.edu.ifpr.ProjetoSisgapi.FACTORIES.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class UsuarioDAO {

    public void adicionar(Usuario u) throws SQLException {
        String sql = "INSERT INTO USUARIOS (nome, matricula, tipo, email,"
                + "senha) VALUES (?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setLong(2, u.getMatricula());
            stmt.setInt(3, u.getTipo());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getSenha());

            stmt.execute();

            stmt.close();
            connection.close();

        }
    }

    public Usuario login(int login, String senha) throws SQLException {
        String sql = "SELECT ID, NOME, EMAIL, TIPO FROM USUARIOS WHERE MATRICULA = ? AND SENHA = ?";

        Connection conn = new ConnectionFactory().getConnection();

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, login);
        stmt.setString(2, senha);

        ResultSet rs = stmt.executeQuery();
       
        if (rs.next()) {
            Usuario u = new Usuario(rs.getInt("ID"), rs.getString("NOME"), rs.getString("EMAIL"), rs.getInt("TIPO"));
            return u;
        }
        return null;

    }
}
