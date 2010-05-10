/**
 *
 * @author victor
 */
public class Cuenta {

    static final int MAX_TRANSACCIONES = 100000;
    private int cedula;
    private int cuenta;
    private int indice;
    private int saldo;
    private String[] transacciones = new String[MAX_TRANSACCIONES];

    public Cuenta(int ci, int acnt, int sum) {
        Apertura a = new Apertura(acnt,ci,sum);
        this.cedula = ci;
        this.cuenta = acnt;
        this.indice = 0;
        this.saldo = sum;
    }

    /*Preguntar por la verificacion del caso borde en el que se alcanza el
     * maximo de transacciones. Mensaje al usuario? No hacer nada?
     */
    public void agregarTransaccion(Transaccion t) {
        if (this.indice < MAX_TRANSACCIONES) {
            this.transacciones[this.indice] = t.toString();
            this.indice++;
        }
    }

    public void depositar(int monto) {
        this.saldo = this.saldo + monto;
    }

    public String estadoDeCuenta () {
        String edc="";
        for (int k = 0; k < this.indice; k++) {
            edc += k + ". " + this.transacciones[k] + "\n";
        }
        return edc;
    }
    
    public void retirar(int monto) {
        this.saldo = this.saldo - monto;
    }

    public int obtCedula () {
        return this.cedula;
    }

    public int obtCuenta() {
        return this.cuenta;
    }

    public int obtSaldo () {
        return this.saldo;
    }
}