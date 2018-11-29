package org.academiadecodigo.variachis.delta.back_end.converters;

import org.academiadecodigo.variachis.delta.back_end.dto.CustomerDTO;
import org.academiadecodigo.variachis.delta.back_end.persistence.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerToCustomerDTO implements Converter<Customer, CustomerDTO> {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public CustomerDTO convert(Customer customer) {

        CustomerDTO customerDTO = (customer.getId() != null ? customerService.get(customer.getId()) : new CustomerDTO());

        customerDTO.setUsername(customer.getUsername());
        customerDTO.setPassword(customer.getPassword());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setAddiction(customer.getAddiction());

        return customerDTO;
    }
}
