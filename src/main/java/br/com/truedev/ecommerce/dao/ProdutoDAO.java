package br.com.truedev.ecommerce.dao;

import br.com.truedev.ecommerce.model.categoria.Categoria;
import br.com.truedev.ecommerce.model.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoDAO extends JpaRepository<Produto, Integer> {

    List<Produto> findByNomeContaining(String word);
    List<Produto> findByOrderByNomeAsc();
    List<Produto> findByCategoriasContaining(Categoria categoria);
}
