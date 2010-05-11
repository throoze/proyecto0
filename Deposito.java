/**
 * Clase que implementa el objeto <code>Deposito</code>. Representa la
 * transaccion 'deposito en una cuenta' en un banco. Hereda de la clase
 * abstracta <code>Transaccion</code>. El formato del comando que ejecuta un
 * deposito en una cuenta es:
 * <blockquote><pre>dep [numCuenta] [monto]</pre></blockquote>
 * @see Banco
 * @see Transaccion
 * @version 1.0 - 11/05/2010
 * @author Victor De Ponte, 05-38087
 * @author Karina Valera, 06-40414
 */
public class Deposito extends Transaccion {

    // Modelo de representacion (atributos):
    private int nroCuenta;
    private int monto;


    // Operaciones:

    /**
     * Construye un objeto <code>Deposito</code>, inicializando
     * <code>this.nroCuenta</code> y <code>this.monto</code> en los valores de
     * <code>acntNumber</code> y <code>sum</code> respectivamente.
     * @param acntNumber int Entero que representa el numero de cuenta donde
     * se va a depositar.
     * @param sum int Entero que representa el monto total de dinero a ser
     * depositado.
     */
    public Deposito(int acntNumber, int sum) {
        this.monto = sum;
        this.nroCuenta = acntNumber;
    }

    /**
     * Reescritura de la funcion ejecutar, heredada de la clase
     * <code>Transaccion</code>.
     * Solicita al banco en uso la ejecucion del Deposito <code>this</code>.
     * @param banco El banco en uso.
     * @throws Status El resultado de la transaccion. (ok. si es exitosa y un
     * mensaje de error en caso contrario)
     */
    @Override
    public void ejecutar(Banco banco) throws Status {
        banco.hacerDeposito(this);
    }

    /**
     * Reescritura de la funcion <code>toString</code>, heredada de la clase
     * Transaccion. Convierte la transaccion <code>this</code> a un
     * <code>String</code> que lo representa, segun el formato establecido:
     * <blockquote><pre>dep [numCuenta] [monto]</pre></blockquote>
     * @param banco El banco en uso.
     * @throws Status El resultado de la transaccion. (ok. si es exitosa y un
     * mensaje de error en caso contrario)
     */
    @Override
    public String toString() {
        String s;
        s = "dep " + this.nroCuenta + " " + this.monto;
        return s;
    }

    /**
     * Getter del atributo 'monto'.
     * @return el monto del deposito 'this'.
     */
    public int obtMonto() {
        return this.monto;
    }

    /**
     * Getter del atributo 'nroCuenta'.
     * @return el el numero de cuenta donde se efectuara el deposito 'this'.
     */
    public int obtCuenta() {
        return this.nroCuenta;
    }
}