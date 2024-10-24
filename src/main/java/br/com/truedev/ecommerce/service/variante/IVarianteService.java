package br.com.truedev.ecommerce.service.variante;

import br.com.truedev.ecommerce.model.produto.Produto;
import br.com.truedev.ecommerce.model.variante.Variante;

import java.util.List;

public interface IVarianteService {

    Variante create(Variante newVariante);
    Variante update(Variante variante);
    Variante searchByid(Integer id);
    List<Variante> searchListByProduct(Produto produto);
    List<Variante> searchListAll();


}
