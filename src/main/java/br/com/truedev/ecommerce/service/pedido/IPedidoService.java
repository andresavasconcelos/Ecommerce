package br.com.truedev.ecommerce.service.pedido;

import br.com.truedev.ecommerce.dto.FaturamentoMensal;
import br.com.truedev.ecommerce.model.Pedido;

import java.util.List;

public interface IPedidoService {


    Pedido create(Pedido pedido);
    Pedido update(Pedido pedido);
    List<Pedido> listAllOder();
    Pedido findById(Integer numOrder);
    List<Pedido> findByStatus(Integer status);
    List<FaturamentoMensal> getFat(Integer ano);

}