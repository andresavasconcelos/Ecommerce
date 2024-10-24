package br.com.truedev.ecommerce.dao;

import br.com.truedev.ecommerce.model.produto.Produto;
import br.com.truedev.ecommerce.model.variante.Variante;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VarianteDAO extends CrudRepository<Variante, Integer> {
    List<Variante> findByProduto(Produto produto);
}
