/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.ProjetoSisgapi.ENTITIES;

import java.sql.Date;

/**
 *
 * @author vinic
 */
public class Banca {
    
    private int id;
    private int id_projeto;
    private Date data;
    private String local;
    private int tipo;
    private char conceito;

    public Banca(int id, int id_projeto, Date data, String local, int tipo, char conceito) {
        this.id = id;
        this.id_projeto = id_projeto;
        this.data = data;
        this.local = local;
        this.tipo = tipo;
        this.conceito = conceito;
    }

    public Banca(int id_projeto, Date data, String local, int tipo, char conceito) {
        this.id_projeto = id_projeto;
        this.data = data;
        this.local = local;
        this.tipo = tipo;
        this.conceito = conceito;
    }

    public Banca(int id_projeto, Date data, String local, int tipo) {
        this.id_projeto = id_projeto;
        this.data = data;
        this.local = local;
        this.tipo = tipo;
    }

    public Banca(int id, int id_projeto, Date data, String local, int tipo) {
        this.id = id;
        this.id_projeto = id_projeto;
        this.data = data;
        this.local = local;
        this.tipo = tipo;
    }
    
    

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_projeto() {
        return id_projeto;
    }

    public void setId_projeto(int id_projeto) {
        this.id_projeto = id_projeto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public char getConceito() {
        return conceito;
    }

    public void setConceito(char conceito) {
        this.conceito = conceito;
    }
    
    
    
}
