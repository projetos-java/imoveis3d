package com.unitins.dao;

import com.unitins.model.Categoria;
import javax.ejb.Stateless;

@Stateless
public class CategoriaDao extends GenericDao<Integer, Categoria>{
    
    public CategoriaDao() {
        super(Categoria.class);
    }
    
}
