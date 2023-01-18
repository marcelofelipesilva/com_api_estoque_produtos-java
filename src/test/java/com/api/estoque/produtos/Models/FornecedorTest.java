package com.api.estoque.produtos.Models;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class FornecedorTest extends Fornecedor {
    static Fornecedor fornecedor = new Fornecedor();
    @BeforeAll
    static void inserirDados(){

        fornecedor.setID(2L);
        fornecedor.setNome("casa e video");
    }

    @Test
    @DisplayName("Teste pegar id")
    void testGetID() {
        assertEquals(2L,fornecedor.getID());
    }

    @Test
    @DisplayName("Teste pegar Nome")
    void testGetNome() {
      assertEquals("casa e video",fornecedor.getNome());
    }

    @Test
    @DisplayName("Teste set id")
    void testSetID() {
        Fornecedor f = new Fornecedor(1L,"casas bahia");

        f.setID(2L);
        assertEquals(2L,f.getID());

    }

    @Test
    @DisplayName("Teste set Nome")
    void testSetNome() {
        Fornecedor f = new Fornecedor(1L,"casas bahia");

        f.setNome("americanas");
        assertEquals("americanas",f.getNome());
    }
}