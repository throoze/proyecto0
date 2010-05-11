/**
 * Clase que implementa el objeto <code>Cuenta</code>. Registra todas las
 * transacciones aplicadas a esta cuenta, asi como el saldo actual de esta.
 * @see Banco
 * @see Transaccion
 * @version 1.0 - 11/05/2010
 * @author Victor De Ponte, 05-38087
 * @author Karina Valera, 06-40414
 */
public class Cuenta {

    static final int MAX_TRANSACCIONES = 100000;
    private int cedula;
    private int cuenta;
    private int indice;
    private int saldo;
    private String[] transacciones = new String[MAX_TRANSACCIONES];

    /**
     * Construye una cuenta inicializando el numero de cuenta en acnt, la cedula
     * del cliente en ci, y el monto de apertura en sum. Asi mismo, inicializa
     * el indice que cuenta las transacciones hechas en 0.
     * @param ci Cedula del cliente
     * @param acnt Numero de cuenta
     * @param sum Monto de apertura
     */
    public Cuenta(int ci, int acnt, int sum) {
        Apertura a = new Apertura(acnt,ci,sum);
        this.cedula = ci;
        this.cuenta = acnt;
        this.indice = 0;
        this.saldo = sum;
    }

    /**
     * Agrega una transaccion al registro de transacciones de la cuenta. Deberia
     * verificar que no se haya alcanzado el maximo de transacciones.
     * @param t Transaccion a agregar
     */
    public void agregarTransaccion(Transaccion t) {
        if (this.indice < MAX_TRANSACCIONES) {
            this.transacciones[this.indice] = t.toString();
            this.indice++;
        }
    }

    /**
     * Deposita la cantidad <code>monto</monto> en la cuenta <code>this</code>.
     * @param monto Cantidad a depositar
     */
    public void depositar(int monto) {
        this.saldo = this.saldo + monto;
    }

    /**
     * Construye un <code>String</code> que almacena el estado de cuenta de la
     * cuenta <code>this</code>.
     * @return String con el estado de la cuenta solicitada
     */
    public String estadoDeCuenta () {
        String edc="";
        for (int k = 0; k < this.indice; k++) {
            edc += k + ". " + this.transacciones[k] + "\n";
        }
        return edc;
    }

    /**
     * Retira la cantidad <code>monto</code> de la cuenta <code>this</code>.
     * @param monto Cantidad a retirar
     */
    public void retirar(int monto) {
        this.saldo = this.saldo - monto;
    }

    /**
     * Getter del atributo <code>cedula</code>
     * @return Cedula del cliente
     */
    public int obtCedula () {
        return this.cedula;
    }

    /**
     * Getter del atributo <code>cuenta</code>
     * @return Numero de cuenta
     */
    public int obtCuenta() {
        return this.cuenta;
    }

    /**
     * Getter del atributo <code>saldo</code>
     * @return Saldo actual de la cuenta
     */
    public int obtSaldo () {
        return this.saldo;
    }
}