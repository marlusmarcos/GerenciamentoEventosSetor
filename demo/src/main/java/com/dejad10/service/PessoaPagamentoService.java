package com.dejad10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dejad10.domain.PessoaPagamento;
import com.dejad10.repository.IPessoaPagamentoRepository;

@Service
public class PessoaPagamentoService {

    @Autowired
    private IPessoaPagamentoRepository pessoaPagamentoRepository;

    public PessoaPagamento savePessoaPagamento(PessoaPagamento pessoaPagamento) {
        return pessoaPagamentoRepository.save(pessoaPagamento);
    }

    
}
