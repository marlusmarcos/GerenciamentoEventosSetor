package com.dejad10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dejad10.domain.Area;
import com.dejad10.repository.IAreaRepository;

@Service
public class AreaService {
	@Autowired
	private IAreaRepository areaRepository;
		
	public Area saveArea(Area area2) {
		//area.setNumero(15);
		return areaRepository.save(area2);
	}
	public List<Area> getAreas () {
		return areaRepository.findAll();
	}
}
