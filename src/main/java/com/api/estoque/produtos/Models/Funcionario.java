package com.api.estoque.produtos.Models;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;
	
	private String Nome;
	private String Login;
	private String Senha;
	private int Matricula;

}
