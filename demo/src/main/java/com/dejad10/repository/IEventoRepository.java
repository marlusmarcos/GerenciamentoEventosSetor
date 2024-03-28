package com.dejad10.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dejad10.domain.Evento;
import com.dejad10.domain.dto.EventoPagamentoDTO;

public interface IEventoRepository extends JpaRepository<Evento, Long>{

    @Query("SELECT NEW com.dejad10.domain.dto.EventoPagamentoDTO(" +
            "e.descricao AS nomeEvento, " +
            "COUNT(pp.pessoa.id) AS quantidadePessoasPagaram, " +
            "SUM(pp.valorRecebido) AS valorTotalPago) " +
            "FROM Evento e " +
            "LEFT JOIN PessoaPagamento pp ON e.id = pp.evento.id " +
            "GROUP BY e.descricao")
	    List<EventoPagamentoDTO> obterQuantidadePagaPorEvento();
}
