/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitins.autenticacao;

import com.unitins.model.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Francisco
 */
public class LoginFilter implements Filter {

    @Override
   public void destroy() {
       // TODO Auto-generated method stub 
   }

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
           throws IOException, ServletException {
       Usuario usuario = null;
       HttpSession sessao = ((HttpServletRequest) request).getSession(false);
       if (sessao != null) {
           usuario = (Usuario) sessao.getAttribute("usuarioLogado");
       }
       if (usuario == null) {
           String contextPath = ((HttpServletRequest) request).getContextPath();
           ((HttpServletResponse) response).sendRedirect(contextPath + "/login.xhtml");
       } else {
           chain.doFilter(request, response);
       }
   }

   @Override
   public void init(FilterConfig arg0) throws ServletException {
       // TODO Auto-generated method stub
   }
}
