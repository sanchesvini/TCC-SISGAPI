/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.ProjetoSisgapi.ENTITIES;

/**
 *
 * @author vinic
 */
public class Projeto {
    int id;
    String nome;
    String descricao;
    int tipo;
    int id_curso;
    byte[] projeto;
    String tipo_arquivo;

    public Projeto(int id, String nome, String descricao, int tipo, byte[] projeto, String tipo_arquivo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.projeto = projeto;
        this.tipo_arquivo = tipo_arquivo;
    }

    public Projeto(int id, String nome, String descricao, int tipo, int id_curso) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.id_curso = id_curso;
    }
    

    public byte[] getProjeto() {
        return projeto;
    }

    public void setProjeto(byte[] projeto) {
        this.projeto = projeto;
    }

    public String getTipo_arquivo() {
        return tipo_arquivo;
    }

    public void setTipo_arquivo(String tipo_arquivo) {
        this.tipo_arquivo = tipo_arquivo;
    }

    public Projeto(String nome, String descricao, int tipo, int id_curso) {
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.id_curso = id_curso;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Projeto(String nome, String descricao, int tipo) {
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public Projeto() {
    }

    public Projeto(int id, String nome, String descricao, int tipo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
    }
    
}
