package empleado;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmpleadoTest {

    @Test
    public void testObtenerSalario() {
        Empleado empleado = new Empleado("Juan", 10);
        double salario = empleado.obtenerSalario(40);
        Assertions.assertEquals(400, salario);
        System.out.println("Salario: " + salario);
    }
}
