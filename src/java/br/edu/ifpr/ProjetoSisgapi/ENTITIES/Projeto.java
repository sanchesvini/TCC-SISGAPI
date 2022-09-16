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
