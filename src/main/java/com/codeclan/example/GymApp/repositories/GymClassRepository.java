package com.codeclan.example.GymApp.repositories;

import com.codeclan.example.GymApp.models.GymClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymClassRepository extends JpaRepository<GymClass, Long> {

    List<GymClass> findByBookingsCustomerId(Long id);

}
