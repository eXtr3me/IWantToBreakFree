package org.academiadecodigo.variachis.delta.back_end.services;

import org.academiadecodigo.variachis.delta.back_end.persistence.dao.CustomerDAO;
import org.academiadecodigo.variachis.delta.back_end.persistence.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {


    private CustomerDAO customerDAO;

    @Autowired
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer get(Integer id) {
        return customerDAO.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerDAO.saveOrUpdate(customer);
    }

    @Override
    public void delete(Integer id) {
        Customer customer = customerDAO.findById(id);
        customerDAO.delete(id);
    }


}
