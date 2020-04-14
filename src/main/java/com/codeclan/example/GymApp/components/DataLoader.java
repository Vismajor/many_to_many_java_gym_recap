package com.codeclan.example.GymApp.components;

import com.codeclan.example.GymApp.models.Booking;
import com.codeclan.example.GymApp.models.Customer;
import com.codeclan.example.GymApp.models.GymClass;
import com.codeclan.example.GymApp.repositories.BookingRepository;
import com.codeclan.example.GymApp.repositories.CustomerRepository;
import com.codeclan.example.GymApp.repositories.GymClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    GymClassRepository gymClassRepository;

    @Autowired
    BookingRepository bookingRepository;

    public void run(ApplicationArguments args){
        Customer customer1 = new Customer("Fraser");
        customerRepository.save(customer1);

        Customer customer2 = new Customer("GG");
        customerRepository.save(customer2);

        GymClass yogaClass = new GymClass("Yoga");
        gymClassRepository.save(yogaClass);

        GymClass weightClass = new GymClass("Weights");
        gymClassRepository.save(weightClass);

        Booking booking1 = new Booking(true, customer1, yogaClass);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking(false, customer1, weightClass);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking(true, customer2, yogaClass);
        bookingRepository.save(booking3);
    }


}
