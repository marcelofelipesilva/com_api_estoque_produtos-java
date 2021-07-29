package com.api.estoque.produtos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.estoque.produtos.Models.Fornecedor;

public interface IFornecedorRepository extends JpaRepository<Fornecedor, Long>{

}
