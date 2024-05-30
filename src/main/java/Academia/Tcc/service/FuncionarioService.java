
package Academia.Tcc.service;

import Academia.Tcc.data.FuncionarioEntity;
import Academia.Tcc.data.FuncionarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class FuncionarioService {
    @Autowired 

    FuncionarioRepository funcionarioRepository; 
    
    public void deletarFuncionario(String cpfOrName) { 

        FuncionarioEntity func = getFuncionarioCpfOrName(cpfOrName); 
        
        funcionarioRepository.deleteById(func.getId()); 

    } 
    
    public List<FuncionarioEntity> listarTodosFuncionarios() { 

        return funcionarioRepository.findAll(); 

    } 
    
    public FuncionarioEntity getFuncionarioId(Integer funcId) { 

        return funcionarioRepository.findById(funcId).orElse(null); 

    } 
    
    public FuncionarioEntity atualizarFuncionario(FuncionarioEntity funcionarioRequest) { 

     

        funcionarioRepository.save(funcionarioRequest); 

        return funcionarioRequest; 

    } 
    
    public FuncionarioEntity getFuncionarioCpfOrName(String cpfOrName) {
        return funcionarioRepository.findByCpfOrNome(cpfOrName);
    }

    public FuncionarioEntity criarFuncionario(FuncionarioEntity func) { 

        func.setId(null); 

        funcionarioRepository.save(func); 

        return func; 

    } 
}
