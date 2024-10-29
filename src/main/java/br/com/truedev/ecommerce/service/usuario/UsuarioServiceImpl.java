package br.com.truedev.ecommerce.service.usuario;

import br.com.truedev.ecommerce.dao.UsuarioDAO;
import br.com.truedev.ecommerce.model.Usuario;
import br.com.truedev.ecommerce.security.ECToken;
import br.com.truedev.ecommerce.security.ECTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public Usuario create(Usuario  user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String newPassword = encoder.encode(user.getSenha());

        user.setSenha(newPassword);
        return usuarioDAO.save(user);
    }

    public Usuario update(Usuario  user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String newPassword = encoder.encode(user.getSenha());

        user.setSenha(newPassword);
        return usuarioDAO.save(user);
    }

    @Override
    public ECToken doLogin(Usuario usuario){
        System.out.println("login: " + usuario.getLogin());
        System.out.println("senha: " + usuario.getSenha());
        System.out.println(" ");
        System.out.println("//////////");
        System.out.println(" ");

        Usuario user = usuarioDAO.findByLogin(usuario.getLogin());

        System.out.println("user: " + user.getLogin());
        System.out.println("senha: " + user.getSenha());

        if (user != null) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if(encoder.matches(usuario.getSenha(), user.getSenha()))
                return ECTokenUtil.generateToken(user);

        }


        return null;
    }

}
