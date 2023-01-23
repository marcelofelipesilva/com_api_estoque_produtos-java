package com.api.estoque.produtos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.estoque.produtos.Models.Funcionario;
import com.api.estoque.produtos.Repository.IFuncionarioRepository;

@RestController("/funcionario")
@Scope("singleton")
public class FuncionarioController {
	

	private IFuncionarioRepository _funcionarioRepository;

	public FuncionarioController(IFuncionarioRepository _funcionarioRepository) {
		this._funcionarioRepository = _funcionarioRepository;
	}

	@GetMapping(value = "/funcionario", produces = "application/json")
	public List<Funcionario> Exibir_Funcionario() {
		return _funcionarioRepository.findAll();
	}

	@GetMapping(value = "/funcionario/{id}", produces = "application/json")
	public ResponseEntity<Funcionario> Exibir_Funcionario_Id(@PathVariable(value = "id") long id) {
		java.util.Optional<Funcionario> funcionario = _funcionarioRepository.findById(id);
		if (funcionario.isPresent())
			return new ResponseEntity<Funcionario>(funcionario.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/funcionario", produces = "application/json")
	public <S extends Funcionario> S Cadastro_Funcionario(S entity) {

		return _funcionarioRepository.saveAndFlush(entity);
	}
	
	 @PutMapping(value = "/funcionario/{id}", produces="application/json")
	    public ResponseEntity<Funcionario> Atualizar_Funcionario(@PathVariable(value = "id")
	    long id, @Validated @RequestBody Funcionario newFuncionario)
	    {
		 java.util.Optional<Funcionario> oldFuncionario = _funcionarioRepository.findById(id);
	        if(oldFuncionario.isPresent()){
	        	Funcionario funcionario = oldFuncionario.get();
	        	funcionario.setNome(newFuncionario.getNome());
	        	funcionario.setLogin(newFuncionario.getLogin());
	        	funcionario.setMatricula(newFuncionario.getMatricula());
	        	funcionario.setSenha(newFuncionario.getSenha());
	        	
	            _funcionarioRepository.save(funcionario);
	            return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	
	 @DeleteMapping(value = "/funcionario/{id}", produces="application/json")
	    public ResponseEntity<Funcionario> Deletar_Funcionario(@PathVariable(value = "id") long id)
	    {
		 java.util.Optional<Funcionario> funcionario = _funcionarioRepository.findById(id);
	        if(funcionario.isPresent()){
	            _funcionarioRepository.delete(funcionario.get());
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	
	

}
