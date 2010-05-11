/**
 * Clase que representa al objecto Deposito. Hereda de la clase
 * <code>Transaccion</code>. El formato de entrada es:
 * <blockquote><pre>ret [numeroDeCuenta] [monto]</pre></blockquote>
 * @see Banco
 * @see Transaccion
 * @version 1.0 - 11/05/2010
 * @author Victor De Ponte, 05-38087
 * @author Karina Valera, 06-40414
 */
class Retiro extends Transaccion {
    
    // Modelo de representacion (atributos):
    private int nroCuenta;
    private int monto;
    
    
    // Operaciones:

    /**
     * Constructor de la clase <code>Retiro</code>. Inicializa el numero de
     * cuenta y el monto del deposito, sin ninguna restriccion.
     * @param acntNumber Entero (int) que representa el numero de cuenta de la
     * cual se va a retirar dinero.
     * @param sum Entero (int) que representa el monto total de dinero a ser
     * retirado.
     */
    public Retiro(int acntNumber, int sum) {
        this.monto = sum;
        this.nroCuenta = acntNumber;
    }

    /**
     * Reescritura de la funcion ejecutar, heredada de la clase Transaccion.
     * Solicita al banco en uso la ejecucion del Retiro <code>this</code>.
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
     * Convierte el Retiro <code>this</code> a un String
     * que lo representa, segun el formato establecido:
     * <blockquote><pre>ret [numeroDeCuenta] [monto]</pre></blockquote>
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
     * Getter del atributo <code>monto</code>.
     * @return el monto del retiro <code>this</code>.
     */
    public int obtMonto() {
        return this.monto;
    }

    /**
     * Getter del atributo <code>nroCuenta</code>.
     * @return el numero de cuenta a la cual se le efectuara el retiro.
     */
    public int obtCuenta() {
        return this.nroCuenta;
    }
}
