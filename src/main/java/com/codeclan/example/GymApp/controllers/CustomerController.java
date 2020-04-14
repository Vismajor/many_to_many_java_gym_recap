package com.codeclan.example.GymApp.controllers;

import com.codeclan.example.GymApp.models.Customer;
import com.codeclan.example.GymApp.models.GymClass;
import com.codeclan.example.GymApp.repositories.CustomerRepository;
import com.codeclan.example.GymApp.repositories.GymClassRepository;
import org.omg.CORBA.RepositoryIdHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    GymClassRepository gymClassRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}/gymclasses")
    public ResponseEntity<List<GymClass>> getGymClassesForCustomer(@PathVariable Long id){
        return new ResponseEntity<>(gymClassRepository.findByBookingsCustomerId(id), HttpStatus.OK);
    }

}
