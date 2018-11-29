package org.academiadecodigo.variachis.delta.back_end.persistence.dao;

import org.academiadecodigo.variachis.delta.back_end.persistence.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
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

    public Customer getByName(String username) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = builder.createQuery(Customer.class);
        Root<Customer> root = criteriaQuery.from(Customer.class);
        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("username"), username));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public Customer verifyPassword(Customer customer, String password) {

        entityManager.find(modelType, customer);

        if (customer.getPassword() == password) {
            return customer;
        }

        return null;
    }
}
