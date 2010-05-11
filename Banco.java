/**
 * Clase que implementa el objeto <code>Banco</code>. Se encarga de albergar
 * todas las cuentas y de ejecutar todas las transacciones.
 * @see Cuenta
 * @see Transaccion
 * @version 1.0 - 11/05/2010
 * @author Victor De Ponte, 05-38087
 * @author Karina Valera, 06-40414
 */
public class Banco {

    static final int MAX_CUENTAS = 1000;

    private Cuenta[] cuentas = new Cuenta[MAX_CUENTAS];

    /**
     * Llama al metodo ejecutar de la transaccion t
     * @param t Transaccion a ejecutar
     * @return El <code>Status</code> de salida de la ejecucion de la
     * transaccion
     */
    public Status ejecutarTransaccion(Transaccion t) {
        try {
            t.ejecutar(this);
        } catch (Status s) {
            return s;
        }
        return new Status();
    }

    /**
     * Abre una cuenta en el banco <code>this</code>.
     * Deberian hacerse las verificaciones por si el banco ha alcanzado el
     * maximo posible de cuentas a albergar.
     * @param t Transaccion a ser ejecutada
     * @throws Status Status de Salida de la ejecucion de la transaccion
     */
    void hacerApertura(Apertura t) throws Status {
        if (cuentas[t.obtCuenta()] != null)
            throw new Status(true,Status.msg_error_cuenta);
        if (t.obtMonto() < 0) 
            throw new Status(true,Status.msg_error_monto);
        Cuenta c = new Cuenta(t.obtCuenta(),t.obtCedula(),t.obtMonto());
        cuentas[t.obtCuenta()] = c;
        cuentas[t.obtCuenta()].agregarTransaccion(t);
    }

    /**
     * Hace un deposito en una cuenta albergada en el banco <code>this</code>.
     * @param t Transaccion a ser ejecutada
     * @throws Status Status de Salida de la ejecucion de la transaccion
     */
    void hacerDeposito(Deposito t) throws Status {
		if (cuentas[t.obtCuenta()] == null)
            throw new Status(true,Status.msg_error_cuenta);
        if (t.obtMonto() < 0) 
            throw new Status(true,Status.msg_error_monto);
			cuentas[t.obtCuenta()].depositar(t.obtMonto());
			cuentas[t.obtCuenta()].agregarTransaccion(t);        
    }

    /**
     * Hace un retiro en una cuenta albergada en el banco <code>this</code>.
     * @param t Transaccion a ser ejecutada
     * @throws Status Status de Salida de la ejecucion de la transaccion
     */
    void hacerRetiro(Retiro t) throws Status {
		if (cuentas[t.obtCuenta()] == null) 
		   throw new Status(true,Status.msg_error_cuenta);
	    if (t.obtMonto() < 0 || t.obtMonto() > cuentas[t.obtCuenta()].obtSaldo())
		   throw new Status(true,Status.msg_error_monto);
	       cuentas[t.obtCuenta()].retirar(t.obtMonto());
	       cuentas[t.obtCuenta()].agregarTransaccion(t);

    }

    /**
     * Hace una transferencia entre cuentas albergadas en el banco
     * <code>this</code>.
     * @param t Transaccion a ser ejecutada
     * @throws Status Status de Salida de la ejecucion de la transaccion
     */
    void hacerTransferencia(Transferencia t) throws Status {
	    if (cuentas[t.obtCtaOrigen()] == null)
            throw new Status(true,Status.msg_error_cuenta1);
		if (cuentas[t.obtCtaDestino()] == null)
            throw new Status(true,Status.msg_error_cuenta2);
        if (cuentas[t.obtCtaOrigen()] == cuentas[t.obtCtaDestino()])
            throw new Status(true,Status.msg_error_cuenta1_cuenta2);
		if (t.obtMonto()<0  || t.obtMonto() > cuentas[t.obtCtaOrigen()].obtSaldo())
            throw new Status(true,Status.msg_error_monto); 
			int c =t.obtMonto();
         cuentas[t.obtCtaOrigen()].retirar(c);
		 cuentas[t.obtCtaDestino()].depositar(c);
		 cuentas[t.obtCtaOrigen()].agregarTransaccion(t);
		 cuentas[t.obtCtaDestino()].agregarTransaccion(t);
    }

    /**
     * Solicita el estado de una cuenta albergada en el banco y agrega al final
     * de este el balance de dicha cuenta.
     * <code>this</code>.
     * @param t Transaccion a ser ejecutada
     * @throws Status Status de Salida de la ejecucion de la transaccion
     */
    void hacerEstadoDeCuenta(EstadoDeCuenta t) throws Status {
        if (cuentas[t.obtCuenta()] == null)
            throw new Status(true,Status.msg_error_cuenta);
        String edc = cuentas[t.obtCuenta()].estadoDeCuenta();
        edc += "bal " + cuentas[t.obtCuenta()].obtSaldo() + "\n";
        t.print(edc);
    }    
}