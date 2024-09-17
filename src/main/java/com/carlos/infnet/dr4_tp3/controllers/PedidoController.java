package com.carlos.infnet.dr4_tp3.controllers;

import com.carlos.infnet.dr4_tp3.domains.Pedido;
import com.carlos.infnet.dr4_tp3.services.PedidoCommandService;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    private final PedidoCommandService pedidoCommandService;

    public PedidoController(PedidoCommandService pedidoCommandService) {
        this.pedidoCommandService = pedidoCommandService;
    }

    @PostMapping
    public CompletableFuture<String> criarPedido(@RequestBody Pedido pedido) {
        return pedidoCommandService.criarPedido(pedido);
    }


}
