package com.api.estoque.produtos.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.estoque.produtos.Models.Fornecedor;
import com.api.estoque.produtos.Repository.IFornecedorRepository;

public class FornecedorService {

	
	

	private IFornecedorRepository fornecedor;

	public FornecedorService(IFornecedorRepository fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> findAll() {
		return fornecedor.findAll();
	}

	public <S extends Fornecedor> S saveAndFlush(S entity) {

		return fornecedor.saveAndFlush(entity);
	}

	public Fornecedor getById(Long id) {
		return fornecedor.getById(id);
	}
	
	public Fornecedor save(Fornecedor entity) {
		fornecedor.save(entity);
		Long id = entity.getID();
		return fornecedor.getById(id);
		
	}

	public void deleteById(Long id) {
		fornecedor.deleteById(id);
	}
}
