/**
 * Clase que representa al objecto Deposito. el formato de entrada es:
 * ret [numeroDeCuenta] [monto]
 * @author Victor De Ponte 05-38087, Karina Valera
 */
class Retiro extends Transaccion {
    
    // Modelo de representacion (atributos):
    private int nroCuenta;
    private int monto;
    
    
    // Operaciones:

    /**
     * Constructor de la clase 'Retiro'. inicializa el numero de cuenta y el
     * monto del deposito, sin ninguna restriccion.
     * @param acntNumber int Entero que representa el numero de cuenta dela cual
     * se va a retirar dinero.
     * @param sum int Entero que representa el monto total de dinero a ser
     * retirado.
     */
    public Retiro(int acntNumber, int sum) {
        this.monto = sum;
        this.nroCuenta = acntNumber;
    }

    /**
     * Reescritura de la funcion ejecutar, heredada de la clase Transaccion.
     * Solicita al banco en uso la ejecucion del Retiro this.
     * @param banco El banco en uso.
     * @throws Status El resultado de la transaccion. (ok. si es exitosa y un
     * mensaje de error en caso contrario)
     */
    @Override
    public void ejecutar(Banco banco) throws Status {
        banco.hacerRetiro(this);
    }

    /**
     * Reescritura de la funcion toString, heredada de la clase Transaccion.
     * Convierte el Retiro 'this' a un String que lo representa, segun el
     * formato establecido:
     * ret [numCuenta] [monto]
     * @param banco El banco en uso.
     * @throws Status El resultado de la transaccion. (ok. si es exitosa y un
     * mensaje de error en caso contrario)
     */
    @Override
    public String toString() {
        String s;
        s = "ret " + this.nroCuenta + " " + this.monto;
        return s;
    }

    /**
     * Getter del atributo 'monto'.
     * @return el monto del retiro 'this'.
     */
    public int obtMonto() {
        return this.monto;
    }

    /**
     * Getter del atributo 'nroCuenta'.
     * @return el el numero de cuenta a la cual se le efectuara el retiro.
     */
    public int obtNroCuenta() {
        return this.nroCuenta;
    }
}
