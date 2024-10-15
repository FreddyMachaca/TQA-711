package servicioPicoPlaca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static servicioPicoPlaca.Ciudad.LAPAZ;
import static servicioPicoPlaca.Dia.LUNES;

public class ServicioPicoPlacaTest {
    @Test
    public void puedeSalir() {
        //Arrange
        ServicioPicoPlaca servicioPicoPlaca = new ServicioPicoPlaca();
        //Act
        boolean resultado = servicioPicoPlaca.puedeSalir(LAPAZ, LUNES, "ABC123");
        //Asert
        Assertions.assertTrue(resultado);
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "LAPAZ,SABADO, ADF111, true",
                    "LAPAZ,JUEVES, ASD228, false",
                    "LAPAZ,MARTES, AEE006, true",
                    "LAPAZ,MIERCOLES, AEE777, true"
            }

    )
    public void puedeSalirTest(Ciudad ciudad, Dia dia, String placa, boolean resultado) {
        /** Patron AAA */
        //Arrange
        ServicioPicoPlaca servicioPicoPlaca = new ServicioPicoPlaca();
        //act
        boolean resultadoActual = servicioPicoPlaca.puedeSalir(ciudad, dia, placa);
        boolean resultadoEsperado = resultado;
        //Assert
        Assertions.assertEquals(resultadoActual, resultadoEsperado, "Error en la validación");

    }
}
