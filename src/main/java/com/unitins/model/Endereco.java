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
@Table(name = "tb_endereco")
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "rua", length = 50, nullable = false)
    private String rua;

    @Column(name = "numero", length = 50, nullable = false)
    private int numero;

    @Column(name = "cep", length = 50, nullable = false)
    private String cep;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tb_cidade", referencedColumnName = "id", nullable = false)
    private Cidade cidade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Endereco endereco = (Endereco) o;

        if (numero != endereco.numero) return false;
        if (rua != null ? !rua.equals(endereco.rua) : endereco.rua != null) return false;
        if (cep != null ? !cep.equals(endereco.cep) : endereco.cep != null) return false;
        return cidade != null ? cidade.equals(endereco.cidade) : endereco.cidade == null;
    }

    @Override
    public int hashCode() {
        int result = rua != null ? rua.hashCode() : 0;
        result = 31 * result + numero;
        result = 31 * result + (cep != null ? cep.hashCode() : 0);
        result = 31 * result + (cidade != null ? cidade.hashCode() : 0);
        return result;
    }
}
