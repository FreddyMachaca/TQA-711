package calculadora;

public class Calculadora {
    private double numero1;
    private double numero2;

    public Calculadora(double numero1, double numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public double suma() {
        return this.numero1 + this.numero2;
    }

    public double resta() {
        return this.numero1 - this.numero2;
    }

    public double multiplicacion() {
        return this.numero1 * this.numero2;
    }

    public double division() {
        return this.numero1 / this.numero2;
    }
}
