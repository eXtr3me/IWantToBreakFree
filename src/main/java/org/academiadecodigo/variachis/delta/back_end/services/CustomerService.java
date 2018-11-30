package org.academiadecodigo.variachis.delta.back_end.services;

import org.academiadecodigo.variachis.delta.back_end.persistence.model.Customer;

public interface CustomerService {


    Customer get(Integer id);

    Customer save(Customer customer);

    void delete (Integer id);

}
