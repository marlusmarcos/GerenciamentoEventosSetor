package com.dejad10.domain.dto;

import java.math.BigDecimal;

public class EventoPagamentoDTO {

    private String nomeEvento;
    private Long quantidadePessoasPagaram;
    private double valorTotalPago;

    public EventoPagamentoDTO(String nomeEvento, Long quantidadePessoasPagaram, double valorTotalPago) {
        this.nomeEvento = nomeEvento;
        this.quantidadePessoasPagaram = quantidadePessoasPagaram;
        this.valorTotalPago = valorTotalPago;
    }

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public Long getQuantidadePessoasPagaram() {
		return quantidadePessoasPagaram;
	}

	public void setQuantidadePessoasPagaram(Long quantidadePessoasPagaram) {
		this.quantidadePessoasPagaram = quantidadePessoasPagaram;
	}

	public double getValorTotalPago() {
		return valorTotalPago;
	}

	public void setValorTotalPago(double valorTotalPago) {
		this.valorTotalPago = valorTotalPago;
	}

    
}