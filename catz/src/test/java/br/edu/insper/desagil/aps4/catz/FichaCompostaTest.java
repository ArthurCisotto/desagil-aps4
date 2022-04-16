package br.edu.insper.desagil.aps4.catz;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FichaCompostaTest {
    private FichaComposta ficha;
    private Gato gato;
    private LocalDate defaultBirthDate = LocalDate.of(2022, 1, 1);
    private String defaultCatHistory = "História do gatinho ou da gatinha";

    @Test
    public void tresNormais() {
        Gato gato1 = new Gato("Max", defaultBirthDate, false, false, defaultCatHistory);
        Gato gato2 = new Gato("Miau", defaultBirthDate, false, false, defaultCatHistory);
        Gato gato3 = new Gato("Nord", defaultBirthDate, false, false, defaultCatHistory);

        FichaSimples ficha1 = new FichaSimples(gato1);
        FichaSimples ficha2 = new FichaSimples(gato2);
        FichaSimples ficha3 = new FichaSimples(gato3);

        List<FichaSimples> fichasSimples = new ArrayList<>();
        fichasSimples.add(ficha1);
        fichasSimples.add(ficha2);
        fichasSimples.add(ficha3);

        FichaComposta fichaComposta = new FichaComposta(fichasSimples, "Dois lindos gatinhos e uma linda gatinha");

        String expectedHistory = "Dois lindos gatinhos e uma linda gatinha";
        String expectedNames = "Max, Miau e Nord";

        assertEquals(expectedNames, fichaComposta.descricao().get("Nomes"));
        assertEquals(expectedHistory, fichaComposta.descricao().get("História"));

        assertEquals(false, fichaComposta.especial());
    }

    @Test
    public void umNormalUmEspecial() {
        Gato gato1 = new Gato("Max", defaultBirthDate, false, false, defaultCatHistory);
        Gato gato2 = new Gato("Miau", defaultBirthDate, true, false, defaultCatHistory);

        FichaSimples ficha1 = new FichaSimples(gato1);
        FichaSimples ficha2 = new FichaSimples(gato2);


        List<FichaSimples> fichasSimples = new ArrayList<>();
        fichasSimples.add(ficha1);
        fichasSimples.add(ficha2);


        FichaComposta fichaComposta = new FichaComposta(fichasSimples, "Um lindo gatinho e uma linda gatinha");

        String expectedHistory = "Um lindo gatinho e uma linda gatinha";
        String expectedNames = "Max e Miau";

        assertEquals(expectedNames, fichaComposta.descricao().get("Nomes"));
        assertEquals(expectedHistory, fichaComposta.descricao().get("História"));

        assertEquals(true, fichaComposta.especial());

    }

    @Test
    public void doisEspeciais() {
        Gato gato1 = new Gato("Max", defaultBirthDate, true, true, defaultCatHistory);
        Gato gato2 = new Gato("Miau", defaultBirthDate, true, false, defaultCatHistory);

        FichaSimples ficha1 = new FichaSimples(gato1);
        FichaSimples ficha2 = new FichaSimples(gato2);


        List<FichaSimples> fichasSimples = new ArrayList<>();
        fichasSimples.add(ficha1);
        fichasSimples.add(ficha2);


        FichaComposta fichaComposta = new FichaComposta(fichasSimples, "Um lindo gatinho e uma linda gatinha");

        String expectedHistory = "Um lindo gatinho e uma linda gatinha";
        String expectedNames = "Max e Miau";

        assertEquals(expectedNames, fichaComposta.descricao().get("Nomes"));
        assertEquals(expectedHistory, fichaComposta.descricao().get("História"));

        assertEquals(true, fichaComposta.especial());
    }
}
