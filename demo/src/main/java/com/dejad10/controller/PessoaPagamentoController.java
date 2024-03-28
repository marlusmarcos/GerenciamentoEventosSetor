package com.dejad10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dejad10.domain.PessoaPagamento;
import com.dejad10.service.PessoaPagamentoService;

@RestController
@RequestMapping("/pessoa-pagamentos")
public class PessoaPagamentoController {

    @Autowired
    private PessoaPagamentoService pessoaPagamentoService;

    @PostMapping
    public ResponseEntity<PessoaPagamento> createPessoaPagamento(@RequestBody PessoaPagamento pessoaPagamento) {
        PessoaPagamento createdPessoaPagamento = pessoaPagamentoService.savePessoaPagamento(pessoaPagamento);
        return new ResponseEntity<>(createdPessoaPagamento, HttpStatus.CREATED);
    }

}