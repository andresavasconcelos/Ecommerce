package br.com.truedev.ecommerce.service.pedido;

import br.com.truedev.ecommerce.dao.PedidoDAO;
import br.com.truedev.ecommerce.model.ItemPedido;
import br.com.truedev.ecommerce.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    private PedidoDAO dao;

    @Override
    public Pedido create(Pedido pedido) {
        Double total = 0.0, desconto = 0.0;
        for(ItemPedido i : pedido.getItens()){
            i.setPedido(pedido);
            total += i.getValorTotal();
        }

        pedido.setValorBruto(total);

        if(total >= 30.00){
            desconto = total * 0.10;
        }
        total = total - desconto;

        pedido.setDesconto(desconto);
        pedido.setValorTotal(total);


        return dao.save(pedido);
    }

    @Override
    public Pedido update(Pedido pedido) {
        return dao.save(pedido);
    }

    @Override
    public List<Pedido> listAllOder() {
        return (List<Pedido>) dao.findAll();
    }

    @Override
    public Pedido findById(Integer numOrder) {
        return dao.findById(numOrder).orElse(null);
    }

    @Override
    public List<Pedido> findByStatus(Integer status) {
        return dao.findAllByStatus(status);
    }
}
