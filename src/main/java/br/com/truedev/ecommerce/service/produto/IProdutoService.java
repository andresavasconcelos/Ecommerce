package br.com.truedev.ecommerce.service.produto;

import br.com.truedev.ecommerce.model.categoria.Categoria;
import br.com.truedev.ecommerce.model.produto.Produto;

import java.util.List;

public interface IProdutoService {

    Produto create(Produto newProduto);
    Produto update(Produto produto);
    List<Produto> listAll();
    List<Produto> listAllByWord(String word);
    Produto findById(Integer id);

    List<Produto> findByCategoriasContaining(Categoria categoria);
}
