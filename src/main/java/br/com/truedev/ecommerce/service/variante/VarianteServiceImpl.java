package br.com.truedev.ecommerce.service.variante;

import br.com.truedev.ecommerce.dao.VarianteDAO;
import br.com.truedev.ecommerce.model.produto.Produto;
import br.com.truedev.ecommerce.model.variante.Variante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VarianteServiceImpl implements IVarianteService {
    @Autowired
    private VarianteDAO varianteDAO;

    @Override
    public Variante create(Variante newVariante) {
        return varianteDAO.save(newVariante);
    }

    @Override
    public Variante update(Variante variante) {
        return varianteDAO.save(variante);
    }

    @Override
    public Variante searchByid(Integer id) {
        return varianteDAO.findById(id).orElse(null);
    }

    @Override
    public List<Variante> searchListByProduct(Produto produto) {
        return varianteDAO.findByProduto(produto);
    }

    @Override
    public List<Variante> searchListAll() {
        return (List<Variante>) varianteDAO.findAll();
    }
}
