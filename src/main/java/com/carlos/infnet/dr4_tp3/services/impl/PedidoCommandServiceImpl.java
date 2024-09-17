package com.carlos.infnet.dr4_tp3.services.impl;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlos.infnet.dr4_tp3.commands.CriarPedidoCommand;
import com.carlos.infnet.dr4_tp3.domains.Pedido;
import com.carlos.infnet.dr4_tp3.services.PedidoCommandService;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class PedidoCommandServiceImpl implements PedidoCommandService {

    @Autowired
    private CommandGateway commandGateway;

    @Override
    public CompletableFuture<String> criarPedido(Pedido pedido) {
        return commandGateway.send(new CriarPedidoCommand(
                UUID.randomUUID().toString(),
                pedido.getDescricao(),
                pedido.getValor(),
                pedido.getItems()));
    }
}
