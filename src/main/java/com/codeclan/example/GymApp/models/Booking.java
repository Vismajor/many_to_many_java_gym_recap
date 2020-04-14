package com.codeclan.example.GymApp.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "paid")
    private boolean paid;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "gym_class_id")
    GymClass gymClass;

    public Booking(boolean paid, Customer customer, GymClass gymClass){
        this.paid = paid;
        this.customer = customer;
        this.gymClass = gymClass;
    }

    public Booking(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean paid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public GymClass getGymClass() {
        return gymClass;
    }

    public void setGymClass(GymClass gymClass) {
        this.gymClass = gymClass;
    }
}
