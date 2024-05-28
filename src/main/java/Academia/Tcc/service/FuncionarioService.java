/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Academia.Tcc.service;

import Academia.Tcc.data.FuncionarioEntity;
import Academia.Tcc.data.FuncionarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author User
 */
public class FuncionarioService {
    @Autowired 

    FuncionarioRepository funcionarioRepository; 
    
    public void deletarFuncionario(Integer funcId) { 

        FuncionarioEntity func = getFuncionarioId(funcId); 

        funcionarioRepository.deleteById(func.getId()); 

    } 
    
    public List<FuncionarioEntity> listarTodosFuncionarios() { 

        return funcionarioRepository.findAll(); 

    } 
    
    public FuncionarioEntity getFuncionarioId(Integer funcId) { 

        return funcionarioRepository.findById(funcId).orElse(null); 

    } 
    
    public FuncionarioEntity atualizarFilme(Integer funcId, FuncionarioEntity funcionarioRequest) { 

        FuncionarioEntity func = getFuncionarioId(funcId); 

        func.setCpf(funcionarioRequest.getCpf()); 

        func.setDataPagamento(funcionarioRequest.getDataPagamento()); 

        func.setHorarioSaida(funcionarioRequest.getHorarioSaida()); 

        func.setEndereco(funcionarioRequest.getEndereco()); 

        func.setHorarioEntrada(funcionarioRequest.getHorarioEntrada()); 
        
        func.setNome(funcionarioRequest.getNome()); 
           
        func.setTelefone(funcionarioRequest.getTelefone()); 
        
        func.setFuncao(funcionarioRequest.getFuncao()); 

        funcionarioRepository.save(func); 

        return func; 

    } 

    public FuncionarioEntity criarFuncionario(FuncionarioEntity func) { 

        func.setId(null); 

        funcionarioRepository.save(func); 

        return func; 

    } 
}
