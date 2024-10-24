package br.com.truedev.ecommerce.service.cliente;

import br.com.truedev.ecommerce.model.cliente.Cliente;

import java.util.List;

public interface IClienteService {

    Cliente cadastrarNovoCliente(Cliente novo);
    Cliente alterarCliete(Cliente cliente);
    Cliente recuperarClientePeloId(Integer id);
    Cliente recuperarClientePeloTelefone(String telefone);
    List<Cliente> recuperarTodosClintes();

}
