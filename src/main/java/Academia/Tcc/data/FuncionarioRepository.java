/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Academia.Tcc.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Integer> {
    @Query("SELECT f FROM FuncionarioEntity f WHERE f.cpf = :cpfOrName OR f.nome = :cpfOrName")
    FuncionarioEntity findByCpfOrNome(@Param("cpfOrName") String cpfOrName);
    
      @Query("SELECT f FROM FuncionarioEntity f WHERE (f.cpf = :cpfOrName OR f.nome = :cpfOrName) AND f.id != :id")
    FuncionarioEntity findByCpfOrNomeExcludingId(@Param("cpfOrName") String cpfOrName, @Param("id") Integer id);
}
