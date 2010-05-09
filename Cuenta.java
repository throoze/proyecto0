/**
 *
 * @author victor
 */
public class Cuenta {

    private int numeroDeCuenta;
    private int ci;
    private int saldo;
    private static int indice=0;

    Cuenta(int obtCuenta, int obtCedula, int obtMonto) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public void agregarTransaccion(Transaccion t) {

    }

    public String estadoDeCuenta () {
        String edc="";
        return edc;
    }

    public int obtSaldo () {
        return this.saldo;
    }
}