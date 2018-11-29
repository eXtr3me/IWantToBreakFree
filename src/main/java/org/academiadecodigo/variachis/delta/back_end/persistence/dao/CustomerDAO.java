package org.academiadecodigo.variachis.delta.back_end.persistence.dao;

import org.academiadecodigo.variachis.delta.back_end.persistence.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomerDAO {

    protected Class<Customer> modelType;

    @PersistenceContext
    protected EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Customer findById(Integer id) {
        return entityManager.find(modelType, id);
    }

    public Customer saveOrUpdate(Customer customer) {
        return entityManager.merge(customer);
    }

    public void delete(Integer id) {
        entityManager.remove(entityManager.find(modelType, id));
    }
}
