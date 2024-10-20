import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Producto A", 100.0));
        productos.add(new Producto(2, "Producto B", 200.0));
        productos.add(new Producto(3, "Producto C", 150.0));
        productos.add(new Producto(4, "Producto D", 300.0));

        Empresa empresa = new Empresa("Mi Empresa", "Calle Falsa 123", productos);

        System.out.println("Producto más caro: " + empresa.getProductoMasCaro());
        System.out.println("Productos con precio mayor a 120.0: " + empresa.getProductosMasCarosQue(120.0));
        }
}
