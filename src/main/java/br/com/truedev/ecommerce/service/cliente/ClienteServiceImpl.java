package br.com.truedev.ecommerce.service.cliente;

import br.com.truedev.ecommerce.dao.ClienteDAO;
import br.com.truedev.ecommerce.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteDAO clienteDAO;

    @Override
    public Cliente cadastrarNovoCliente(Cliente novo) {
        return clienteDAO.save(novo);
    }

    @Override
    public Cliente alterarCliete(Cliente cliente) {
        return clienteDAO.save(cliente);
    }

    @Override
    public Cliente recuperarClientePeloId(Integer id) {
        return clienteDAO.findById(id).orElse(null);
    }

    @Override
    public Cliente recuperarClientePeloTelefone(String telefone) {
        return clienteDAO.findByTelefone(telefone);
    }

    @Override
    public List<Cliente> recuperarTodosClintes() {
        return (List<Cliente>) clienteDAO.findAll();
    }
}
