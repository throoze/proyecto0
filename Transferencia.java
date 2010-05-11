/**
 * Clase que implementa el objeto <code>Transferencia</code>. Representa la
 * transaccion 'transaccion entre cuentas' en un banco. Hereda de la clase
 * abstracta <code>Transaccion</code>. El formato del comando que ejecuta una
 * transferencia entre cuentas es:
 * <blockquote><pre>trn [ctaOrigen] [ctaDestino] [monto]</pre></blockquote>
 * @see Banco
 * @see Transaccion
 * @version 1.0 - 11/05/2010
 * @author Victor De Ponte, 05-38087
 * @author Karina Valera, 06-40414
 */
public class Transferencia extends Transaccion {

    // Modelo de representacion (atributos):
    private int ctaOrigen;
    private int ctaDestino;
    private int monto;

    // Operaciones:

    /**
     * Construye un objeto <code>Transferencia</code>, inicializando
     * <code>this.ctaOrigen</code>, <code>this.ctaDestino</code> y
     * <code>this.monto</code> en los valores de <code>orig</code>,
     * <code>dest</code> y <code>mont</code> respectivamente.
     * @param orig Nro de cuenta del origen de la transferencia
     * @param dest Nro de cuenta del destino de la transferencia
     * @param mont Suma de dinero a transferir
     */
    Transferencia(int orig, int dest, int mont) {
        this.ctaDestino = dest;
        this.ctaOrigen = orig;
        this.monto = mont;
    }

    /**
     * Solicita al banco que alberga <code>this.cuenta</code> que se ejecute la
     * transaccion <code>Transferencia</code>.
     * @param banco Banco que alberga la cuenta en uso
     * @throws Status Resultado de ejecutar la transaccion
     * @see Status
     * @see Transaccion
     */
    @Override
    public void ejecutar(Banco banco) throws Status {
        banco.hacerTransferencia(this);
    }

    /**
     * Devuelve un <code>String</code> con el comando usado para ejecutar la
     * transferencia actual.
     * @return <code>String</code> que contiene el comando de la transferencia
     * en uso.
     */
    @Override
    public String toString() {
        String s;
        s = "trn " + this.ctaOrigen + " " + this.ctaDestino + " " + this.monto;
        return s;
    }

    /**
     * Getter del atributo <code>ctaOrigen</code>.
     * @return El numero de cuenta del origen de la transferencia
     */
    public int obtCtaOrigen() {
        return this.ctaOrigen;
    }

    /**
     * Getter del atributo <code>ctaDestino</code>.
     * @return El numero de cuenta del destino de la transferencia
     */
    public int obtCtaDestino() {
        return this.ctaDestino;
    }

    /**
     * Getter del atributo <code>monto</code>.
     * @return El monto a transferir
     */
    public int obtMonto() {
        return this.monto;
    }
}
