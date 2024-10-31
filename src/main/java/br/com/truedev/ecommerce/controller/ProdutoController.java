package br.com.truedev.ecommerce.controller;

import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.model.Produto;
import br.com.truedev.ecommerce.service.produto.IProdutoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private final IProdutoService service;

    private final Logger log = LogManager.getLogger();

    public ProdutoController(IProdutoService service) {
        this.service = service;
    }

    @PostMapping("/produtos")
    public ResponseEntity<Produto> create(@RequestBody Produto newProduct){
        try {
            log.info("Starting method create in products");
            Produto produto = service.create(newProduct);

            if(produto != null){
                log.info("Finished method create in order products");
                return ResponseEntity.status(201).body(produto);
            }

        }catch (Exception e){
            log.info("Não foi possível criar um produto " + e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produto> update(Produto product, @PathVariable Integer id){
        product.setId(id);
        try {
            log.info("Starting method update in products");
            log.info("Id: "+id);
            Produto produto = service.update(product);

            if(produto != null){
                log.info("Finished method update in products successes");
                return ResponseEntity.ok(produto);
            }

        }catch (Exception e){
            log.info("Não foi possível atualizar um produto " + e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/produtos")
    public ResponseEntity<Page<Produto>> listAll(@RequestParam(name = "p", defaultValue = "1") int p){
        try {
            log.info("Starting method listAll in products");
            Page<Produto> produtos = service.listAll(p);

            if(produtos != null){
                log.info("Finished method listAll in products successes");
                return ResponseEntity.ok(produtos);
            }

        }catch (Exception e){
            log.info("Não foi possível consultar produtos " + e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/produtos/busca")
    public ResponseEntity<List<Produto>> listAllByWord(@RequestParam(name = "palavra") String word){
        try {
            log.info("Starting method listAllByWord in products");
            List<Produto> produtos = service.listAllByWord(word);

            if(produtos != null){
                log.info("Finished method listAllByWord in products successes");
                return ResponseEntity.ok(produtos);
            }

        }catch (Exception e){
            log.info("Não foi possível consultar produtos " + e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> getProductById(@PathVariable Integer id){
        try {
            log.info("Starting method getProductById in products");
            Produto produto = service.findById(id);

            if(produto != null){
                log.info("Finished method getProductById in products successes");
                return ResponseEntity.ok(produto);
            }

        }catch (Exception e){
            log.info("Não foi possível consultar produtos " + e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/produtos/categoria/{id}")
    public ResponseEntity<List<Produto>> getProductCategoriaById(@PathVariable Integer id){
        try {
            log.info("Starting method getProductCategoriaById in products");
            log.info("Id: "+id);

            Categoria categoria = new Categoria();
            categoria.setId(id);
            List<Produto> catProduto = service.findByCategoriasContaining(categoria);

            if(catProduto != null){
                log.info("Finished method getProductCategoriaById in products successes");
                return ResponseEntity.ok(catProduto);
            }

        }catch (Exception e){
            log.info("Não foi possível consultar categoria do produto " + e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }
}
