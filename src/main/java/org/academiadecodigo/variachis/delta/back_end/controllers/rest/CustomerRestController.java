package org.academiadecodigo.variachis.delta.back_end.controllers.rest;


import org.academiadecodigo.variachis.delta.back_end.converters.CustomerToCustomerDTO;
import org.academiadecodigo.variachis.delta.back_end.converters.CustomerDTOToCustomer;
import org.academiadecodigo.variachis.delta.back_end.converters.DiaryEntryToDiaryentryDTO;
import org.academiadecodigo.variachis.delta.back_end.dto.CustomerDTO;
import org.academiadecodigo.variachis.delta.back_end.dto.DiaryEntryDTO;
import org.academiadecodigo.variachis.delta.back_end.persistence.model.Customer;
import org.academiadecodigo.variachis.delta.back_end.persistence.model.DiaryEntry;
import org.academiadecodigo.variachis.delta.back_end.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/customer")
public class CustomerRestController {

    private CustomerService customerService;
    private CustomerToCustomerDTO customerToDTOCustomer;
    private CustomerDTOToCustomer dtoCustomerToCustomer;
    private DiaryEntryToDiaryentryDTO diaryEntryToDiaryentryDTO;

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

    @Autowired
    public void setDiaryEntryToDiaryentryDTO(DiaryEntryToDiaryentryDTO diaryEntryToDiaryentryDTO) {
        this.diaryEntryToDiaryentryDTO = diaryEntryToDiaryentryDTO;
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

    @GetMapping(path = "/{id}/diary")
    public ResponseEntity<List<DiaryEntryDTO>> accessDiary(@PathVariable Integer id) {

        List<DiaryEntry> diary = customerService.getDiary(customerService.get(id));

        List<DiaryEntryDTO> diaryDTO = new LinkedList<>();

        for (DiaryEntry entry : diary) {

            diaryDTO.add(diaryEntryToDiaryentryDTO.convert(entry));
        }

        return new ResponseEntity<>(diaryDTO, HttpStatus.OK);
    }


    @PostMapping(path = "/{id}/diary")
    public ResponseEntity<String> postNewEntryInDiary(@Valid @RequestBody String numberOfSmokedCigarretesToday, BindingResult bindingResult, @PathVariable Integer id) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (id == null || numberOfSmokedCigarretesToday == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (customerService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<DiaryEntry> diary = customerService.getDiary(customerService.get(id));

        DiaryEntry diaryEntry = new DiaryEntry();
        diaryEntry.setDate(new java.sql.Date(new java.util.Date().getTime()));
        diaryEntry.setNumberOfSmokedCigarretes(numberOfSmokedCigarretesToday);

        diary.add(diaryEntry);

        customerService.save(customerService.get(id));

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
