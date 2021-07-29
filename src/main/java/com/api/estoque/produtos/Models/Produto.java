package com.api.estoque.produtos.Models;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;
	
	private String Nome;
	private float Preco;
	private int  Quantidade;
	private String Descricao;
	

}
