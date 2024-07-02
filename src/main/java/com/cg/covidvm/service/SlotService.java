package com.cg.covidvm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.covidvm.entity.Slot;
import com.cg.covidvm.model.SlotDto;

@Service
public interface SlotService {

	public SlotDto saveSlot(SlotDto slotDto);

	public void deleteSlot(int slotId);

	public List<Slot> getSlotDetails();

	public Slot getSlotById(int slotId);

}