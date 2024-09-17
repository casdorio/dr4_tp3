package com.carlos.infnet.dr4_tp3.events;

import java.util.List;

import com.carlos.infnet.dr4_tp3.domains.Item;

public class PedidoCriadoEvent extends BaseEvent<String> {

    public final String descricao;
    public final double valor;
    public List<Item> items;

    public PedidoCriadoEvent(String id, String descricao, double valor, List<Item> items) {
        super(id);
        this.descricao = descricao;
        this.valor = valor;
        this.items = items;
    }
}