package com.api.estoque.produtos.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest extends Fornecedor {

    private Produto produtoTest = new Produto();
    @BeforeEach
    void setUp() {
        produtoTest.setID(2L);
        produtoTest.setNome("mouse");
        produtoTest.setDescricao("acessorio para pc");
        produtoTest.setPreco(22.30F);
        produtoTest.setQuantidade(15);
    }

    @Test
    @DisplayName("Testando get id")
    void testGetID() {
        assertEquals(2l,produtoTest.getID());
    }

    @Test
    @DisplayName("Testando get nome")
    void testGetNome() {
        assertEquals("mouse",produtoTest.getNome());
    }

    @Test
    @DisplayName("Testando get preco")
    void getPreco() {
        assertEquals(22.30F,produtoTest.getPreco());
    }

    @Test
    @DisplayName("Testando get quantidade")
    void getQuantidade() {
        assertEquals(15,produtoTest.getQuantidade());
    }

    @Test
    @DisplayName("Testando get descricao")
    void getDescricao() {
        assertEquals("acessorio para pc",produtoTest.getDescricao());
    }

    @Test
    @DisplayName("Testando set id")
    void testSetID() {
        produtoTest.setID(12L);
        assertEquals(12l,produtoTest.getID());
    }

    @Test
    @DisplayName("Testando set nome")
    void testSetNome() {
        produtoTest.setNome("teclado");
        assertEquals("teclado",produtoTest.getNome());
    }

    @Test
    @DisplayName("testando set preco")
    void setPreco() {
        produtoTest.setPreco(30);
        assertEquals(30,produtoTest.getPreco());
    }

    @Test
    @DisplayName("Testando set quantidade")
    void setQuantidade() {
        produtoTest.setQuantidade(1);
        assertEquals(1,produtoTest.getQuantidade());
    }

    @Test
    @DisplayName("Testando set descricao")
    void setDescricao() {
        produtoTest.setDescricao("para digitacao");
        assertEquals("para digitacao",produtoTest.getDescricao());
    }
}