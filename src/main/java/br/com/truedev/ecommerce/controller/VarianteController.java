package br.com.truedev.ecommerce.controller;

import br.com.truedev.ecommerce.model.Produto;
import br.com.truedev.ecommerce.model.Variante;
import br.com.truedev.ecommerce.service.variante.IVarianteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VarianteController {

    private final IVarianteService service;

    protected static final Logger log = LogManager.getLogger();

    public VarianteController(IVarianteService service) {
        this.service = service;
    }

    @PostMapping("/variantes")
    public ResponseEntity<Variante> create(@RequestBody Variante newVariante){
        try {
            log.info("Starting method create in variant");
            Variante result = service.create(newVariante);

            if(result != null){
                log.info("Finished method create in variant successes");
                return ResponseEntity.status(201).body(result);
            }

        }catch (Exception e){
            log.info("Não foi possível criar uma variação " + e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/variantes/{id}")
    public ResponseEntity<Variante> update(Variante variante, @PathVariable Integer id){
        variante.setId(id);
        try {
            log.info("Starting method update in variant");
            Variante result = service.update(variante);

            if(result != null){
                log.info("Finished method update in variant successes");
                return ResponseEntity.ok(result);
            }

        }catch (Exception e){
            log.info("Não foi possível atualizar a variação " + e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/variantes")
    public ResponseEntity<List<Variante>> searchListAll(){
        try {
            log.info("Starting method searchListAll in variant");
            List<Variante> result = service.searchListAll();

            if(result != null){
                log.info("Finished method searchListAll in variant successes");
                return ResponseEntity.ok(result);
            }

        }catch (Exception e){
            log.info("Não foi possível consultar a lista de variação " + e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/variantes/search")
    public ResponseEntity<List<Variante>> searchListAllByWord(@RequestParam(name = "produto") Integer produto){
        try {
            log.info("Starting method searchListAllByWord in variant");
            Produto p = new Produto();
            p.setId(produto);
            List<Variante> result = service.searchListByProduct(p);

            if(result != null){
                log.info("Finished method searchListAllByWord in variant successes");
                return ResponseEntity.ok(result);
            }

        }catch (Exception e){
            log.info("Não foi possível consultar variação " + e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/variantes/{id}")
    public ResponseEntity<Variante> searchById(@PathVariable Integer id){
        try {
            log.info("Starting method searchById in variant");
            Variante result = service.searchByid(id);

            if(result != null){
                log.info("Finished method searchById in variant successes");
                return ResponseEntity.ok(result);
            }

        }catch (Exception e){
            log.info("Não foi possível consultar viação " + e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }


}
