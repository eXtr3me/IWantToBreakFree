package org.academiadecodigo.variachis.delta.back_end.converters;

import org.academiadecodigo.variachis.delta.back_end.dto.CustomerDTO;
import org.academiadecodigo.variachis.delta.back_end.persistence.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerToCustomerDTO extends AbstractConverter<Customer, CustomerDTO> {

    @Override
    public CustomerDTO convert(Customer customer) {

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setUsername(customer.getUsername());
        customerDTO.setPassword(customer.getPassword());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setAddiction(customer.getAddiction());

        return customerDTO;
    }
}
