package empleado;

public class Empleado {

    private String nombre;
    private double pagoPorHora;

    public Empleado(String nombre, double pagoPorHora) {
        this.nombre = nombre;
        this.pagoPorHora = pagoPorHora;
    }

    public double obtenerSalario(double horasTrabajadas) {
        return pagoPorHora * horasTrabajadas;
    }
}
