package com.api.estoque.produtos.Controller;

import com.api.estoque.produtos.Models.Produto;
import com.api.estoque.produtos.Repository.IProdutoRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/produto")
@Scope("singleton")
public class ProdutoController {
	
	

	private IProdutoRepository _produtoRepository;

	public ProdutoController(IProdutoRepository _produtoRepository) {
		this._produtoRepository = _produtoRepository;
	}

	@GetMapping(value = "/produto", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public List<Produto> Exibir_Produto() {
		return _produtoRepository.findAll();
	}

	@GetMapping(value = "/produto/{id}", produces = "application/json")
	public ResponseEntity<Produto> Exibir_Produto_Id(@PathVariable(value = "id") long id) {
		java.util.Optional<Produto> produto = _produtoRepository.findById(id);
		if (produto.isPresent())
			return new ResponseEntity<Produto>(produto.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/produto", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public <S extends Produto> S Cadastro_Produto(S entity) {

		return _produtoRepository.saveAndFlush(entity);
	}
	
	 @PutMapping(value = "/produto/{id}", produces="application/json")
	    public ResponseEntity<Produto> Atualizar_Produto(@PathVariable(value = "id")
	    long id, @Validated @RequestBody Produto newProduto)
	    {
		 java.util.Optional<Produto> oldProduto = _produtoRepository.findById(id);
	        if(oldProduto.isPresent()){
	        	Produto produto = oldProduto.get();
	        	produto.setNome(newProduto.getNome());
	        	produto.setDescricao(newProduto.getDescricao());
	        	produto.setPreco(newProduto.getPreco());
	        	produto.setQuantidade(newProduto.getQuantidade());
	        	
	            _produtoRepository.save(produto);
	            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	
	 @DeleteMapping(value = "/produto/{id}", produces="application/json")
	    public ResponseEntity<Produto> Deletar_Produto(@PathVariable(value = "id") long id)
	    {
		 java.util.Optional<Produto> produto = _produtoRepository.findById(id);
	        if(produto.isPresent()){
	            _produtoRepository.delete(produto.get());
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	

}
