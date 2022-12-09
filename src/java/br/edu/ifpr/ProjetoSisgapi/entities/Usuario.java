/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.ProjetoSisgapi.ENTITIES;

import br.edu.ifpr.ProjetoSisgapi.DAOS.UsuarioDAO;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class Usuario {
    int id;
    int tipo;
    String nome;
    Long matricula;
    String email;
    String senha;
    int id_curso;

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public Usuario( int tipo, String nome, String email, String senha, int id_curso) {
        
        this.tipo = tipo;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.id_curso = id_curso;
    }

    public Usuario(int id, int tipo, String nome, Long matricula, int id_curso) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.matricula = matricula;
        this.id_curso = id_curso;
    }

    public Usuario(int tipo, String nome, Long matricula, String email, String senha, int id_curso) {
        this.tipo = tipo;
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.senha = senha;
        this.id_curso = id_curso;
    }

    public Usuario() {
    }

    public Usuario(int id, String nome, String email, int tipo, int id_curso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
        this.id_curso = id_curso;
    }

 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }  
    
    UsuarioDAO udao = new UsuarioDAO();
    
    public boolean isOrientador(Long matricula) throws SQLException {

        Usuario user = udao.getUserForMatricula(matricula);
        if (user.getTipo() == 2) {
            return true;
        }

        return false;

    }

    public boolean isEstudante(Long matricula) throws SQLException {
        
        Usuario user = udao.getUserForMatricula(matricula);
        if (user.getTipo() == 3) {
            return true;
        }

        return false;

    }
}