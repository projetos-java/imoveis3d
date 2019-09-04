/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitins.controller;

import com.unitins.autenticacao.SessionContext;
import com.unitins.dao.UsuarioDao;
import com.unitins.model.Usuario;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Francisco
 */
@SessionScoped
@Named
public class LoginController implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private UsuarioDao usuarioDAO;

    private String email;
    private String senha;

    public LoginController() {
    }

    public Usuario getUsuario() {
        return (Usuario) SessionContext.getInstance().getUsuarioLogado();
    }

    public String doLogin() {
        Usuario usuario = usuarioDAO.login(email, senha);
        if (usuario == null) {
            FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Login Incorreto!",
                            "Login ou Senha errado, tente novamente"));
            FacesContext.getCurrentInstance().validationFailed();
            return "";
        } else {
            SessionContext.getInstance().setAttribute("usuarioLogado", usuario);
            return "/protegido/principal.xhtml?faces-redirect=true";
        }
    }

    public String doLogout() {
        SessionContext.getInstance().encerrarSessao();
        return "/login.xhtml?faces-redirect=true";
    }

    //Getters e Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
