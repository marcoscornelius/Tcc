/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Academia.Tcc.controller;

import Academia.Tcc.controller.model.Cliente;
import Academia.Tcc.controller.model.Funcionario;
import Academia.Tcc.data.ClienteEntity;
import Academia.Tcc.data.FuncionarioEntity;
import Academia.Tcc.service.ClienteService;
import Academia.Tcc.service.FuncionarioService;
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
      @Autowired
    FuncionarioService funcionarioService;    
    
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

  @GetMapping("/listarClientes") 
    public String todosClientes(Model model) { 

        var clientes = clienteService.listarTodosClientes(); 
        model.addAttribute("cliente", clientes);
        return "listarClientes"; 

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
    
    @GetMapping("/paginaInicial") 
    public String paginaInicial(Model model) {
        return "paginaInicial"; // Nome da página HTML
    }
   
    
    @PostMapping("/pesquisarFuncionario")
    public String getFuncionarioByCpfOrName(@RequestParam String cpfOrName, Model model) {
    FuncionarioEntity funcionario = funcionarioService.getFuncionarioCpfOrName(cpfOrName);
    if (funcionario != null) {
        model.addAttribute("funcionario", funcionario);
        return "editarFuncionario"; // Nome do arquivo HTML na pasta templates (sem .html)
    } else {
        model.addAttribute("mensagem", "Funcionario não encontrado");
        model.addAttribute("cliente", new FuncionarioEntity()); // Adiciona um cliente vazio ao modelo para evitar erros no Thymeleaf
        return "pesquisarFuncionario";
    }
}

  @GetMapping("/listarFuncionarios") 
    public String todosFuncionario(Model model) { 

        var funcionarios = funcionarioService.listarTodosFuncionarios(); 
        model.addAttribute("funcionario", funcionarios);
        return "listarFuncionarios"; 

    } 
    
    @GetMapping("/cadastrarFuncionario") 
    public String atualizarFuncionario(Model model) {
        // Adicionar um objeto Cliente vazio ao modelo
        model.addAttribute("funcionario", new Funcionario());
        return "cadastrarFuncionario"; // Nome da página HTML
    }
    
    @GetMapping("/pesquisarFuncionario") 
    public String pesquisarFuncionario(Model model) {
        return "pesquisarFuncionario"; // Nome da página HTML
    }
}


