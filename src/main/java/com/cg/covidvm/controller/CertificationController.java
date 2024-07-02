package com.cg.covidvm.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

 

import com.cg.covidvm.entity.Certification;
import com.cg.covidvm.model.CertificationDto;
import com.cg.covidvm.service.CertificationService;

 

@RestController
public class CertificationController {

    @Autowired
    private CertificationService certificationService;

    @GetMapping("/certification/all")
    public List<Certification> fetchAllCertification() {
        List<Certification> list = certificationService.getAllCertifications();
        return list;
    }

    @PostMapping("/certification/save")
    public ResponseEntity<CertificationDto> addcertification(@Valid @RequestBody CertificationDto certificationDto) {
        CertificationDto newCertificationDto = certificationService.saveCertification(certificationDto);
        ResponseEntity<CertificationDto> responseEntity = new ResponseEntity<>(newCertificationDto, HttpStatus.CREATED);
        return responseEntity;
    }

    
 


}