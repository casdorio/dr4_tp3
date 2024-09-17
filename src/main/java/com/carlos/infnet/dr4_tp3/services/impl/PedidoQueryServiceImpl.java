package com.carlos.infnet.dr4_tp3.services.impl;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.carlos.infnet.dr4_tp3.repositories.PedidoRepository;
import com.carlos.infnet.dr4_tp3.services.PedidoQueryService;

import com.carlos.infnet.dr4_tp3.domains.Pedido;

@Service
public class PedidoQueryServiceImpl implements PedidoQueryService {

    private final EventStore eventStore;
    private final PedidoRepository pedidoRepository;

    public PedidoQueryServiceImpl(EventStore eventStore, PedidoRepository pedidoRepository) {
        this.eventStore = eventStore;
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Object> listarEventos(String id) {
        return eventStore.readEvents(id)
                .asStream()
                .map(record -> record.getPayload())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Pedido> obterPorId(String id) {
        return pedidoRepository.findById(id);
    }
}
