package org.academiadecodigo.variachis.delta.back_end.converters;

import org.academiadecodigo.variachis.delta.back_end.dto.AuthCustomerDTO;
import org.academiadecodigo.variachis.delta.back_end.persistence.model.Customer;
import org.academiadecodigo.variachis.delta.back_end.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthCustomerDTOToCustomer implements Converter<AuthCustomerDTO, Customer> {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer convert(AuthCustomerDTO authCustomerDTO) {

        Customer customer = (authCustomerDTO.getId() != null ? customerService.get(authCustomerDTO.getId()) : new Customer());

        customer.setUsername(authCustomerDTO.getUsername());
        customer.setPassword(authCustomerDTO.getPassword());

        return customer
    }
}
