package com.cg.covidvm.service;

 

import java.util.List;

 

import com.cg.covidvm.entity.Certification;
import com.cg.covidvm.model.CertificationDto;

 

public interface CertificationService {

    public CertificationDto saveCertification(CertificationDto certificationDto);

    public List<Certification> getAllCertifications();

    

 

}