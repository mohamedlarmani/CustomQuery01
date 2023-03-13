package com.develhope.CustomQuery01.Repository;

import com.develhope.CustomQuery01.Entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
