/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.ProjetoSisgapi.DAOS;

import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Projeto;
import br.edu.ifpr.ProjetoSisgapi.ENTITIES.Usuario;
import br.edu.ifpr.ProjetoSisgapi.FACTORIES.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class UsuarioDAO {

    public void adicionar(Usuario u) throws SQLException {
        String sql = "INSERT INTO USUARIOS (nome, matricula, tipo, email,"
                + "senha, id_curso) VALUES (?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setLong(2, u.getMatricula());
            stmt.setInt(3, u.getTipo());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getSenha());
            stmt.setInt(6, u.getId_curso());

            stmt.execute();
            System.out.println("CHEGUEI AQUI+++++++++++DAO USUARIO");

            stmt.close();
            connection.close();

        }
    }

    public void adicionarConvidado(Usuario u) throws SQLException {
        String sql = "INSERT INTO USUARIOS (nome, tipo, email,"
                + "senha, id_curso) VALUES (?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setInt(2, u.getTipo());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getSenha());
            stmt.setInt(5, u.getId_curso());

            stmt.execute();
            System.out.println("CHEGUEI AQUI+++++++++++DAO USUARIO");

            stmt.close();
            connection.close();

        }
    }

    public Usuario login(String email, String senha) throws SQLException {
        String sql = "SELECT ID, NOME, matricula, TIPO, ID_CURSO FROM USUARIOS WHERE EMAIL = ? AND SENHA = ?";

        Connection conn = new ConnectionFactory().getConnection();

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, email);
        stmt.setString(2, senha);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Usuario u = new Usuario(rs.getInt("ID"), rs.getInt("TIPO"), rs.getString("NOME"), rs.getLong("matricula"), rs.getInt("ID_CURSO"));
            return u;
        }
        return null;

    }

    public Usuario getUserForMatricula(Long matricula) throws SQLException {
        String sql = "SELECT ID, NOME, EMAIL, TIPO, ID_CURSO FROM USUARIOS WHERE MATRICULA = ?";

        Connection conn = new ConnectionFactory().getConnection();

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setLong(1, matricula);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Usuario user = new Usuario(rs.getInt("ID"), rs.getString("NOME"), rs.getString("EMAIL"), rs.getInt("TIPO"), rs.getInt("ID_CURSO"));
            return user;
        }
        return null;

    }

    public boolean isExistingUserOnProject(int id_estudante) throws SQLException {

        String sql = "SELECT ID_Usuario FROM USUARIOSPROJETOS WHERE ID_USUARIO = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, id_estudante);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return true;
        }
        return false;

    }

    public int getUserProject(Usuario u) throws SQLException {
        String sql = "SELECT p.id, up.id_usuario, up.id_projeto, u.id FROM projetos AS p INNER JOIN usuariosprojetos AS up ON p.id = up.id_projeto INNER JOIN usuarios AS u ON up.id_usuario = ?";

        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, u.getId());
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getInt("id");
        }
        return 0;
    }

    public ArrayList<Usuario> getAllUsersProject(int id_projeto) throws SQLException {

        ArrayList<Usuario> usuarios = new ArrayList<>();

        String sql = "SELECT u.id, u.nome, u.id_curso, u.email, u.matricula, u.tipo, up.id_projeto, p.id FROM Usuarios AS u "
                + "INNER JOIN USUARIOSPROJETOS AS up ON u.id = up.id_usuario "
                + "INNER JOIN PROJETOS AS p ON p.id = up.id_projeto AND up.id_projeto = ?";

        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, id_projeto);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Usuario u = new Usuario(rs.getInt("ID"), rs.getString("NOME"), rs.getString("EMAIL"), rs.getInt("TIPO"), rs.getInt("ID_CURSO"));
            usuarios.add(u);

        }
        return usuarios;
    }

    public ArrayList<Usuario> getAllEstudantesSemProjeto() throws SQLException {

        ArrayList<Usuario> usuarios = new ArrayList<>();

        String sql = "SELECT u.*, up.*\n"
                + "FROM Usuarios u LEFT JOIN USUARIOSPROJETOS up on u.ID = up.ID_USUARIO\n"
                + "WHERE tipo = 3 and up.ID_USUARIO IS NULL";

        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Usuario u = new Usuario(rs.getInt("ID"), rs.getString("NOME"), rs.getString("EMAIL"), rs.getInt("TIPO"), rs.getInt("ID_CURSO"));
            usuarios.add(u);

        }
        return usuarios;
    }

    public ArrayList<Usuario> getAllOrientadores() throws SQLException {

        ArrayList<Usuario> usuarios = new ArrayList<>();

        String sql = "SELECT id, nome, id_curso, email, matricula, tipo FROM Usuarios WHERE tipo = 2";

        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Usuario u = new Usuario(rs.getInt("ID"), rs.getString("NOME"), rs.getString("EMAIL"), rs.getInt("TIPO"), rs.getInt("ID_CURSO"));
            usuarios.add(u);

        }
        return usuarios;
    }

    public ArrayList<Usuario> getAllOrientadoresEMebros() throws SQLException {

        ArrayList<Usuario> usuarios = new ArrayList<>();

        String sql = "SELECT id, nome, id_curso, email, matricula, tipo FROM Usuarios WHERE tipo = 2 OR tipo = 4";

        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Usuario u = new Usuario(rs.getInt("ID"), rs.getString("NOME"), rs.getString("EMAIL"), rs.getInt("TIPO"), rs.getInt("ID_CURSO"));
            usuarios.add(u);

        }
        return usuarios;
    }

}
