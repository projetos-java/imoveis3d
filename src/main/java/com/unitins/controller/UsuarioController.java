package com.unitins.controller;

import com.unitins.dao.UsuarioDao;
import com.unitins.model.Usuario;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class UsuarioController implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private UsuarioDao usuarioDAO;
    private Usuario usuario;


    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }

    public void adicionar() {
        if (usuarioDAO.verificaEmail(usuario)) {
            try{
                if(usuario.getId() == null){
                    usuarioDAO.salvar(usuario);
                }else{
                    usuarioDAO.atualizar(usuario);
                }
                FacesContext.getCurrentInstance()
                        .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sucesso", "Usuário Salvo"));
                //Limpa e Atualiza e Fecha o modal
                usuario = new Usuario();
                RequestContext.getCurrentInstance().execute("$('#modal-add-usuario').modal('hide');");
            }catch (Exception e){
                e.printStackTrace();
                FacesContext.getCurrentInstance()
                        .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Não foi possível salvar o Usuário"));
            }
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Nome de Usuario Não Disponível"));
        }
    }

    //Getters e Setters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}