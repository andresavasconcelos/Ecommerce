package br.com.truedev.ecommerce.controller;

import br.com.truedev.ecommerce.model.Pedido;
import br.com.truedev.ecommerce.service.pedido.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedidoController {

    @Autowired
    private IPedidoService service;

    @PostMapping("/pedidos")
    public ResponseEntity<Pedido> create(@RequestBody Pedido pedido){
        try{

            Pedido result = service.create(pedido);

            if(result != null){
                return ResponseEntity.status(201).body(result);
            }

        }
        catch (Exception e){
            System.out.println("LOG - Não foi possivél cria pedido" + e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> update(@RequestBody Pedido pedido, @PathVariable Integer numPedido){
        pedido.setNumPedido(numPedido);
        try{

            Pedido result = service.update(pedido);

            if(result != null){
                return ResponseEntity.ok(result);
            }

        }
        catch (Exception e){
            System.out.println("LOG - Não foi possivél atualizar pedido");
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<Pedido>> listAllOder(){
        try{

            List<Pedido> result = service.listAllOder();

            if(result != null){
                return ResponseEntity.ok(result);
            }

        }
        catch (Exception e){
            System.out.println("LOG - Não foi possivél consultas todos os pedidos");
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Integer numPedido){
        try{

            Pedido result = service.findById(numPedido);

            if(result != null){
                return ResponseEntity.ok(result);
            }

        }
        catch (Exception e){
            System.out.println("LOG - Não foi possivél pesquisar pedido");
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/pedidos/{status}")
    public ResponseEntity<List<Pedido>> findByStatus(@PathVariable Integer status){
        try{

            List<Pedido> result = service.findByStatus(status);

            if(result != null){
                return ResponseEntity.ok(result);
            }

        }
        catch (Exception e){
            System.out.println("LOG - Não foi possivél pesquisar pedido pelo status");
        }

        return ResponseEntity.badRequest().build();
    }

}
