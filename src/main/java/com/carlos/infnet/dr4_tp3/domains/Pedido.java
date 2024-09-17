package com.carlos.infnet.dr4_tp3.domains;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.carlos.infnet.dr4_tp3.commands.CriarPedidoCommand;
import com.carlos.infnet.dr4_tp3.events.PedidoCriadoEvent;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Aggregate
@Entity
@Table(name = "pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @AggregateIdentifier
    @Id
    private String id;
    private String descricao;
    private double valor;
    private String estado;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonInclude(JsonInclude.Include.NON_NULL) 
    @JsonProperty("items")
    private List<Item> items;

    @CommandHandler
    public Pedido(CriarPedidoCommand comando) {
        AggregateLifecycle.apply(new PedidoCriadoEvent(comando.id, comando.descricao, comando.valor, comando.items));
    }

    @EventSourcingHandler
    protected void on(PedidoCriadoEvent evento) {
        this.id = evento.id;
        this.descricao = evento.descricao;
        this.valor = evento.valor;
        this.estado = Status.PENDING.name();
        this.items = evento.items;
        
    }
}
