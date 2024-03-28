package com.dejad10.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dejad10.domain.Evento;
import com.dejad10.domain.dto.EventoPagamentoDTO;
import com.dejad10.service.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> getAllEventos() {
        return eventoService.getAllEventos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> getEventoById(@PathVariable Long id) {
        Optional<Evento> evento = eventoService.getEventoById(id);
        return evento.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Evento> saveEvento(@RequestBody Evento evento) {
        Evento savedEvento = eventoService.saveEvento(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvento);
    }
    @GetMapping("/pagos")
    public List<EventoPagamentoDTO> getAllEventosPagos() {
        return eventoService.getPagamentoEventos();
    }
}