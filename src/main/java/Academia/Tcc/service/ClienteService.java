/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Academia.Tcc.service;

import Academia.Tcc.data.ClienteEntity;
import Academia.Tcc.data.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */

@Service 
public class ClienteService {
    @Autowired 

    ClienteRepository clienteRepository; 
    
    public void deletarCliente(String cpfOrName) { 

        ClienteEntity cli = getClienteCpfOrName(cpfOrName); 

        clienteRepository.deleteById(cli.getId()); 

    } 
    
    public List<ClienteEntity> listarTodosClientes() { 

        return clienteRepository.findAll(); 

    } 
    
    public ClienteEntity getClienteCpfOrNomeExcluindoId(String cpfOrName, Integer id) {
        return clienteRepository.findByCpfOrNomeExcludingId(cpfOrName, id);
    }
    
   public ClienteEntity getClienteCpfOrName(String cpfOrName) {
        return clienteRepository.findByCpfOrNome(cpfOrName);
    }
   
   public ClienteEntity getClienteById(Integer id) {
    return clienteRepository.findById(id).orElse(null);
}
    
    public ClienteEntity atualizarCliente(ClienteEntity clienteRequest) { 
        

        clienteRequest.setCpf(clienteRequest.getCpf()); 

        clienteRequest.setData_pagamento(clienteRequest.getData_pagamento()); 

        clienteRequest.setDuracao(clienteRequest.getDuracao()); 

        clienteRequest.setEndereco(clienteRequest.getEndereco()); 

        clienteRequest.setHorario_entrada(clienteRequest.getHorario_entrada()); 
        
        clienteRequest.setNome(clienteRequest.getNome()); 
           
        clienteRequest.setTelefone(clienteRequest.getTelefone()); 

        clienteRepository.save(clienteRequest); 

        return clienteRequest; 

    } 

    public ClienteEntity criarCliente(ClienteEntity cli) { 

        cli.setId(null); 

        clienteRepository.save(cli); 

        return cli; 

    } 
}
