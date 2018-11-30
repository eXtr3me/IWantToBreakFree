package org.academiadecodigo.variachis.delta.back_end.persistence.dao;

import org.academiadecodigo.variachis.delta.back_end.persistence.model.Customer;
import org.academiadecodigo.variachis.delta.back_end.persistence.model.DiaryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CustomerDAO {

    protected Class<Customer> modelType = Customer.class;

    protected EntityManager entityManager;

    @PersistenceContext
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

        if (customer.getPassword().equals(password)) {
            return customer;
        }

        return null;
    }

    public List<DiaryEntry> getDiary(Customer customer) {
        Customer customer1 = entityManager.find(modelType, customer.getId());

        return customer1.getDiary();
    }
}
