package com.cg.covidvm.repository;

 

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 

 

import com.cg.covidvm.entity.VitalsAtVaccination;

 

 

@Repository
public interface VitalsAtVaccinationRepository extends JpaRepository<VitalsAtVaccination,Integer>{

 

 

}