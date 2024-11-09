package com.api.loja.controller;

import com.api.loja.address.AddressDTO;
import com.api.loja.customer.CustomerDAO;
import com.api.loja.customer.RegisterCustomer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerDAO customerDAO;

    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @PostMapping
    public ResponseEntity register(@RequestBody RegisterCustomer registerCustomer) {

        customerDAO.save(registerCustomer);
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer saved successfully");
    }
}