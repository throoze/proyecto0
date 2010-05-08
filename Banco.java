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
    }

    void hacerRetiro(Retiro t) throws Status {
    }

    void hacerTransferencia(Transferencia t) throws Status {
    }

    void hacerEstadoDeCuenta(EstadoDeCuenta t) throws Status {
        if (cuentas[t.obtCuenta()] == null)
            throw new Status(true,Status.msg_error_cuenta);
        String edc = cuentas[t.obtCuenta()].estadoDeCuenta();
        edc += "bal " + cuentas[t.obtCuenta()].obtSaldo() + "\n";
        t.print(edc);
    }    

}

