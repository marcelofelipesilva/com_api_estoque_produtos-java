package com.api.estoque.produtos.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest extends Fornecedor {

    private Funcionario funcionarioTest = new Funcionario();
    @BeforeEach
    void setUp() {
        funcionarioTest.setID(1L);
        funcionarioTest.setNome("Pedro");
        funcionarioTest.setLogin("pedrojp");
        funcionarioTest.setSenha("senha123");
        funcionarioTest.setMatricula(4522);


    }

    @Test
    @DisplayName("Testando get di")
    void testGetID() {

        assertEquals(1L,funcionarioTest.getID());
    }

    @Test
    @DisplayName("Testando get nome")
    void testGetNome() {

        assertEquals("Pedro",funcionarioTest.getNome());
    }

    @Test
    @DisplayName("Testando get login")
    void getLogin() {

        assertEquals("pedrojp",funcionarioTest.getLogin());
    }

    @Test
    @DisplayName("Testando get senha")
    void getSenha() {

        assertEquals("senha123",funcionarioTest.getSenha());
    }

    @Test
    @DisplayName("Testando get matricula")
    void getMatricula() {

        assertEquals(4522,funcionarioTest.getMatricula());
    }

    @Test
    @DisplayName("Testando set id")
    void testSetID() {
        funcionarioTest.setID(5L);
        assertEquals(5l,funcionarioTest.getID());
    }

    @Test
    @DisplayName("Testando set nome")
    void testSetNome() {
        funcionarioTest.setNome("Joao");
        assertEquals("Joao",funcionarioTest.getNome());
    }

    @Test
    @DisplayName("Testando set login")
    void setLogin() {
        funcionarioTest.setLogin("joaopc");
        assertEquals("joaopc",funcionarioTest.getLogin());
    }

    @Test
    @DisplayName("Testando set senha")
    void setSenha() {
        funcionarioTest.setSenha("123");
        assertEquals("123",funcionarioTest.getSenha());
    }

    @Test
    @DisplayName("Testando set matricula")
    void setMatricula() {
        funcionarioTest.setMatricula(11111);
        assertEquals(11111,funcionarioTest.getMatricula());
    }
}