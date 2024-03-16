package com.dejad10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dejad10.domain.Area;
import com.dejad10.domain.Setor;
import com.dejad10.repository.IAreaRepository;
import com.dejad10.service.SetorService;

@RestController
@RequestMapping("setor")
public class SetorController {

	@Autowired
	private SetorService setorService; 
	@Autowired
    private IAreaRepository areaRepository;
	
	@PostMapping
	public Setor saveSetor(@RequestBody Setor setor) {
		//perdoe a má prática kk
		
		//Area area = areaRepository.findById(setor.get)
		return setorService.saveSetor(setor);
	}
}
