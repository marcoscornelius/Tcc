/*
 * funck nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * funck nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Academia.Tcc.controller;

import Academia.Tcc.data.FuncionarioEntity;
import Academia.Tcc.service.FuncionarioService;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController 

@RequestMapping("/funcionario") 
public class FuncionarioController {
     @Autowired 

    FuncionarioService funcionarioService; 
    
    @PostMapping("/cadastrarFuncionario") 
    public ResponseEntity<FuncionarioEntity> addFuncionario(@RequestBody FuncionarioEntity fun) { 

        var novoFuncionario = funcionarioService.criarFuncionario(fun); 

        return new ResponseEntity<>(novoFuncionario, HttpStatus.CREATED); 

    }     
   
    @DeleteMapping("/deletar")
   public ResponseEntity deletarFuncionario(@RequestParam String cpf) {   
       funcionarioService.deletarFuncionario(cpf);    
       return new ResponseEntity<>(HttpStatus.OK);
   }   
  
   
    @PostMapping("/atualizarFuncionario")
    @ResponseBody
    public ResponseEntity<?> atualizarFuncionario(@RequestBody FuncionarioEntity funcionario) {
        funcionarioService.atualizarFuncionario(funcionario);
        return new ResponseEntity<>(Collections.singletonMap("success", true), HttpStatus.OK);
    }

    
}
