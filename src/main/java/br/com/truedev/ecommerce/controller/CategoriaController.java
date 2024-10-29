package br.com.truedev.ecommerce.controller;

import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.service.categoria.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    private ICategoriaService service;

    @PostMapping("/categorias")
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){
        try{

            Categoria result = service.create(categoria);

            if(result != null){
                return ResponseEntity.status(201).body(result);
            }

        }
        catch (Exception e){
            System.out.println("LOG - Não foi possivél cria categoria" + e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<Categoria> update(@RequestBody Categoria categoria, @PathVariable Integer id){
        categoria.setId(id);
        try{

            Categoria result = service.update(categoria);

            if(result != null){
                return ResponseEntity.ok(result);
            }

        }
        catch (Exception e){
            System.out.println("LOG - Não foi possivél atualizar categoria");
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> listAll(){
        try{

            List<Categoria> result = service.listAll();

            if(result != null){
                return ResponseEntity.ok(result);
            }

        }
        catch (Exception e){
            System.out.println("LOG - Não foi possivél consultas todas as categorias");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<?> remove(@PathVariable Integer id){
        try{

             service.remove(id);
        }
        catch (Exception e){
            System.out.println("LOG - Não foi possivél remover todas as categorias");
        }

        return ResponseEntity.ok("Removed!");
    }

}
