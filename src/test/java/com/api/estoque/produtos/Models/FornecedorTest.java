package com.api.estoque.produtos.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FornecedorTest extends Fornecedor {
    private Fornecedor fornecedorTest = new Fornecedor();
    @BeforeEach
     void inserirDados(){

        fornecedorTest.setID(2L);
        fornecedorTest.setNome("casa e video");
    }

    @Test
    @DisplayName("Testando pegar id")
    void testGetID() {
        assertEquals(2L,fornecedorTest.getID());
    }

    @Test
    @DisplayName("Testando pegar Nome")
    void testGetNome() {
      assertEquals("casa e video",fornecedorTest.getNome());
    }

    @Test
    @DisplayName("Testando set id")
    void testSetID() {

        fornecedorTest.setID(3L);
        assertEquals(3L,fornecedorTest.getID());

    }

    @Test
    @DisplayName("Testando set Nome")
    void testSetNome() {
        fornecedorTest.setNome("americanas");
        assertEquals("americanas",fornecedorTest.getNome());
    }
}