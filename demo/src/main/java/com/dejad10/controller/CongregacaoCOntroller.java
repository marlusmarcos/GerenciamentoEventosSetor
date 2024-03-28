package com.dejad10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dejad10.domain.Congregacao;
import com.dejad10.service.CongregacaoService;

@RestController
@RequestMapping("congregacao")
public class CongregacaoCOntroller {

	@Autowired
	private CongregacaoService congrecaoService;

	@PostMapping
	public Congregacao save (@RequestBody Congregacao c) {
		return congrecaoService.saveCongregacao(c);
	}
	@GetMapping
	public List<Congregacao> getAll(){
		return congrecaoService.getAll();
	}
}
