package com.codeclan.example.GymApp;

import com.codeclan.example.GymApp.models.Customer;
import com.codeclan.example.GymApp.models.GymClass;
import com.codeclan.example.GymApp.repositories.CustomerRepository;
import com.codeclan.example.GymApp.repositories.GymClassRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GymAppApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	GymClassRepository gymClassRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canGetGymClassByCustomerId(){
		Customer customer = customerRepository.findAll().get(0);
		List<GymClass> foundClasses = gymClassRepository.findByBookingsCustomerId(customer.getId());
		assertEquals(2, foundClasses.size());
	}

	@Test
	public void canGetCustomersByGymClassId(){
		GymClass gymClass = gymClassRepository.findAll().get(0);
		List<Customer> foundCustomers = customerRepository.findByBookingsGymClassId(gymClass.getId());
		assertEquals(2, foundCustomers.size());
	}

}
