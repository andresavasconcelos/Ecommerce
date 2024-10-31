package br.com.truedev.ecommerce.controller;

import br.com.truedev.ecommerce.model.Usuario;
import br.com.truedev.ecommerce.security.ECToken;
import br.com.truedev.ecommerce.service.usuario.IUsuarioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private final IUsuarioService service;

    private static final Logger log = LogManager.getLogger();

    public UsuarioController(IUsuarioService service) {
        this.service = service;
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> create(@RequestBody Usuario user){
        try{
            log.info("Starting method create in users");
            Usuario usuario = service.create(user);

            if(usuario != null) {
                log.info("Finished method create in users successes");
                return ResponseEntity.status(201).body(usuario);
            }

        } catch (Exception e){
            log.info("Não foi possível criar usuario " + e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> update(@RequestBody Usuario user, @RequestParam Integer id){
        try{
            log.info("Starting method update in users");
            log.info("Id "+id);

            user.setId(id);
            Usuario usuario = service.update(user);

            if(usuario != null) {
                log.info("Finished method update in users successes");
                return ResponseEntity.ok(usuario);
            }

        } catch (Exception e){
            log.info("Não foi possível atualizar usuario " + e.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/login")
    public ResponseEntity<ECToken> doLogin(@RequestBody Usuario usuario){
        try{
            log.info("Starting method doLogin in users");
            ECToken token = service.doLogin(usuario);

            System.out.println("token: " + token);

            if(token != null){
                log.info("Finished method doLogin in users successes");
                return ResponseEntity.ok(token);
            }

        } catch (Exception e){
            log.info("Não foi possível realizar o login do usuario " + e.getMessage());
        }

        return ResponseEntity.status(403).build();
    }
}
