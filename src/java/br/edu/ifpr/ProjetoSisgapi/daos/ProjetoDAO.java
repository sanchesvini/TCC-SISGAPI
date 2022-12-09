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
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author vinic
 */
public class ProjetoDAO {

    public void addProjeto(Connection connection, Projeto p, ArrayList<Integer> id_estudantes, ArrayList<Integer> id_orientadores) throws SQLException {
        String sql = "INSERT INTO PROJETOS (nome, descricao, tipo, id_curso)"
                + " VALUES (?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setInt(3, p.getTipo());
            stmt.setInt(4, p.getId_curso());
            
            int generatedRows = stmt.executeUpdate();
            
            if (generatedRows == 0) {
                throw new SQLException("Erro ao vincular projeto");
            } else {
                ResultSet rs = stmt.getGeneratedKeys();
                
                if (rs.next()) {
                     p.setId(rs.getInt(1));
                    System.out.println("Vinculou projeto com ID: " + p.getId());
                } else {
                    throw new SQLException("Erro ao obter id do projeto");
                }
            }
        }
    }

    public void linkProjetoToUsuario(Projeto p, ArrayList<Integer> id_estudantes, ArrayList<Integer> id_orientadores) throws SQLException {

        String sql = "INSERT INTO USUARIOSPROJETOS (ID_USUARIO, ID_PROJETO) VALUES (?,?)";

        Connection connection = new ConnectionFactory().getConnection();
        connection.setAutoCommit(false);

        addProjeto(connection, p, id_estudantes, id_orientadores);

        try {

            for (int i = 0; i < id_estudantes.size(); i++) {
                PreparedStatement stmt = connection.prepareStatement(sql); //a cada usuario teremos que abrir uma nova conexão para cadastrar um por um
                stmt.setInt(1, id_estudantes.get(i));
                stmt.setInt(2, p.getId());

                stmt.execute();
                stmt.close();

                
            }

            for (int i = 0; i < id_orientadores.size(); i++) {
                PreparedStatement stmt = connection.prepareStatement(sql); //a cada usuario teremos que abrir uma nova conexão para cadastrar um por um
                stmt.setInt(1, id_orientadores.get(i));
                stmt.setInt(2, p.getId());

                stmt.execute();
                stmt.close();

            }
            connection.commit();

        } catch (SQLException ex) {
            connection.rollback();
            System.out.println(ex.getMessage());
        } finally {
            connection.close();
        }

    }

    public int getIdProjetoByProjeto(Projeto p) throws SQLException {
        String sql = "SELECT ID FROM PROJETOS WHERE nome = ? AND descricao = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getDescricao());

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("ID");
            return id;
        }
        return 0;

    }

    //criar método para verificar se o estudante possui projeto em comum com o orientador
//    public boolean isExistingOrientadorAtCommonProjectWithEstudante(){
//        
//        return false;
//        
//    }
    public ArrayList<Projeto> getProjetosByIdUsuario(int id_usuario) throws SQLException {

        String sql = "SELECT up.id_usuario, up.id_projeto, p.id, p.nome, p.descricao, p.tipo, p.id_curso FROM PROJETOS AS p INNER JOIN USUARIOSPROJETOS AS up ON p.id = up.id_projeto AND up.id_usuario = ?";

        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, id_usuario);

        ResultSet rs = stmt.executeQuery();

        ArrayList<Projeto> projetos = new ArrayList<>();

        while (rs.next()) {
            Projeto p = new Projeto(rs.getInt("ID"), rs.getString("nome"), rs.getString("descricao"), rs.getInt("TIPO"), rs.getInt("ID_CURSO"));
            projetos.add(p);
            return projetos;
        }

        return null;

    }

    public Projeto getProjetoByIdProjeto(int id_projeto) throws SQLException {

        String sql = "SELECT id, nome, descricao, tipo, id_curso, projeto, tipo_arquivo FROM PROJETOS WHERE id = ?";

        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, id_projeto);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Projeto p = new Projeto(rs.getInt("ID"), rs.getString("nome"), rs.getString("descricao"), rs.getInt("TIPO"), rs.getBytes("PROJETO"), rs.getString("TIPO_ARQUIVO"));
            return p;
        }

        return null;

    }

    public void anexarProjeto(byte[] trabalho, String tipo, int id_projeto) throws SQLException {
        String sql = "UPDATE PROJETOS SET projeto = ? , tipo_arquivo = ? WHERE id = ?";
        Connection connection = new ConnectionFactory().getConnection();

        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setBytes(1, trabalho);
        stmt.setString(2, tipo);
        stmt.setInt(3, id_projeto);

        stmt.execute();
        stmt.close();

        connection.close();
    }

    public ArrayList<Projeto> getAllProjetosByIdCurso(int id_curso) throws SQLException {
        String sql = "SELECT id, nome, descricao, tipo, projeto, tipo_arquivo FROM PROJETOS WHERE id_curso = ?";

        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, id_curso);

        ResultSet rs = stmt.executeQuery();

        ArrayList<Projeto> projetos = new ArrayList<>();

        int qntProjetos = 0;
        while (rs.next()) {
            qntProjetos++;
            Projeto p = new Projeto(rs.getInt("ID"), rs.getString("NOME"), rs.getString("DESCRICAO"), rs.getInt("TIPO"), rs.getBytes("projeto"), rs.getString("tipo_arquivo"));
            projetos.add(p);
        }

        if (qntProjetos > 0) {
            return projetos;
        } else {
            return null;
        }

    }

    public boolean isEstudanteComProjeto(int id_usuario) throws SQLException {

        String sql = "SELECT up.id_usuario, up.id_projeto FROM USUARIOSPROJETOS WHERE up.id_usuario = ?";

        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, id_usuario);

        ResultSet rs = stmt.executeQuery();

        return rs.next();

    }

}
