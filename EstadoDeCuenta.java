import java.io.PrintStream;

/**
 * Clase que implementa el objeto <code>EstadoDeCuenta</code>. Representa la
 * transaccion 'ver el estado de una cuenta' en un banco. Hereda de la clase
 * abstracta <code>Transaccion</code>. El formato del comando que ejecuta una
 * solicitud de estado de cuenta es:
 * <blockquote><pre>edc [numeroDeCuenta]</pre></blockquote>
 * @see Banco
 * @see Transaccion
 * @version 1.0 - 11/05/2010
 * @author Victor De Ponte, 05-38087
 * @author Karina Valera, 06-40414
 */
public class EstadoDeCuenta extends Transaccion {

    // Modelo de representacion (atributos):
    private int cuenta;
    private PrintStream salida;

    /**
     * Construye un objeto <code>EstadoDeCuenta</code>, inicializando
     * <code>this.cuenta</code> y <code>this.salida</code> en los valores de
     * <code>acnt</code> y <code>out</code> respectivamente.
     * @param acnt numero de cuenta a revisar.
     * @param out Stream de salida del estado de cuenta.
     */
    EstadoDeCuenta(int acnt, PrintStream out) {
        this.cuenta = acnt;
        this.salida = out;
    }

    /**
     * Reescritura de la funcion ejecutar, heredada de la clase
     * <code>Transaccion</code>.
     * Solicita al banco en uso la ejecucion de la solicitud del estado de
     * cuenta <code>this</code>.
     * @param banco El banco en uso.
     * @throws Status El resultado de la transaccion. (ok. si es exitosa y un
     * mensaje de error en caso contrario)
     */
    @Override
    public void ejecutar(Banco banco) throws Status {
        banco.hacerEstadoDeCuenta(this);
    }

    /**
     * Reescritura de la funcion <code>toString</code>, heredada de la clase
     * Transaccion. Convierte la transaccion <code>this</code> a un
     * <code>String</code> que lo representa, segun el formato establecido:
     * <blockquote><pre>edc [numCuenta]</pre></blockquote>
     * @throws Status El resultado de la transaccion. (ok. si es exitosa y un
     * mensaje de error en caso contrario)
     */
    @Override
    public String toString() {
        String s = "edc " + this.cuenta;
        return s;
    }

    /**
     * Getter del atributo 'cuenta'.
     * @return el numero de cuenta donde se efectuara el deposito 'this'.
     */
    public int obtCuenta() {
        return this.cuenta;
    }

    /**
     * Manda el String <code>edc</code> por la salida asignada al
     * <code>PrintStream salida</code>.
     * @param edc String a escupir
     */
    public void print(String edc) {
        this.salida.print(edc);
    }
}