package br.com.truedev.ecommerce.service.categoria;

import br.com.truedev.ecommerce.model.Categoria;
import java.util.List;

public interface ICategoriaService {

    Categoria create(Categoria novaCategoria);
    Categoria update(Categoria categoria);
    List<Categoria> listAll();
    void remove(Integer id);

}
