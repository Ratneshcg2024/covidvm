package com.cg.covidvm.service;

 

import java.util.List;
import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

import com.cg.covidvm.entity.Certification;
import com.cg.covidvm.exception.CertificationNotFoundException;
import com.cg.covidvm.model.CertificationDto;
import com.cg.covidvm.repository.CertificationRepository;

 

@Service
public class CertificationServiceImpl implements CertificationService{

 

    @Autowired
    private CertificationRepository certificationRepository;

    @Override
    public CertificationDto saveCertification(CertificationDto certificationDto) {

 

        Certification cer = new Certification();
        cer.setCertificateId(certificationDto.getCertificateId());

 

        Certification newCertification= certificationRepository.save(cer);
        CertificationDto newCertificationDto= new CertificationDto();
        newCertificationDto.setCertificateId(newCertification.getCertificateId());

        return newCertificationDto;
    }

    @Override
    public List<Certification> getAllCertifications() {
        List<Certification> certification = certificationRepository.findAll();
        return certification;
    }

   

}