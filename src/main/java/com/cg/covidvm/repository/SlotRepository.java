package com.cg.covidvm.repository;

 

 

import org.springframework.data.jpa.repository.JpaRepository;

 

 

import org.springframework.stereotype.Repository;

 

 

import com.cg.covidvm.entity.Slot;

 

 

@Repository
public interface SlotRepository extends JpaRepository<Slot, Integer> {

 

 

}