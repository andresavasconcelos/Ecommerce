package br.com.truedev.ecommerce.dao;

import br.com.truedev.ecommerce.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {

     Usuario findByLogin(String login);
}
