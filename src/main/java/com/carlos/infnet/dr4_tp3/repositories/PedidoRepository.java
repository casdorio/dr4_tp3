package com.carlos.infnet.dr4_tp3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlos.infnet.dr4_tp3.domains.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, String> {
}