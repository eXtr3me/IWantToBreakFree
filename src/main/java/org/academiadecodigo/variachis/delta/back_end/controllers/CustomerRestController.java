package org.academiadecodigo.variachis.delta.back_end.controllers;


import org.academiadecodigo.variachis.delta.back_end.converters.CustomerToCustomerDTO;
import org.academiadecodigo.variachis.delta.back_end.converters.CustomerDTOToCustomer;
import org.academiadecodigo.variachis.delta.back_end.dto.CustomerDTO;
import org.academiadecodigo.variachis.delta.back_end.persistence.model.Customer;
import org.academiadecodigo.variachis.delta.back_end.services.CustomerService;
import org.academiadecodigo.variachis.delta.back_end.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/customer")
public class CustomerRestController {

    private CustomerService customerService;
    private CustomerToCustomerDTO customerToDTOCustomer;
    private CustomerDTOToCustomer dtoCustomerToCustomer;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setCustomerToDTOCustomer(CustomerToCustomerDTO customerToDTOCustomer) {
        this.customerToDTOCustomer = customerToDTOCustomer;
    }

    @Autowired
    public void setDtoCustomerToCustomer(CustomerDTOToCustomer dtoCustomerToCustomer) {
        this.dtoCustomerToCustomer = dtoCustomerToCustomer;
    }

    //serve a json with the customers info
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Integer id) {

        Customer customer = customerService.get(id);

        return new ResponseEntity<>(customerToDTOCustomer.convert(customer), HttpStatus.OK);
    }

    //post a new customer
    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addCustomer(@Valid @RequestBody CustomerDTO dtoCustomer, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

        if (bindingResult.hasErrors() || dtoCustomer.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Customer savedCustomer = customerService.save(dtoCustomerToCustomer.convert(dtoCustomer));

        // get help from the framework building the path for the newly created resource
        UriComponents uriComponents = uriComponentsBuilder.path("/customer/" + savedCustomer.getId()).build();

        // set headers with the created path
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    //edit a customer
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<CustomerDTO> editCustomer(@Valid @RequestBody CustomerDTO customerDto, BindingResult bindingResult, @PathVariable Integer id) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (customerDto.getId() != null && !customerDto.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (customerService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customerDto.setId(id);

        customerService.save(dtoCustomerToCustomer.convert(customerDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //delete a customer
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable Integer id) {
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
