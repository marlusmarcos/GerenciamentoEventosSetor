package com.dejad10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dejad10.domain.Congregacao;
import com.dejad10.domain.ICongregacaoRepository;

@Service
public class CongregacaoService {

	@Autowired
	private ICongregacaoRepository congregacaoRepository;
	
	public Congregacao saveCongregacao(Congregacao c) {
		return congregacaoRepository.save(c);
	}
	
	public List<Congregacao> getAll () {
		return congregacaoRepository.findAll();
	}
}
