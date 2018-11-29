package org.academiadecodigo.variachis.delta.back_end.controllers;


import org.academiadecodigo.variachis.delta.back_end.converters.AuthCustomerDTOToCustomer;
import org.academiadecodigo.variachis.delta.back_end.converters.CustomerToCustomerDTO;
import org.academiadecodigo.variachis.delta.back_end.converters.CustomerDTOToCustomer;
import org.academiadecodigo.variachis.delta.back_end.dto.AuthCustomerDTO;
import org.academiadecodigo.variachis.delta.back_end.dto.CustomerDTO;
import org.academiadecodigo.variachis.delta.back_end.persistence.model.Customer;
import org.academiadecodigo.variachis.delta.back_end.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class LoginController {

    private AuthCustomerDTOToCustomer authCustomerDTOToCustomer;
    private AuthService authService;
    private CustomerToCustomerDTO customerToCustomerDTO;
    private CustomerDTOToCustomer dtoCustomerToCustomer;
    private CustomerRestController customerRestController;


   //POST
   @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
   public ResponseEntity<?> addCustomer(@Valid @RequestBody AuthCustomerDTO authCustomerDTO, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

       if (bindingResult.hasErrors()) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }

       Customer loginCustomer = authService.verify(authCustomerDTOToCustomer.convert(authCustomerDTO));

      customerRestController.getCustomer(loginCustomer.getId());
   };
}
