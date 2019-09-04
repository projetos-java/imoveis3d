/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitins.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cidade")
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 45, nullable = false)
    private String nome;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tb_uf", referencedColumnName = "id", nullable = false)
    private Uf uf;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cidade cidade = (Cidade) o;

        if (nome != null ? !nome.equals(cidade.nome) : cidade.nome != null) return false;
        return uf != null ? uf.equals(cidade.uf) : cidade.uf == null;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (uf != null ? uf.hashCode() : 0);
        return result;
    }
}
