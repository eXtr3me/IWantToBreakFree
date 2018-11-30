package org.academiadecodigo.variachis.delta.back_end.controllers;

import org.academiadecodigo.variachis.delta.back_end.controllers.rest.CustomerRestController;
import org.academiadecodigo.variachis.delta.back_end.converters.AuthCustomerDTOToCustomer;
import org.academiadecodigo.variachis.delta.back_end.converters.CustomerToCustomerDTO;
import org.academiadecodigo.variachis.delta.back_end.dto.AuthCustomerDTO;
import org.academiadecodigo.variachis.delta.back_end.dto.CustomerDTO;
import org.academiadecodigo.variachis.delta.back_end.exceptions.CustomerNotFoundException;
import org.academiadecodigo.variachis.delta.back_end.persistence.model.Customer;
import org.academiadecodigo.variachis.delta.back_end.services.AuthService;
import org.academiadecodigo.variachis.delta.back_end.services.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class LoginController {

    private AuthCustomerDTOToCustomer authCustomerDTOToCustomer;
    private AuthService authService;
    private CustomerRestController customerRestController;
    private CustomerToCustomerDTO customerToCustomerDTO;

    @Autowired
    public void setAuthCustomerDTOToCustomer(AuthCustomerDTOToCustomer authCustomerDTOToCustomer) {
        this.authCustomerDTOToCustomer = authCustomerDTOToCustomer;
    }

    @Autowired
    public void setAuthService(AuthServiceImpl authService) {
        this.authService = authService;
    }

    @Autowired
    public void setCustomerRestController(CustomerRestController customerRestController) {
        this.customerRestController = customerRestController;
    }

    @Autowired
    public void setCustomerToCustomerDTO(CustomerToCustomerDTO customerToCustomerDTO) {
        this.customerToCustomerDTO = customerToCustomerDTO;
    }

    //login verification
    //POST
    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addCustomer(@Valid @RequestBody AuthCustomerDTO authCustomerDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Customer customer = null;

        try {
            customer = authService.verify(authCustomerDTO);

        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        CustomerDTO customerDTO = customerToCustomerDTO.convert(customer);

        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }



}
