public class Apertura extends Transaccion {

    // Modelo de representacion (atributos):
    private int nroCuenta;
    private int cedula;
    private int monto;

    // Operaciones:

    public Apertura(int cuenta, int cedula, int monto) {
        this.nroCuenta = cuenta;
        this.cedula = cedula;
        this.monto = monto;
    }

    public void ejecutar(Banco banco) throws Status {
        banco.hacerApertura(this);
    }
 
    public String toString() {
        String s;
        s = "apt " + nroCuenta + " " + cedula + " " + monto;
        return s;
    }

    public int obtCuenta() {
        return nroCuenta;
    }

    public int obtCedula() {
        return cedula;
    }

    public int obtMonto() {
        return monto;
    }

}

