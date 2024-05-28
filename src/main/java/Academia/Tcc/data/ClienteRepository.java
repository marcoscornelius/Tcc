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

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {
    
    @Query("SELECT c FROM ClienteEntity c WHERE c.cpf = :cpfOrName OR c.nome = :cpfOrName")
    ClienteEntity findByCpfOrNome(@Param("cpfOrName") String cpfOrName);
}
