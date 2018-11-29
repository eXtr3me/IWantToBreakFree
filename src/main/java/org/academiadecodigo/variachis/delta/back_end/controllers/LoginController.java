package org.academiadecodigo.variachis.delta.back_end.controllers;


import org.academiadecodigo.variachis.delta.back_end.converters.CustomerToDTOCustomer;
import org.academiadecodigo.variachis.delta.back_end.converters.DTOCustomerToCustomer;
import org.academiadecodigo.variachis.delta.back_end.dto.DTOCustomer;
import org.academiadecodigo.variachis.delta.back_end.persistence.model.Customer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class LoginController {

    private AuthService authService;
    private CustomerToDTOCustomer customerToDTOCustomer;
    private DTOCustomerToCustomer dtoCustomerToCustomer;
    private CustomerRestController customerRestController;


   //POST
   @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
   public ResponseEntity<?> addCustomer(@Valid @RequestBody AuthCustomerDTO authCustomerDTO, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

       if (bindingResult.hasErrors()) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }

       Customer loginCustomer = authService.verify(Auth.convert(authCustomerDTO));

      customerRestController.getCustomer(loginCustomer.getId());
   };
}
