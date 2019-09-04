/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitins.dao;

import com.unitins.model.Usuario;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDao<PK, T> implements Serializable {
    
    private final static String UNIT_NAME = "imoveisPU";
    
    @PersistenceContext(unitName = UNIT_NAME)
    private EntityManager entityManager;
    private final Class<T> entityClass;

    /**
     * Método construtor
     *
     * @param entityClass
     */
    public GenericDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    //GETERS AND SETERS
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Salva um objeto.
     *
     * @param entity
     * @return boolean
     */
    public boolean salvar(T entity) {
        try {
            entityManager.persist(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Atualiza um objeto.
     *
     * @param entity
     * @return T
     */
    public boolean atualizar(T entity) {
        try {
            entityManager.merge(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Deleta um objeto.
     *
     * @param entity
     * @return boolean
     */
    public boolean deletar(T entity) {
        try {
            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retorna um objeto pelo id.
     *
     * @param pk
     * @return
     */
    public T findById(PK pk) {
        return (T) entityManager.find(entityClass, pk);
    }

    /**
     * Retorna uma lista objetos.
     *
     * @return
     */
    public List<T> findAll() {
        return entityManager.createQuery("FROM " + entityClass.getName()).getResultList();
    }

}
