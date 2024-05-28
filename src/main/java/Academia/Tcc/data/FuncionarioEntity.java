/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Academia.Tcc.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author User
 */
@Data 
@Entity 
@Table(name="funcionario") 

public class FuncionarioEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    
    public Integer id;
    public String nome;
    public String endereco;
    public String telefone;
    public String cpf;
    public Time horarioEntrada;
    public Time horarioSaida;
    public Date dataPagamento;
    public String funcao;
    

}
