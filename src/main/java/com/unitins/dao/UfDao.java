package com.unitins.dao;

import com.unitins.model.Uf;
import javax.ejb.Stateless;

@Stateless
public class UfDao extends GenericDao<Integer, Uf>{
    
     public UfDao() {
        super(Uf.class);
    }
}
