package com.cg.covidvm.repository;

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 

import com.cg.covidvm.entity.Certification;

 

@Repository
public interface CertificationRepository extends JpaRepository<Certification, Integer>{


 

}