package br.com.truedev.ecommerce.dao;

import br.com.truedev.ecommerce.model.cliente.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {

    public Cliente findByTelefone(String telefone);
}
