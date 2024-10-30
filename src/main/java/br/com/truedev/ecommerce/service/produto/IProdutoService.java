package br.com.truedev.ecommerce.service.produto;

import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.model.Produto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProdutoService {

    Produto create(Produto newProduto);
    Produto update(Produto produto);
    Page<Produto> listAll(int numPagina);
    List<Produto> listAllByWord(String word);
    Produto findById(Integer id);

    List<Produto> findByCategoriasContaining(Categoria categoria);
}
