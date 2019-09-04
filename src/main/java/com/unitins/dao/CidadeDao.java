package com.unitins.dao;

import com.unitins.model.Cidade;
import javax.ejb.Stateless;

@Stateless
public class CidadeDao extends GenericDao<Integer, Cidade>{
    
    public CidadeDao() {
        super(Cidade.class);
    }
    
}
