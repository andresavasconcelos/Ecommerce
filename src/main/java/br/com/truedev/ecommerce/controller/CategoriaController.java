package br.com.truedev.ecommerce.controller;

import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.service.categoria.ICategoriaService;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.apache.logging.log4j.Logger;

@RestController
public class CategoriaController {

    @Autowired
    private final ICategoriaService service;

    protected static final Logger log = LogManager.getLogger();

    public CategoriaController(ICategoriaService service) {
        this.service = service;
    }

    @PostMapping("/categorias")
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){
        try{
            log.info("Starting method create in category");

            Categoria result = service.create(categoria);

            if(result != null){
                log.info("Finished method create in category successes");
                return ResponseEntity.status(201).body(result);
            }

        }
        catch (Exception e){
            //TODO: melhorar as exception
            log.info("LOG - Não foi possivél cria categoria" + e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<Categoria> update(@RequestBody Categoria categoria, @PathVariable Integer id){
        categoria.setId(id);
        try{
            log.info("Starting method update in category");

            Categoria result = service.update(categoria);

            if(result != null){
                log.info("Finished method update in category successes");
                return ResponseEntity.ok(result);
            }
        }
        catch (Exception e){

            log.info("LOG - Não foi possivél atualizar categoria");
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> listAll(){
        try{
            log.info("Starting method listAll in category");

            List<Categoria> result = service.listAll();

            if(result != null){
                log.info("Finished method listAll in category successes");
                return ResponseEntity.ok(result);
            }
        }
        catch (Exception e){
            log.info("LOG - Não foi possivél consultas todas as categorias");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<?> remove(@PathVariable Integer id){
        try{
            log.info("Starting method remove in category");

             service.remove(id);

            log.info("Finished method remove in category successes");
        }
        catch (Exception e){
            log.info("LOG - Não foi possivél remover todas as categorias");
        }

        return ResponseEntity.ok("Removed!");
    }

}
