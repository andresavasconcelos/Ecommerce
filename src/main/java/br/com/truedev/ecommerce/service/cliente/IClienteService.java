package br.com.truedev.ecommerce.service.cliente;

import br.com.truedev.ecommerce.model.Cliente;

import java.util.List;

public interface IClienteService {

    public Cliente cadastrarNovoCliente(Cliente novo);
    public Cliente alterarCliete(Cliente cliente);
    public Cliente recuperarClientePeloId(Integer id);
    public Cliente recuperarClientePeloTelefone(String telefone);
    public List<Cliente> recuperarTodosClintes();

}
