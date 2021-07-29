package com.api.estoque.produtos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.estoque.produtos.Models.Produto;

public interface IProdutoRepository extends JpaRepository<Produto,Long>{

}
