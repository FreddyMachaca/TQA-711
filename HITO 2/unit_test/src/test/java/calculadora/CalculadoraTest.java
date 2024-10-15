package calculadora;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
    Calculadora calc;

    @BeforeEach
    public void setUp() {
        System.out.println("Anotaccion BeforeEach");
        calc = new Calculadora(2, 2);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Anotaccion AfterEach");
    }

    @Test
    public void sumaTest() {
        double valorCalculado = calc.suma();
        double valorEsperado = 4;
        Assertions.assertEquals(valorEsperado, valorCalculado, "La suma es incorrecta");
    }

    @Test
    public void restaTest() {
        double valorCalculado = calc.resta();
        double valorEsperado = 0;
        Assertions.assertEquals(valorEsperado, valorCalculado, "La resta es incorrecta");
    }

    @Test
    public void multiplicacionTest() {
        double valorCalculado = calc.multiplicacion();
        double valorEsperado = 4;
        Assertions.assertEquals(valorEsperado, valorCalculado, "La multiplicacion es incorrecta");
    }

    @Test
    public void divisionTest() {
        double valorCalculado = calc.division();
        double valorEsperado = 1;
        Assertions.assertEquals(valorEsperado, valorCalculado, "La division es incorrecta");
    }
}
