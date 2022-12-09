/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.ProjetoSisgapi.ENTITIES;

import java.util.Date;

/**
 *
 * @author vinic
 */
public class Atividade {
    private int id;
    private String atividade;
    private Date prazo;
    private int id_projeto;

    public Atividade() {
    }

    public Atividade(int id, String atividade, Date prazo, int id_projeto) {
        this.id = id;
        this.atividade = atividade;
        this.prazo = prazo;
        this.id_projeto = id_projeto;
    }

    public Atividade(String atividade, Date prazo, int id_projeto) {
        this.atividade = atividade;
        this.prazo = prazo;
        this.id_projeto = id_projeto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public int getId_projeto() {
        return id_projeto;
    }

    public void setId_projeto(int id_projeto) {
        this.id_projeto = id_projeto;
    }
}
