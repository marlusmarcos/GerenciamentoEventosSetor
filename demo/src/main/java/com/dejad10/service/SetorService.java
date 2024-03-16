package com.dejad10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dejad10.domain.Setor;
import com.dejad10.repository.ISetorRepository;

@Service
public class SetorService {

	@Autowired
	private ISetorRepository setorRepository;
	
	public Setor saveSetor (Setor setor) {
		return setorRepository.save(setor);
	}
}
