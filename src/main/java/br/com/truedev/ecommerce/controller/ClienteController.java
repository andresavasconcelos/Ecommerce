package br.com.truedev.ecommerce.controller;

import br.com.truedev.ecommerce.model.Cliente;
import br.com.truedev.ecommerce.service.cliente.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAll(){
        return ResponseEntity.ok(clienteService.recuperarTodosClintes());
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Integer id){
        Cliente result = clienteService.recuperarClientePeloId(id);
        if(result != null){
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        try {
            Cliente result = clienteService.cadastrarNovoCliente(cliente);

            if(result != null){
                return ResponseEntity.status(201).body(result);
            }

        }catch (Exception e){
            System.out.println("LOG - Erro ao cadastrar - " + e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente, @PathVariable Integer id){
        cliente.setId(id);
        try {
            Cliente result = clienteService.alterarCliete(cliente);

            if(result != null){
                return ResponseEntity.ok(result);
            }

        }catch (Exception e){
            System.out.println("LOG - Erro ao atualizar - " + e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/clientes/busca")
    public ResponseEntity<Cliente> searchByPhone(@RequestParam(name = "telefone") String telefone){
        try {
            Cliente result = clienteService.recuperarClientePeloTelefone(telefone);

            if (result != null) {
                return ResponseEntity.ok(result);
            }
        }catch (Exception e){
            System.out.println("LOG - Erro ao atualizar - " + e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }



}
