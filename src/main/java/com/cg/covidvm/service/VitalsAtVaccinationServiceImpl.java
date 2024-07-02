package com.cg.covidvm.service;

 

 

import java.util.List;

 

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

 

import com.cg.covidvm.entity.VitalsAtVaccination;
import com.cg.covidvm.repository.VitalsAtVaccinationRepository;
@Service
public class VitalsAtVaccinationServiceImpl implements VitalsAtVaccinationService {

 

    @Autowired
    private VitalsAtVaccinationRepository vitalsAtVaccinationRepository;

 

    @Override
    public List<VitalsAtVaccination> getVitalDetails() {
        List<VitalsAtVaccination> vitalsAtVaccination = vitalsAtVaccinationRepository.findAll();
        return vitalsAtVaccination;
    }

 

}