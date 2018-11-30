package org.academiadecodigo.variachis.delta.back_end.controllers.web;

import org.academiadecodigo.variachis.delta.back_end.converters.CustomerDTOToCustomer;
import org.academiadecodigo.variachis.delta.back_end.converters.CustomerToCustomerDTO;
import org.academiadecodigo.variachis.delta.back_end.dto.CustomerDTO;
import org.academiadecodigo.variachis.delta.back_end.persistence.model.Customer;
import org.academiadecodigo.variachis.delta.back_end.persistence.model.DiaryEntry;
import org.academiadecodigo.variachis.delta.back_end.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.List;

//@Controller
//@RequestMapping("/web/customer")
public class CustomerController {
/*
    private CustomerService customerService;
    private CustomerToCustomerDTO customerToDTOCustomer;
    private CustomerDTOToCustomer customerDTOToCustomer;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setCustomerToDTOCustomer(CustomerToCustomerDTO customerToDTOCustomer) {
        this.customerToDTOCustomer = customerToDTOCustomer;
    }

    @Autowired
    public void setCustomerDTOToCustomer(CustomerDTOToCustomer customerDTOToCustomer) {
        this.customerDTOToCustomer = customerDTOToCustomer;
    }


    @GetMapping(path = {"/{id}"})
    public String getCustomer(@PathVariable Integer id, Model model) {

        Customer customer = customerService.get(id);

        // command objects for customer show view
        model.addAttribute("customer", customerToDTOCustomer.convert(customer));

        return "customer/show";
    }


    //post a new customer
    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public String addCustomer(@Valid @ModelAttribute("customer") CustomerDTO customerDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "customer/add-update";
        }

        Customer savedCustomer = customerService.save(customerDTOToCustomer.convert(customerDTO));

        redirectAttributes.addFlashAttribute("lastAction", "Saved " + savedCustomer.getUsername());
        return "redirect:/customer/" + savedCustomer.getId();
    }

    //edit a customer
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<CustomerDTO> editCustomer(@Valid @RequestBody CustomerDTO customerDto, BindingResult bindingResult, @PathVariable Integer id) {


    }


    //delete a customer
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}/delete")
    public String deleteCustomer(@PathVariable Integer id, RedirectAttributes redirectAttributes) {

        Customer customer = customerService.get(id);
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("lastAction", "Deleted " + customer.getUsername());
        return "redirect:/customer";
    }

    @GetMapping(path = "/{id}/diary")
    public String accessDiary (@PathVariable Integer id) {

        List<DiaryEntry> diary = customerService.getDiary(customerService.get(id));
        return "customer/" + id + "/diary";
    }


    @PostMapping (path = "/{id}/diary")
    public String postNewEntryInDiary(@Valid @ModelAttribute String numberOfSmokedCigarretesToday, BindingResult bindingResult, @PathVariable Integer id) {

        if (bindingResult.hasErrors()) {

        }

        if (id == null || numberOfSmokedCigarretesToday == null) {


        }

        if (customerService.get(id) == null) {

        }

        List<DiaryEntry> diary = customerService.getDiary(customerService.get(id));

        DiaryEntry diaryEntry = new DiaryEntry(Calendar.getInstance().getTime(), numberOfSmokedCigarretesToday);

        diary.add(diaryEntry);

        customerService.save(customerService.get(id));



    }




*/
}
