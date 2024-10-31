package br.com.truedev.ecommerce.controller;

import br.com.truedev.ecommerce.dto.FaturamentoMensal;
import br.com.truedev.ecommerce.model.Pedido;
import br.com.truedev.ecommerce.service.pedido.IPedidoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedidoController {

    @Autowired
    private final IPedidoService service;

    protected static final Logger log = LogManager.getLogger();

    public PedidoController(IPedidoService service) {
        this.service = service;
    }

    @PostMapping("/pedidos")
    public ResponseEntity<Pedido> create(@RequestBody Pedido pedido){
        try{
            log.info("Starting method create in order");

            Pedido result = service.create(pedido);

            if(result != null){
                log.info("Finished method create in order successes");
                return ResponseEntity.status(201).body(result);
            }

        }
        catch (Exception e){
            log.info("LOG - Não foi possivél cria pedido" + e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> update(@RequestBody Pedido pedido, @PathVariable Integer numPedido){
        try{
            log.info("Starting method update in order");
            log.info("numPedido: "+numPedido);

            pedido.setNumPedido(numPedido);

            Pedido result = service.update(pedido);

            if(result != null){
                log.info("Finished method update in order successes");
                return ResponseEntity.ok(result);
            }

        }
        catch (Exception e){
            log.info("LOG - Não foi possivél atualizar pedido");
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<Pedido>> listAllOder(){
        try{
            log.info("Starting method listAllOder in order");
            List<Pedido> result = service.listAllOder();

            if(result != null){
                log.info("Finished method listAllOder in order successes");
                return ResponseEntity.ok(result);
            }

        }
        catch (Exception e){
            log.info("LOG - Não foi possivél consultas todos os pedidos");
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Integer numPedido){
        try{
            log.info("Starting method findById in order");
            log.info("numPedido: "+numPedido);
            Pedido result = service.findById(numPedido);

            if(result != null){
                log.info("Finished method findById in order successes");
                return ResponseEntity.ok(result);
            }

        }
        catch (Exception e){
            log.info("LOG - Não foi possivél pesquisar pedido");
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/pedidos/{status}")
    public ResponseEntity<List<Pedido>> findByStatus(@PathVariable Integer status){
        try{
            log.info("Starting method findByStatus in order");
            log.info("Status: "+status);
            List<Pedido> result = service.findByStatus(status);

            if(result != null){
                log.info("Finished method findByStatus in order successes");
                return ResponseEntity.ok(result);
            }

        }
        catch (Exception e){
            System.out.println("LOG - Não foi possivél pesquisar pedido pelo status");
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/pedidos/faturamento/{ano}")
    public ResponseEntity<List<FaturamentoMensal>> getInvoicing(@PathVariable Integer ano){
        try{
            log.info("Starting method getInvoicing in order");
            log.info("Ano: "+ano);
            List<FaturamentoMensal> result = service.getFat(ano);

            if(result != null){
                log.info("Finished method getInvoicing in order successes");
                return ResponseEntity.ok(result);
            }

        }
        catch (Exception e){
            log.info("LOG - Não foi possivél recuperara faturamento");
        }

        return ResponseEntity.badRequest().build();
    }

}
