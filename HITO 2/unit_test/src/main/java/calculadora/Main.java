package calculadora;

public class Main {
    public static void main(String[] args) {
        Calculadora calc1 = new Calculadora(5, 3);

        System.out.println("Suma: " + calc1.suma());
        System.out.println("Resta: " + calc1.resta());
        System.out.println("Multiplicación: " + calc1.multiplicacion());
        System.out.println("División: " + calc1.division());
    }
}
