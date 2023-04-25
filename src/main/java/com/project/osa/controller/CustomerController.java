package com.project.osa.controller;

import com.project.osa.dto.CustomerDto;
import com.project.osa.model.Customer;
import com.project.osa.repository.CustomerRepository;
import com.project.osa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/findAllCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers() {

        return ResponseEntity.ok(this.customerService.getAllCustomer());
    }
    
    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(this.customerService.addCustomer(customer));
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(this.customerService.updateCustomer(customerDto));
    }
}
