package br.com.truedev.ecommerce.service.cliente;

import br.com.truedev.ecommerce.dao.CategoriaDAO;
import br.com.truedev.ecommerce.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


public interface ICategoriaService {

    Categoria create(Categoria novaCategoria);
    Categoria update(Categoria categoria);
    List<Categoria> listAll();
    void remove(Integer id);

}
