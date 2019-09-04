package com.unitins.controller;

import com.unitins.dao.CategoriaDao;
import com.unitins.dao.CidadeDao;
import com.unitins.dao.ImobiliariaDao;
import com.unitins.dao.ImovelDao;
import com.unitins.model.Categoria;
import com.unitins.model.Cidade;
import com.unitins.model.Imobiliaria;
import com.unitins.model.Imovel;
import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class ImovelController implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private ImovelDao imovelDao;
    private List<Imovel> imoveis;
    private Imovel imovel;

    @EJB
    private CategoriaDao categoriaDao;
    private List<Categoria> categorias;

    @EJB
    private CidadeDao cidadeDao;
    private List<Cidade> cidades;

    @EJB
    private ImobiliariaDao imobiliariaDao;
    private List<Imobiliaria> imobiliarias;

    @PostConstruct
    public void init() {
        imoveis = new ArrayList<>();
        imoveis = imovelDao.findAll();

        categorias = new ArrayList<>();
        categorias = categoriaDao.findAll();

        cidades = new ArrayList<>();
        cidades = cidadeDao.findAll();

        imobiliarias = new ArrayList<>();
        imobiliarias = imobiliariaDao.findAll();
    }

    //Persistencia
    public void salvar() {
        try {
            if (imovel.getId() == null) {
                imovelDao.salvar(imovel);
            } else {
                imovelDao.atualizar(imovel);
            }
            imoveis = imovelDao.findAll();
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sucesso", "Imovel Salvo com Sucesso"));
            RequestContext.getCurrentInstance().execute("$('#modal-imovel').modal('hide');");
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Não foi possível salvar o imóvel"));
        }
    }

    public void excluir(Imovel imovel) {
        try {
            imovelDao.deletar(imovel);
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sucesso", "Imovel Deletado com Sucesso"));
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Não foi possível deletar o Imovel"));
        }
    }

    //Listeners
    public void onClickAdicionar() {
        imovel = new Imovel();
        RequestContext.getCurrentInstance().execute("$('#modal-imovel').modal('show');");
    }

    public void onClickEditar() {
        if (imovel != null && imovel.getId() != null) {
            RequestContext.getCurrentInstance().execute("$('#modal-imovel').modal('show');");
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Selecione uma Imovel para Editar"));
        }
    }

    public void onClickExcluir() {
        if (imovel != null && imovel.getId() != null) {
            excluir(imovel);
            imoveis = imovelDao.findAll();
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Selecione um Imóvel para Exluir"));
        }
    }

    //Getters e Setters
    public List<Imovel> getImoveis() {
        return imoveis;
    }

    public void setImoveis(List<Imovel> imoveis) {
        this.imoveis = imoveis;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public List<Imobiliaria> getImobiliarias() {
        return imobiliarias;
    }

    public void setImobiliarias(List<Imobiliaria> imobiliarias) {
        this.imobiliarias = imobiliarias;
    }
}