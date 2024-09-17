package com.carlos.infnet.dr4_tp3.services;

import com.carlos.infnet.dr4_tp3.domains.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoQueryService {
    Optional<Pedido> obterPorId(String id);
    List<Object> listarEventos(String id);
}
