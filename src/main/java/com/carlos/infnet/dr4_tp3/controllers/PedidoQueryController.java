package com.carlos.infnet.dr4_tp3.controllers;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.infnet.dr4_tp3.domains.Pedido;
import com.carlos.infnet.dr4_tp3.services.PedidoQueryService;



@RestController
@RequestMapping(value = "/pedidos")
public class PedidoQueryController {

    private final PedidoQueryService pedidoQueryService;

    public PedidoQueryController(@Qualifier("pedidoQueryServiceImpl") PedidoQueryService pedidoQueryService) {
        this.pedidoQueryService = pedidoQueryService;
    }

    @GetMapping("/{id}/eventos")
    public List<Object> listarEventos(@PathVariable(value = "id") String id) {
        return pedidoQueryService.listarEventos(id);
    }

    @GetMapping("/{id}")
    public Pedido obterPorId(@PathVariable(value = "id") String id) {
        Optional<Pedido> pedido = pedidoQueryService.obterPorId(id);
        return pedido.orElse(null);
    }
}
