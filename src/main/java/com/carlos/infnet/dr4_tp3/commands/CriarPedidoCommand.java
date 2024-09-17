package com.carlos.infnet.dr4_tp3.commands;

import java.util.List;

import com.carlos.infnet.dr4_tp3.domains.Item;

public class CriarPedidoCommand extends BaseCommand<String> {

    public final String descricao;
    public final double valor;
    public List<Item> items;

    public CriarPedidoCommand(String id, String descricao, double valor, List<Item> items) {
        super(id);
        this.descricao = descricao;
        this.valor = valor;
        this.items = items;
    }
}

