package com.cg.covidvm.repository;

 

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 

 

import com.cg.covidvm.entity.VaccinationCentre;

 

 

@Repository
public interface VaccinationCentreRepository extends JpaRepository<VaccinationCentre, Integer> {

 

 

}