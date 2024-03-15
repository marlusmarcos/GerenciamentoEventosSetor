package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Repository.IAreaRepository;
import domain.Area;

@Service
public class AreaService {
	@Autowired
	private IAreaRepository areaRepository;
	
	Area area = new Area();
	
	public Area saveArea(Area area2) {
		//area.setNumero(15);
		return areaRepository.save(area2);
	}
	public List<Area> getAreas () {
		return areaRepository.findAll();
	}
}
