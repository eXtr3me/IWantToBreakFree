package org.academiadecodigo.variachis.delta.back_end.services;

import org.academiadecodigo.variachis.delta.back_end.persistence.dao.CustomerDAO;
import org.academiadecodigo.variachis.delta.back_end.persistence.model.Customer;
import org.academiadecodigo.variachis.delta.back_end.persistence.model.DiaryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    private CustomerDAO customerDAO;

    @Autowired
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Transactional(readOnly = true)
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

    @Override
    public List<DiaryEntry> getDiary(Customer customer) {
        return customerDAO.getDiary(customer);
    }
    @Override
    public String getDate(){
        Date actualDate = new Date();
        String date = actualDate.toString();
        return date;
    }


}
