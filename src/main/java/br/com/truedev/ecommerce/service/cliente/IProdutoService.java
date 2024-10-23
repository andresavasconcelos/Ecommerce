package br.com.truedev.ecommerce.service.cliente;

import br.com.truedev.ecommerce.model.Produto;

import java.util.List;

public interface IProdutoService {

    Produto create(Produto newProduto);
    Produto update(Produto produto);
    List<Produto> listAll();
    List<Produto> listAllByWord(String word);
    Produto findById(Integer id);
}
