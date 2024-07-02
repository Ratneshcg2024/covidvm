package com.cg.covidvm.repository;

 

 

    import org.springframework.data.jpa.repository.JpaRepository;

 

 

import com.cg.covidvm.entity.DoseDetails;

 

 

    //@Repository
    public interface DoseDetailsRepository extends JpaRepository<DoseDetails, Integer> {

 

 

    }