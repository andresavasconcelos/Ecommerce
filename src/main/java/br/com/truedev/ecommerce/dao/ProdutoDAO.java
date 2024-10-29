package br.com.truedev.ecommerce.dao;

import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoDAO extends JpaRepository<Produto, Integer> {

    List<Produto> findByNomeContaining(String word);
    Page<Produto> findByOrderByNomeAsc(Pageable pageable);
    List<Produto> findByCategoriasContaining(Categoria categoria);
}
