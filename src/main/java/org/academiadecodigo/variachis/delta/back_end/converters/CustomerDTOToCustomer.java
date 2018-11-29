package org.academiadecodigo.variachis.delta.back_end.converters;

import org.academiadecodigo.variachis.delta.back_end.dto.CustomerDTO;
import org.academiadecodigo.variachis.delta.back_end.persistence.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTOToCustomer implements Converter<CustomerDTO, Customer> {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer convert(CustomerDTO customerDTO) {

        Customer customer = (customerDTO.getId() != null ? customerService.get(customerDTO.getId()) : new Customer());

        customer.setUsername(customerDTO.getUsername());
        customer.setPassword(customerDTO.getPassword());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        customer.setPhone(customerDTO.getAddiction());

        return customer;
    }
}
