package com.carlos.infnet.dr4_tp3.services;

import com.carlos.infnet.dr4_tp3.domains.Pedido;

import java.util.concurrent.CompletableFuture;

public interface PedidoCommandService {
    CompletableFuture<String> criarPedido(Pedido pedido);
}
