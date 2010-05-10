import java.io.PrintStream;

/**
 *
 * @author Victor De Ponte 05-38087, Karina Valera 06-40414
 */
public class EstadoDeCuenta extends Transaccion {

    // Modelo de representacion (atributos):
    private int cuenta;
    private PrintStream salida;

    /**
     * Constructor de la clase EstadoDeCuenta
     * @param acnt numero de cuenta a revisar.
     * @param out Stream de salida del estado de cuenta.
     */
    EstadoDeCuenta(int acnt, PrintStream out) {
        this.cuenta = acnt;
        this.salida = out;
    }

    @Override
    public void ejecutar(Banco banco) throws Status {
        banco.hacerEstadoDeCuenta(this);
    }

    @Override
    public String toString() {
        String s = "edc " + this.cuenta;
        return s;
    }

    public int obtCuenta() {
        return this.cuenta;
    }

    public void print(String edc) {
        this.salida.print(edc);
    }
}