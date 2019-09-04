/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitins.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "tb_imoveis")
public class Imovel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "area")
    private int area;

    @Column(name = "quartos")
    private int quartos;

    @Column(name = "suites")
    private int suites;

    @Column(name = "vaga_garagem")
    private int garagem;

    @Column(name = "valor", precision = 7, scale = 2, nullable = false)
    private BigDecimal valor;

    @Column(name = "descricao", length = 255)
    private String descricao;

    @Column(name = "link_obj", length = 255)
    private String linkObj;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tb_imobliaria", referencedColumnName = "id")
    private Imobiliaria imobiliaria;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tb_endereco", referencedColumnName = "id", nullable = false)
    private Endereco endereco;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tb_categoria", referencedColumnName = "id", nullable = false)
    private Categoria categoria;

    public Imovel() {
        this.endereco = new Endereco();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getQuartos() {
        return quartos;
    }

    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }

    public int getSuites() {
        return suites;
    }

    public void setSuites(int suites) {
        this.suites = suites;
    }

    public int getGaragem() {
        return garagem;
    }

    public void setGaragem(int garagem) {
        this.garagem = garagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLinkObj() {
        return linkObj;
    }

    public void setLinkObj(String linkObj) {
        this.linkObj = linkObj;
    }

    public Imobiliaria getImobiliaria() {
        return imobiliaria;
    }

    public void setImobiliaria(Imobiliaria imobiliaria) {
        this.imobiliaria = imobiliaria;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Imovel imovel = (Imovel) o;

        if (imobiliaria != null ? !imobiliaria.equals(imovel.imobiliaria) : imovel.imobiliaria != null) return false;
        return endereco != null ? endereco.equals(imovel.endereco) : imovel.endereco == null;
    }

    @Override
    public int hashCode() {
        int result = imobiliaria != null ? imobiliaria.hashCode() : 0;
        result = 31 * result + (endereco != null ? endereco.hashCode() : 0);
        return result;
    }
}
