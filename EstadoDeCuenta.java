import java.io.PrintStream;

/**
 *
 * @author victor
 */
public class EstadoDeCuenta extends Transaccion {

    EstadoDeCuenta(int parseInt, PrintStream out) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    int obtCuenta() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    void print(String edc) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void ejecutar(Banco banco) throws Status {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
