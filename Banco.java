public class Banco {

    static final int MAX_CUENTAS = 1000;

    private Cuenta[] cuentas = new Cuenta[MAX_CUENTAS];

    public Status ejecutarTransaccion(Transaccion t) { 
        try {
            t.ejecutar(this);
        } catch (Status s) {
            return s;
        }
        return new Status();
    }

    /*Preguntar por la verificacion del caso borde en el que se alcanza el
     * maximo de cuentas. Mensaje al usuario? No hacer nada?
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

    void hacerDeposito(Deposito t) throws Status {
		if (cuentas[t.obtCuenta()] == null)
            throw new Status(true,Status.msg_error_cuenta);
        if (t.obtMonto() < 0) 
            throw new Status(true,Status.msg_error_monto);
			cuentas[t.obtCuenta()].depositar(t.obtMonto());
			cuentas[t.obtCuenta()].agregarTransaccion(t);        
    }

    void hacerRetiro(Retiro t) throws Status {
		if (cuentas[t.obtCuenta()] == null) 
		   throw new Status(true,Status.msg_error_cuenta);
	    if (t.obtMonto() < 0 || t.obtMonto() > cuentas[t.obtCuenta()].obtSaldo())
		   throw new Status(true,Status.msg_error_monto);
	       cuentas[t.obtCuenta()].retirar(t.obtMonto());
	       cuentas[t.obtCuenta()].agregarTransaccion(t);

    }

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

    void hacerEstadoDeCuenta(EstadoDeCuenta t) throws Status {
        if (cuentas[t.obtCuenta()] == null)
            throw new Status(true,Status.msg_error_cuenta);
        String edc = cuentas[t.obtCuenta()].estadoDeCuenta();
        edc += "bal " + cuentas[t.obtCuenta()].obtSaldo() + "\n";
        t.print(edc);
    }    

}

