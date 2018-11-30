package org.academiadecodigo.variachis.delta.back_end.services;

import javassist.NotFoundException;
import org.academiadecodigo.variachis.delta.back_end.dto.AuthCustomerDTO;
import org.academiadecodigo.variachis.delta.back_end.exceptions.CustomerNotFoundException;
import org.academiadecodigo.variachis.delta.back_end.persistence.model.Customer;

public interface AuthService {


    Customer verify(AuthCustomerDTO authCustomerDTO) throws CustomerNotFoundException;

}
