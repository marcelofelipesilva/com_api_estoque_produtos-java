package com.api.estoque.produtos.Service;

import com.api.estoque.produtos.Repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.api.estoque.produtos.Models.*;

public class ProdutoService 
{

	private IProdutoRepository produto;

	public ProdutoService(IProdutoRepository produto) {
		this.produto = produto;
	}

	public List<Produto> findAll() {
		return produto.findAll();
	}

	public <S extends Produto> S saveAndFlush(S entity) {

		return produto.saveAndFlush(entity);
	}

	public Produto getById(Long id) {
		return produto.getById(id);
	}
	
	public Produto save(Produto entity) {
		produto.save(entity);
		Long id = entity.getID();
		return produto.getById(id);
		
	}

	public void deleteById(Long id) {
		produto.deleteById(id);
	}
	
}
