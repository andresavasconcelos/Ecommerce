package br.com.truedev.ecommerce.service.categoria;

import br.com.truedev.ecommerce.dao.CategoriaDAO;
import br.com.truedev.ecommerce.model.categoria.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CategoriaServiceImpl  implements ICategoriaService {
    @Autowired
    private CategoriaDAO catDao;

    @Override
    public Categoria create(Categoria novaCategoria) {
        return catDao.save(novaCategoria);
    }

    @Override
    public Categoria update(Categoria categoria) {
        return catDao.save(categoria);
    }

    @Override
    public List<Categoria> listAll() {
        return catDao.findAllByOrderByNomeAsc();
    }

    @Override
    public void remove(Integer id) {
        catDao.deleteById(id);
    }
}
