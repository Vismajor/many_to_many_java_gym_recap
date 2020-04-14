package com.codeclan.example.GymApp.repositories;

import com.codeclan.example.GymApp.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsGymClassId(Long id);

}
