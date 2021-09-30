package com.api.estoque.produtos.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.estoque.produtos.Models.Funcionario;
import com.api.estoque.produtos.Repository.*;

public class FuncionarioService {
	

	private IFuncionarioRepository funcionario;

	public FuncionarioService(IFuncionarioRepository funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> findAll() {
		return funcionario.findAll();
	}

	public <S extends Funcionario> S saveAndFlush(S entity) {

		return funcionario.saveAndFlush(entity);
	}

	public Funcionario getById(Long id) {
		return funcionario.getById(id);
	}
	
	public Funcionario save(Funcionario entity) {
		funcionario.save(entity);
		Long id = entity.getID();
		return funcionario.getById(id);
		
	}

	public void deleteById(Long id) {
		funcionario.deleteById(id);
	}

}
