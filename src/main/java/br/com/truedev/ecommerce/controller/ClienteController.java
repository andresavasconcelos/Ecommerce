package br.com.truedev.ecommerce.controller;

import br.com.truedev.ecommerce.model.Cliente;
import br.com.truedev.ecommerce.service.cliente.IClienteService;
import ch.qos.logback.core.net.server.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Executable;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private final IClienteService clienteService;

    protected static final Logger log = LogManager.getLogger();

    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> listAll(){
        try{
            log.info("Starting method listAll in clients");
            List<Cliente> resp = clienteService.recuperarTodosClintes();

            if(resp != null) {
                log.info("Finished method create in category sucucess");
                return ResponseEntity.ok(clienteService.recuperarTodosClintes());
            }
        }catch (Exception e){
            log.info("LOG - Não foi possivél consultas lista de clientes " + e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Integer id){
        try{
            log.info("Starting method getById in clients");

            Cliente result = clienteService.recuperarClientePeloId(id);

            if(result != null){
                log.info("Finished method getById in clientes successes");
                return ResponseEntity.ok(result);
            }

        } catch (Exception e) {
            log.info("LOG - Não foi possivél consultar cliente " + e.getMessage());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        try {
            log.info("Starting method create in clients");

            Cliente result = clienteService.cadastrarNovoCliente(cliente);

            if(result != null){
                log.info("Finished method create in clientes successes");
                return ResponseEntity.status(201).body(result);
            }

        }catch (Exception e){
            log.info("LOG - Não foi possivél criar cliente " + e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente, @PathVariable Integer id){
        try {

            log.info("Starting method update in clients");
            cliente.setId(id);

            Cliente result = clienteService.alterarCliete(cliente);

            if(result != null){
                log.info("Finished method update in clientes successes");
                return ResponseEntity.ok(result);
            }

        }catch (Exception e){
            log.info("LOG - Não foi possivél atualizar cliente " + e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/clientes/busca")
    public ResponseEntity<Cliente> searchByPhone(@RequestParam(name = "telefone") String telefone){
        try {
            log.info("Starting method searchByPhone in clients");

            Cliente result = clienteService.recuperarClientePeloTelefone(telefone);

            if (result != null) {
                log.info("Finished method searchByPhone in clientes successes");
                return ResponseEntity.ok(result);
            }
        }catch (Exception e){
            log.info("LOG - Não foi possivél consultar cliente por telefone " + e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }



}
