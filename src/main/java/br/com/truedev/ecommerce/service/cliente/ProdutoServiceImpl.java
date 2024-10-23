package br.com.truedev.ecommerce.service.cliente;

import br.com.truedev.ecommerce.dao.ProdutoDAO;
import br.com.truedev.ecommerce.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImpl implements IProdutoService{

    @Autowired
    private ProdutoDAO produtoDAO;

    @Override
    public Produto create(Produto newProduto) {
        return produtoDAO.save(newProduto);
    }

    @Override
    public Produto update(Produto produto) {
        return produtoDAO.save(produto);
    }

    @Override
    public List<Produto> listAll() {
        return produtoDAO.findByOrderByNomeAsc();
    }

    @Override
    public List<Produto> listAllByWord(String word) {
        return produtoDAO.findByNomeContaining(word);
    }

    @Override
    public Produto findById(Integer id) {
        return produtoDAO.findById(id).orElse(null);
    }
}
