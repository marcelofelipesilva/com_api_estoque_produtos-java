package com.api.estoque.produtos.Controller;

import com.api.estoque.produtos.Models.Fornecedor;
import com.api.estoque.produtos.Repository.IFornecedorRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController("/fornecedor")
@Scope("singleton")
public class FornecedorController {


	private IFornecedorRepository _fornecedorRepository;

	public FornecedorController(IFornecedorRepository _fornecedorRepository) {
		this._fornecedorRepository = _fornecedorRepository;
	}

	@GetMapping(value = "/fornecedor", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public List<Fornecedor> Exibir_Fornecedor() {
		return _fornecedorRepository.findAll();
	}

	@GetMapping(value = "/fornecedor/{id}", produces = "application/json")
	public ResponseEntity<Fornecedor> Exibir_Fornecedor_Id(@PathVariable(value = "id") long id) {
		java.util.Optional<Fornecedor> fornecedor = _fornecedorRepository.findById(id);
		if (fornecedor.isPresent())
			return new ResponseEntity<Fornecedor>(fornecedor.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/fornecedor", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public <S extends Fornecedor> S Cadastro_Fornecedor(S entity) {

		return _fornecedorRepository.saveAndFlush(entity);
	}
	
	 @PutMapping(value = "/fornecedor/{id}", produces="application/json")
	    public ResponseEntity<Fornecedor> Atualizar_Fornecedor(@PathVariable(value = "id") long id, @Validated @RequestBody Fornecedor newFornecedor)
	    {
		 java.util.Optional<Fornecedor> oldFornecedor = _fornecedorRepository.findById(id);
	        if(oldFornecedor.isPresent()){
	        	Fornecedor fornecedor = oldFornecedor.get();
	        	fornecedor.setNome(newFornecedor.getNome());
	        	
	            _fornecedorRepository.save(fornecedor);
	            return new ResponseEntity<Fornecedor>(fornecedor, HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	
	 @DeleteMapping(value = "/fornecedor/{id}", produces="application/json")
	    public ResponseEntity<Fornecedor> Deletar_Fornecedor(@PathVariable(value = "id") long id)
	    {
		 java.util.Optional<Fornecedor> fornecedor = _fornecedorRepository.findById(id);
	        if(fornecedor.isPresent()){
	            _fornecedorRepository.delete(fornecedor.get());
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	
	
	
}
