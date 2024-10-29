package br.com.truedev.ecommerce.controller;

import br.com.truedev.ecommerce.model.Produto;
import br.com.truedev.ecommerce.model.Variante;
import br.com.truedev.ecommerce.service.variante.IVarianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VarianteController {

    private IVarianteService service;

    @PostMapping("/variantes")
    public ResponseEntity<Variante> create(@RequestBody Variante newVariante){
        try {

            Variante result = service.create(newVariante);

            if(result != null){
                return ResponseEntity.status(201).body(result);
            }

        }catch (Exception e){
            System.out.println("Não foi possível criar uma variação " + e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/variantes/{id}")
    public ResponseEntity<Variante> update(Variante variante, @PathVariable Integer id){
        variante.setId(id);
        try {

            Variante result = service.update(variante);

            if(result != null){
                return ResponseEntity.ok(result);
            }

        }catch (Exception e){
            System.out.println("Não foi possível atualizar a variação " + e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/variantes")
    public ResponseEntity<List<Variante>> searchListAll(){
        try {

            List<Variante> result = service.searchListAll();

            if(result != null){
                return ResponseEntity.ok(result);
            }

        }catch (Exception e){
            System.out.println("Não foi possível consultar a lista de variação " + e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/variantes/search")
    public ResponseEntity<List<Variante>> searchListAllByWord(@RequestParam(name = "produto") Integer produto){
        try {

            Produto p = new Produto();
            p.setId(produto);
            List<Variante> result = service.searchListByProduct(p);

            if(result != null){
                return ResponseEntity.ok(result);
            }

        }catch (Exception e){
            System.out.println("Não foi possível consultar variação " + e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/variantes/{id}")
    public ResponseEntity<Variante> searchById(@PathVariable Integer id){
        try {

            Variante result = service.searchByid(id);

            if(result != null){
                return ResponseEntity.ok(result);
            }

        }catch (Exception e){
            System.out.println("Não foi possível consultar viação " + e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }


}
