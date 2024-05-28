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
import lombok.Data;

/**
 *
 * @author User
 */
@Data 
@Entity 
@Table(name="cliente") 
public class ClienteEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    
    public Integer  id;
    public String nome;
    public String endereco;
    public String telefone;
    public String cpf;
    public Integer duracao;
    public String horario_entrada;
    public String data_pagamento;
    
   
}
