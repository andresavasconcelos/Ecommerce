package br.com.truedev.ecommerce.dao;

import br.com.truedev.ecommerce.model.Pedido;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PedidoDAO extends CrudRepository <Pedido, Integer>{

    List<Pedido> findAllByStatus(Integer status);
}
