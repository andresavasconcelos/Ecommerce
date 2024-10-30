package br.com.truedev.ecommerce.controller;

import br.com.truedev.ecommerce.model.Usuario;
import br.com.truedev.ecommerce.security.ECToken;
import br.com.truedev.ecommerce.service.usuario.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioService service;

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> create(@RequestBody Usuario user){
        try{

            Usuario usuario = service.create(user);

            if(usuario != null)
                return ResponseEntity.status(201).body(usuario);

        } catch (Exception e){
            System.out.println("Não foi possível criar usuario " + e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> update(@RequestBody Usuario user, @RequestParam Integer id){
        try{
            user.setId(id);
            Usuario usuario = service.update(user);

            if(usuario != null)
                return ResponseEntity.ok(usuario);

        } catch (Exception e){
            System.out.println("Não foi possível atualizar usuario " + e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/login")
    public ResponseEntity<ECToken> doLogin(@RequestBody Usuario usuario){
        try{

            ECToken token = service.doLogin(usuario);

            System.out.println("token: " + token);

            if(token != null)
                return ResponseEntity.ok(token);

        } catch (Exception e){
            System.out.println("Não foi possível consultar usuario " + e.getMessage());
        }

        return ResponseEntity.status(403).build();
    }
}