/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Academia.Tcc.controller;

import Academia.Tcc.controller.model.Cliente;
import Academia.Tcc.data.ClienteEntity;
import Academia.Tcc.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author User
 */
@Controller 
public class MiscController {
      @Autowired 
     ClienteService clienteService;    
    
    
  @PostMapping("/pesquisarCliente")
public String getClienteByCpfOrName(@RequestParam String cpfOrName, Model model) {
    ClienteEntity cliente = clienteService.getClienteCpfOrName(cpfOrName);
    if (cliente != null) {
        model.addAttribute("cliente", cliente);
        return "editarCliente"; // Nome do arquivo HTML na pasta templates (sem .html)
    } else {
        model.addAttribute("mensagem", "Cliente não encontrado");
        model.addAttribute("cliente", new ClienteEntity()); // Adiciona um cliente vazio ao modelo para evitar erros no Thymeleaf
        return "pesquisarCliente";
    }
}
    
    @GetMapping("/cadastrarCliente") 
    public String atualizarCliente(Model model) {
        // Adicionar um objeto Cliente vazio ao modelo
        model.addAttribute("cliente", new Cliente());
        return "cadastrarCliente"; // Nome da página HTML
    }
    
    @GetMapping("/pesquisarCliente") 
    public String pesquisarCliente(Model model) {
        return "pesquisarCliente"; // Nome da página HTML
    }
}


