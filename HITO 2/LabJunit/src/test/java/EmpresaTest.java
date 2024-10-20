import org.junit.jupiter.api.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class EmpresaTest {

    private Empresa empresa;
    private ArrayList<Producto> productos;

    // Ejercicio 1: Aplicar el patrón AAA (Arrange-Act-Assert)
    // Arrange: Inicializar los datos necesarios para las pruebas
    // Act: Ejecutar el método a probar
    // Assert: Verificar que el resultado es el esperado

    @BeforeEach
    public void setUp() {
        // Arrange: Inicializar los datos necesarios para las pruebas
        productos = new ArrayList<>();
        productos.add(new Producto(1, "Producto A", 100.0));
        productos.add(new Producto(2, "Producto B", 200.0));
        productos.add(new Producto(3, "Producto C", 150.0));
        empresa = new Empresa("Mi Empresa", "Calle Falsa 123", productos);
    }

    // Ejercicio 2: Aplicar las anotaciones BeforeEach y AfterEach
    @AfterEach
    public void tearDown() {
        // Limpiar los datos después de cada prueba
        empresa = null; // Libera la referencia a la empresa
        productos = null; // Libera la referencia a la lista de productos
    }

    // Ejercicio 3: Prueba del método getProductoMasCaro
    @Test
    public void testGetProductoMasCaro() {
        // Act: Obtener el producto más caro
        Producto productoMasCaro = empresa.getProductoMasCaro();

        // Assert: Verificar que el producto más caro no es nulo y tiene el precio esperado
        assertNotNull(productoMasCaro); // Asegura que no sea nulo
        assertEquals(200.0, productoMasCaro.getPrecio()); // Verifica que el precio del producto más caro sea 200.0
    }

    // Ejercicio 4: Prueba del método getProductosMasCarosQue
    @Test
    public void testGetProductosMasCarosQue() {
        // Act: Obtener los productos más caros que un precio dado (por ejemplo, 120.0)
        var productosCaros = empresa.getProductosMasCarosQue(120.0);

        // Assert: Verificar que la cantidad de productos es la esperada y que todos son más caros que 120.0
        assertEquals(2, productosCaros.size()); // Verifica que hay 2 productos que cumplen la condición
        assertTrue(productosCaros.stream().allMatch(p -> p.getPrecio() > 120.0)); // Asegura que todos los productos en la lista son más caros que 120.0
    }
}
