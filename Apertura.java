/**
 * Clase que implementa el objeto <code>Apertura</code>. Representa la 
 * transaccion 'apertura de cuenta' en un banco. Hereda de la clase abstracta
 * <code>Transaccion</code>. El formato del comando que ejecuta una apertura de
 * cuenta es:
 * <blockquote><pre>apt [numeroDeCuenta] [ciCliente] [monto]</pre></blockquote>
 * @see Banco
 * @see Transaccion
 * @version 1.0 - 11/05/2010
 * @author Victor De Ponte, 05-38087
 * @author Karina Valera, 06-40414
 */
public class Apertura extends Transaccion {

    // Modelo de representacion (atributos):
    private int nroCuenta;
    private int cedula;
    private int monto;

    // Operaciones:

    /**
     * Construye un objeto <code>Apertura</code>, inicializando
     * <code>this.nroCuenta</code>, <code>this.cedula</code> y
     * <code>this.monto</code> en los valores de <code>cuenta</code>,
     * <code>cedula</code> y <code>monto</code> respectivamente.
     * @param cuenta Numero de cuenta a abrir
     * @param cedula Cedula del cliente de la cuenta
     * @param monto saldo inicial de la cuenta
     */
    public Apertura(int cuenta, int cedula, int monto) {
        this.nroCuenta = cuenta;
        this.cedula = cedula;
        this.monto = monto;
    }

    /**
     * Solicita al banco que alberga <code>this.cuenta</code> que se ejecute la
     * transaccion <code>Apertura</code>.
     * @param banco Banco que alberga la cuenta en uso
     * @throws Status Resultado de ejecutar la transaccion
     * @see Status
     * @see Transaccion
     */
    public void ejecutar(Banco banco) throws Status {
        banco.hacerApertura(this);
    }

    /**
     * Devuelve un <code>String</code> con el comando usado para ejecutar la
     * apertura actual.
     * @return <code>String</code> que contiene el comando de la apertura en uso
     */
    public String toString() {
        String s;
        s = "apt " + nroCuenta + " " + cedula + " " + monto;
        return s;
    }

    /**
     * Getter del atributo <code>nroCuenta</code>
     * @return El numero de cuenta de la apertura en uso
     */
    public int obtCuenta() {
        return nroCuenta;
    }

    /**
     * Getter del atributo <code>cedula</code>
     * @return Nro de cedula del cliente de la cuenta a abrir
     */
    public int obtCedula() {
        return cedula;
    }

    /**
     * Getter del atributo <code>monto</code>
     * @return Saldo inicial de la cuenta a ser abierta
     */
    public int obtMonto() {
        return monto;
    }

}

