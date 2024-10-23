package br.com.truedev.ecommerce.controller;

import br.com.truedev.ecommerce.model.Produto;
import br.com.truedev.ecommerce.service.cliente.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private IProdutoService service;

    @PostMapping("/produtos")
    public ResponseEntity<Produto> create(@RequestBody Produto newProduct){
        try {

            Produto produto = service.create(newProduct);

            if(produto != null){
                return ResponseEntity.status(201).body(produto);
            }

        }catch (Exception e){
            System.out.println("Não foi possível criar um produto " + e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produto> create(Produto product, @PathVariable Integer id){
        product.setId(id);
        try {

            Produto produto = service.update(product);

            if(produto != null){
                return ResponseEntity.ok(produto);
            }

        }catch (Exception e){
            System.out.println("Não foi possível atualizar um produto " + e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> listAll(){
        try {

            List<Produto> produtos = service.listAll();

            if(produtos != null){
                return ResponseEntity.ok(produtos);
            }

        }catch (Exception e){
            System.out.println("Não foi possível consultar produtos " + e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/produtos/busca")
    public ResponseEntity<List<Produto>> listAllByWord(@RequestParam(name = "palavra") String word){
        try {

            List<Produto> produtos = service.listAll();

            if(produtos != null){
                return ResponseEntity.ok(produtos);
            }

        }catch (Exception e){
            System.out.println("Não foi possível consultar produtos " + e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }



    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> getProductById(@PathVariable Integer id){
        try {

            Produto produto = service.findById(id);

            if(produto != null){
                return ResponseEntity.ok(produto);
            }

        }catch (Exception e){
            System.out.println("Não foi possível consultar produtos " + e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }
}
