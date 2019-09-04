package com.unitins.dao;

import com.unitins.model.Imobiliaria;
import javax.ejb.Stateless;

@Stateless
public class ImobiliariaDao extends GenericDao<Integer, Imobiliaria>{
    
    public ImobiliariaDao() {
        super(Imobiliaria.class);
    }
    
}
