/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitins.model;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_imobiliaria")
public class Imobiliaria implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "nome",length = 45,nullable = false)
    private String nome;

    @CNPJ
    @Column(name = "cnpj",length = 45,nullable = false)
    private String cnpj;
    
    @Column(name = "telefone",length = 45,nullable = false)
    private String telefone;
    
    @Column(name = "email",length = 45,nullable = false)
    private String email;
    
    @Column(name = "descricao",length = 45,nullable = false)
    private String descricao;

    //TODO -> Usuario

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Imobiliaria that = (Imobiliaria) o;

        return cnpj != null ? cnpj.equals(that.cnpj) : that.cnpj == null;
    }

    @Override
    public int hashCode() {
        return cnpj != null ? cnpj.hashCode() : 0;
    }
}
