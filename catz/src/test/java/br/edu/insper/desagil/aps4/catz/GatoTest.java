package br.edu.insper.desagil.aps4.catz;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GatoTest {
    private Gato gato;

    @BeforeEach
    public void setUp() {
        // Crate local date
        LocalDate date = LocalDate.of(2020, 1, 1);
        gato = new Gato("Max", date, false, false, "Linda história do gatinho Max aqui!");
    }

    @Test
    public void adicionaTresPadrinhosNormais() {
        gato.atualizaApadrinhamento("André", 100);
        gato.atualizaApadrinhamento("Bruno", 160);
        gato.atualizaApadrinhamento("Carlos", 200);

        // Verifica se a lista de padrinhos e total de apadrinhamentos estão corretos
        final List<String> expectedPadrinhosList = new ArrayList<>();
        expectedPadrinhosList.add("André");
        expectedPadrinhosList.add("Bruno");
        expectedPadrinhosList.add("Carlos");

        assertTrue(gato.padrinhos().contains("André"));
        assertTrue(gato.padrinhos().contains("Bruno"));
        assertTrue(gato.padrinhos().contains("Carlos"));

        // Verifica o valor dos apadrinhamentos
        final int expectedTotalApadrinhamentos = 100 + 160 + 200;
        assertEquals(expectedTotalApadrinhamentos, gato.totalApadrinhamentos());
    }

    @Test
    public void adicionaTresPadrinhosNormaisUmPadrinhoComZero() {
        gato.atualizaApadrinhamento("André", 100);
        gato.atualizaApadrinhamento("Bruno", 160);
        gato.atualizaApadrinhamento("Carlos", 200);
        gato.atualizaApadrinhamento("Felipe", 0);

        final List<String> expectedPadrinhosList = new ArrayList<>();
        expectedPadrinhosList.add("André");
        expectedPadrinhosList.add("Bruno");
        expectedPadrinhosList.add("Carlos");

        assertTrue(gato.padrinhos().contains("André"));
        assertTrue(gato.padrinhos().contains("Bruno"));
        assertTrue(gato.padrinhos().contains("Carlos"));

        final int expectedTotalApadrinhamentos = 100 + 160 + 200;
        assertEquals(expectedTotalApadrinhamentos, gato.totalApadrinhamentos());
    }

    @Test
    public void adicionaTresPadrinhosNormaisRemoveUm() {
        gato.atualizaApadrinhamento("André", 100);
        gato.atualizaApadrinhamento("Bruno", 160);
        gato.atualizaApadrinhamento("Carlos", 200);

        gato.atualizaApadrinhamento("André", 0);

        final List<String> expectedPadrinhosList = new ArrayList<>();
        expectedPadrinhosList.add("André");
        expectedPadrinhosList.add("Bruno");

        assertTrue(gato.padrinhos().contains("Carlos"));
        assertTrue(gato.padrinhos().contains("Bruno"));

        final int expectedTotalApadrinhamentos = 200 + 160;
        assertEquals(expectedTotalApadrinhamentos, gato.totalApadrinhamentos());
    }
}
