package br.edu.insper.desagil.aps4.catz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FichaSimplesTest {
    private Gato gato;
    private FichaSimples ficha;
    private LocalDate birthDate = LocalDate.of(2019, 1, 1);
    private String defaultHistory = "História para o gatinho ou a gatinha";


    @Test
    public void semFivSemFelv() {
        gato = new Gato("Max", birthDate, false, false, defaultHistory);
        FichaSimples ficha = new FichaSimples(gato);


        assertEquals(false, ficha.especial());

        Map<String, String> description = ficha.descricao();

        assertTrue(description.get("Nome").equals("Max"));
        assertTrue(description.get("História").equals(defaultHistory));

    }

    @Test
    public void semFivComFelv() {
        gato = new Gato("Max", birthDate, false, true, defaultHistory);
        FichaSimples ficha = new FichaSimples(gato);

        assertEquals(true, ficha.especial());

        Map<String, String> description = ficha.descricao();
        assertTrue(description.get("Nome").equals("Max"));
        assertTrue(description.get("História").equals(defaultHistory));

    }

    @Test
    public void comFivSemFelv() {
        gato = new Gato("Max", birthDate, true, false, defaultHistory);
        FichaSimples ficha = new FichaSimples(gato);

        assertEquals(true, ficha.especial());

        Map<String, String> description = ficha.descricao();
        assertTrue(description.get("Nome").equals("Max"));
        assertTrue(description.get("História").equals(defaultHistory));
    }

    @Test
    public void comFivComFelv() {
        gato = new Gato("Max", birthDate, true, true, defaultHistory);
        FichaSimples ficha = new FichaSimples(gato);

        assertEquals(true, ficha.especial());

        Map<String, String> description = ficha.descricao();
        assertTrue(description.get("Nome").equals("Max"));
        assertTrue(description.get("História").equals(defaultHistory));
    }
}
