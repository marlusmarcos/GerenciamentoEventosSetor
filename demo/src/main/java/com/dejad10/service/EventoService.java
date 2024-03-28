package com.dejad10.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dejad10.domain.Evento;
import com.dejad10.domain.dto.EventoPagamentoDTO;
import com.dejad10.repository.IEventoRepository;

@Service
public class EventoService {

    @Autowired
    private IEventoRepository eventoRepository;

    public List<Evento> getAllEventos() {
        return eventoRepository.findAll();
    }

    public Optional<Evento> getEventoById(Long id) {
        return eventoRepository.findById(id);
    }

    public Evento saveEvento(Evento evento) {
        return eventoRepository.save(evento);
    }
    public List<EventoPagamentoDTO> getPagamentoEventos () {
    	return eventoRepository.obterQuantidadePagaPorEvento();
    }
    
}