package br.com.truedev.ecommerce.dao;

import br.com.truedev.ecommerce.dto.FaturamentoMensal;
import br.com.truedev.ecommerce.model.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoDAO extends CrudRepository <Pedido, Integer>{

    List<Pedido> findAllByStatus(Integer status);

    /* criando uma query customizada para recuperar faturamento */
    @Query("SELECT new "
            + " br.com.truedev.ecommerce.dto.FaturamentoMensal(month(p.datePedido), sum(p.valorTotal)) "
            + " FROM Pedido p "
            + " WHERE year(p.datePedido) = :ano "
            + " GROUP BY month(p.datePedido) ")
    public List<FaturamentoMensal> getFat(@Param("ano") Integer ano);
}
