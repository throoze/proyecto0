/**
 * Clase que implementa el objeto <code>Transaccion</code>. Representa cualquier
 * transaccion que pueda ser realizada en un banco. De esta clase heredan las
 * clases: <code>Apertura</code>, <code>Deposito</code>, <code>Retiro</code>,
 * <code>Transferencia</code> y <code>EstadoDeCuenta</code>. El formato de los
 * comandos que permiten ejecutar cada una de las transacciones son:
 *
 * <blockquote>
 * <p><code>Apertura</code> - apt [numeroDeCuenta] [ciCliente] [monto]</p>
 * <p><code>Deposito</code> - dep [numeroDeCuenta] [monto]</p>
 * <p><code>Retiro</code> - ret [numeroDeCuenta] [monto]</p>
 * <p><code>Transferencia</code> - trn [ctaOrigen] [ctaDestino] [monto]</p>
 * <p><code>EstadoDeCuenta</code> - edc [numeroDeCuenta]</p>
 * </blockquote>
 * @see Apertura
 * @see Deposito
 * @see Retiro
 * @see Transferencia
 * @see EstadoDeCuenta
 * @see Banco
 * @version 1.0 - 11/05/2010
 * @author Victor De Ponte, 05-38087
 * @author Karina Valera, 06-40414
 */
abstract public class Transaccion {

    /**
     * Solicita al banco que alberga <code>this.cuenta</code> que se ejecute la
     * transaccion.
     * @param banco Banco que alberga la cuenta en uso
     * @throws Status Resultado de ejecutar la transaccion
     * @see Status
     * @see Transaccion
     */
    abstract public void ejecutar(Banco banco) throws Status;

    /**
     * Devuelve un <code>String</code> con el comando usado para ejecutar la
     * transaccion actual.
     * @return <code>String</code> que contiene el comando de la transaccion en
     * uso
     */
    abstract public String toString();
}