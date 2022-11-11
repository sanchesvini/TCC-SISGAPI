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

    public void addProjeto(Projeto p) throws SQLException {
        String sql = "INSERT INTO PROJETOS (nome, descricao, tipo, id_curso)"
                + " VALUES (?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setInt(3, p.getTipo());
            stmt.setInt(4, p.getId_curso());
            stmt.execute();

            stmt.close();

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

    public void linkProjetoToUsuario(int id_projeto, ArrayList<Integer> id_estudantes, ArrayList<Integer> id_orientadores) throws SQLException {

        String sql2 = "INSERT INTO USUARIOSPROJETOS (ID_USUARIO, ID_PROJETO) VALUES (?,?)";

        Connection connection = new ConnectionFactory().getConnection();

       

        for (int i = 0; i < id_estudantes.size(); i++) {
            PreparedStatement stmt2 = connection.prepareStatement(sql2); //a cada usuario teremos que abrir uma nova conexão para cadastrar um por um
            stmt2.setInt(1, id_estudantes.get(i));
            stmt2.setInt(2, id_projeto);
            stmt2.execute();
            stmt2.close();

            //tive que fazer esses métodos separados do adicionar porque estava dando esse erro: INSERT na tabela 'USUARIOSPROJETOS' causou uma violação na restrição de chave estrangeira 'FK_PROJETOS_USUARIOS' para a chave (0).  A instrução foi desfeita.
        }

        

        for (int i = 0; i < id_orientadores.size(); i++) {
            PreparedStatement stmt2 = connection.prepareStatement(sql2); //a cada usuario teremos que abrir uma nova conexão para cadastrar um por um
            stmt2.setInt(1, id_orientadores.get(i));
            stmt2.setInt(2, id_projeto);
            stmt2.execute();
            stmt2.close();

            //tive que fazer esses métodos separados do adicionar porque estava dando esse erro: INSERT na tabela 'USUARIOSPROJETOS' causou uma violação na restrição de chave estrangeira 'FK_PROJETOS_USUARIOS' para a chave (0).  A instrução foi desfeita.
        }

    }
    
    
    //criar método para verificar se o estudante possui projeto em comum com o orientador
//    public boolean isExistingOrientadorAtCommonProjectWithEstudante(){
//        
//        return false;
//        
//    }
    
    public ArrayList<Projeto> getProjetosByIdUsuario(int id_usuario) throws SQLException{
        
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
    public Projeto getProjetoByIdProjeto(int id_projeto) throws SQLException{
        
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
    
    public void anexarProjeto(byte[] trabalho, String tipo, int id_projeto) throws SQLException{
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
    
    public ArrayList<Projeto> getAllProjetosByIdCurso(int id_curso) throws SQLException{
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
        
        if(qntProjetos > 0){
            return projetos;
        }else{
            return null;
        }
        
    }
    public boolean isEstudanteComProjeto(int id_usuario) throws SQLException{
        
        String sql = "SELECT up.id_usuario, up.id_projeto FROM USUARIOSPROJETOS WHERE up.id_usuario = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, id_usuario);

        ResultSet rs = stmt.executeQuery();
       

        return rs.next();
        
    }

}
