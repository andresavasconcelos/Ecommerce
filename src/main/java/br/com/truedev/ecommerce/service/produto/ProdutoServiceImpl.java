package br.com.truedev.ecommerce.service.produto;

import br.com.truedev.ecommerce.dao.ProdutoDAO;
import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImpl implements IProdutoService{

    @Autowired
    private ProdutoDAO produtoDAO;

    private static final int PAGE_SIZE = 5;

    @Override
    public Produto create(Produto newProduto) {
        return produtoDAO.save(newProduto);
    }

    @Override
    public Produto update(Produto produto) {
        return produtoDAO.save(produto);
    }

    @Override
    public Page<Produto> listAll(int numPagina) {
        Pageable pageable = PageRequest.of(numPagina-1, PAGE_SIZE);
        return produtoDAO.findByOrderByNomeAsc(pageable);
    }

    @Override
    public List<Produto> listAllByWord(String word) {
        return produtoDAO.findByNomeContaining(word);
    }

    @Override
    public Produto findById(Integer id) {
        return produtoDAO.findById(id).orElse(null);
    }

    @Override
    public List<Produto> findByCategoriasContaining(Categoria categoria) {
        return produtoDAO.findByCategoriasContaining(categoria);
    }
}
