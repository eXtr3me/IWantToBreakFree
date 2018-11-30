package org.academiadecodigo.variachis.delta.back_end.controllers;

import javassist.NotFoundException;
import org.academiadecodigo.variachis.delta.back_end.converters.AuthCustomerDTOToCustomer;
import org.academiadecodigo.variachis.delta.back_end.converters.CustomerToCustomerDTO;
import org.academiadecodigo.variachis.delta.back_end.converters.CustomerDTOToCustomer;
import org.academiadecodigo.variachis.delta.back_end.dto.AuthCustomerDTO;
import org.academiadecodigo.variachis.delta.back_end.dto.CustomerDTO;
import org.academiadecodigo.variachis.delta.back_end.persistence.model.Customer;
import org.academiadecodigo.variachis.delta.back_end.services.AuthService;
import org.academiadecodigo.variachis.delta.back_end.services.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/")
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
    public void setAuthService(AuthService authService) {
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

    //POST
    @RequestMapping(method = RequestMethod.POST, path = {"/login", ""})
    public ResponseEntity<?> addCustomer(@Valid @RequestBody AuthCustomerDTO authCustomerDTO, BindingResult bindingResult) {

        System.out.println(authCustomerDTO);

        if (bindingResult.hasErrors()) {
            System.out.println("ERRORS");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Customer customer = null;

        try {
            customer = authService.verify(authCustomerDTO);

        } catch (NotFoundException e) {
            System.out.println("NOT VERIFIED");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (customer == null) {
            System.out.println("NOT FOUND");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        System.out.println("OK");
        CustomerDTO customerDTO = customerToCustomerDTO.convert(customer);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }


}
