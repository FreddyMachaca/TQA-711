import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private String direccion;
    private List<Producto> listProducts;

    public Empresa(String nombre, String direccion, ArrayList<Producto> listProducts) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.listProducts = listProducts;
    }

    public Producto getProductoMasCaro() {
        if (listProducts.isEmpty()) {
            return null;
        }

        Producto productoMasCaro = listProducts.get(0);
        for (Producto producto : listProducts) {
            if (producto.getPrecio() > productoMasCaro.getPrecio()) {
                productoMasCaro = producto;
            }
        }
        return productoMasCaro;
    }

    public List<Producto> getProductosMasCarosQue(double precio) {
        List<Producto> productosCaros = new ArrayList<>();
        for (Producto producto : listProducts) {
            if (producto.getPrecio() > precio) {
                productosCaros.add(producto);
            }
        }
        return productosCaros;
    }
}
