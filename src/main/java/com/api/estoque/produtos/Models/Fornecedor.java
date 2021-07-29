package com.api.estoque.produtos.Models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fornecedor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String nome;
	

}
