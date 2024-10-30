package br.com.truedev.ecommerce.service.usuario;

import br.com.truedev.ecommerce.model.Usuario;
import br.com.truedev.ecommerce.security.ECToken;

public interface IUsuarioService {

    Usuario create(Usuario user);
    Usuario update(Usuario user);
    ECToken doLogin(Usuario usuario);
}
