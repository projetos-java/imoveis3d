package com.unitins.controller;

import com.unitins.dao.ImobiliariaDao;
import com.unitins.model.Imobiliaria;
import org.primefaces.context.RequestContext;

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
public class ImobiliariaController implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private ImobiliariaDao imobiliariaDao;
    private List<Imobiliaria> imobiliarias;
    private Imobiliaria imobiliaria;


    @PostConstruct
    public void init() {
        imobiliarias = new ArrayList<>();
        imobiliarias = imobiliariaDao.findAll();
    }

    //Persistencia
    public void salvar() {
        try {
            if (imobiliaria.getId() == null) {
                imobiliariaDao.salvar(imobiliaria);
            } else {
                imobiliariaDao.atualizar(imobiliaria);
            }
            imobiliarias = imobiliariaDao.findAll();
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sucesso", "Imobiliária Salva com Sucesso"));
            RequestContext.getCurrentInstance().execute("$('#modal-imobiliaria').modal('hide');");
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Não foi possível salvar a Imobiliária"));
        }
    }

    public void excluir(Imobiliaria imobiliaria) {
        try {
            imobiliariaDao.deletar(imobiliaria);
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sucesso", "Imobiliária Deletada com Sucesso"));
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Não foi possível deletar a Imobiliária"));
        }
    }

    //Listeners
    public void onClickAdicionar() {
        imobiliaria = new Imobiliaria();
        RequestContext.getCurrentInstance().execute("$('#modal-imobiliaria').modal('show');");
    }

    public void onClickEditar() {
        if (imobiliaria != null && imobiliaria.getId() != null) {
            RequestContext.getCurrentInstance().execute("$('#modal-imobiliaria').modal('show');");
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Selecione uma Imobiliária para Editar"));
        }
    }

    public void onClickExcluir() {
        if (imobiliaria != null && imobiliaria.getId() != null) {
            excluir(imobiliaria);
            imobiliarias = imobiliariaDao.findAll();
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Selecione uma Imobiliária para Exluir"));
        }
    }

    //Getters e Setters
    public Imobiliaria getImobiliaria() {
        return imobiliaria;
    }

    public void setImobiliaria(Imobiliaria imobiliaria) {
        this.imobiliaria = imobiliaria;
    }

    public List<Imobiliaria> getImobiliarias() {
        return imobiliarias;
    }

    public void setImobiliarias(List<Imobiliaria> imobiliarias) {
        this.imobiliarias = imobiliarias;
    }
}