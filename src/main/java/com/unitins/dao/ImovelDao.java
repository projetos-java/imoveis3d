/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitins.dao;

import com.unitins.model.Imovel;
import javax.ejb.Stateless;

@Stateless
public class ImovelDao extends GenericDao<Integer, Imovel>{
   
    public ImovelDao() {
        super(Imovel.class);
    }
   
}
