package br.com.truedev.ecommerce.dao;

import br.com.truedev.ecommerce.model.categoria.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaDAO extends CrudRepository<Categoria, Integer> {

    public List<Categoria> findAllByOrderByNomeAsc();
}
