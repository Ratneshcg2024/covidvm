package com.cg.covidvm.service;

import java.util.List;

import com.cg.covidvm.entity.DoseDetails;

public interface DoseDetailsService {

	public List<DoseDetails> getAllDoseDetails();

	DoseDetails saveDoseDetails(DoseDetails dosedetails);

}