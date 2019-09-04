
package com.unitins.dao;

import com.unitins.model.Endereco;
import javax.ejb.Stateless;

@Stateless
public class EnderecoDao extends GenericDao<Integer, Endereco>{
  
    public EnderecoDao() {
        super(Endereco.class);
    }
  
}
