package Academia.Tcc.controller;

import Academia.Tcc.data.ClienteEntity;
import Academia.Tcc.service.ClienteService;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController 

@RequestMapping("/cliente") 

public class ClienteController {
    
    @Autowired 

    ClienteService clienteService; 

    @PostMapping("/cadastrarCliente") 

    public ResponseEntity<ClienteEntity> addFilme(@RequestBody ClienteEntity cli) { 

        var novoCliente = clienteService.criarCliente(cli); 

        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED); 

    }     
   
    @DeleteMapping("/deletar")
   public ResponseEntity deletarCliente(@RequestParam String cpf) {   
       clienteService.deletarCliente(cpf);    
       return new ResponseEntity<>(HttpStatus.OK);
   }   
  

   

   
    @PostMapping("/atualizarCliente")
    @ResponseBody
    public ResponseEntity<?> atualizarCliente(@RequestBody ClienteEntity cliente) {
        clienteService.atualizarCliente(cliente);
        return new ResponseEntity<>(Collections.singletonMap("success", true), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ClienteEntity> getClienteById(@PathVariable Integer id) {
        ClienteEntity cliente = clienteService.getClienteById(id);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
