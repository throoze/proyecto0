/**
 * Clase que representa al objecto Deposito. el formato de entrada es:
 * dep [numCuenta] [monto]
 * @author Victor De Ponte 05-38087, Karina Valera
 */
public class Deposito extends Transaccion {

    // Modelo de representacion (atributos):
    private int nroCuenta;
    private int monto;


    // Operaciones:

    /**
     * Constructor de la clase 'Deposito'. inicializa el numero de cuenta y el
     * monto del deposito, sin ninguna restriccion.
     * @param acntNumber int Entero que representa el numero de cuenta donde
     * se va a depositar.
     * @param sum int Entero que representa el monto total de dinero a ser
     * depositado.
     */
    public Deposito(int acntNumber, int sum) {
        this.monto = sum;
        this.nroCuenta = acntNumber;
    }

    /**
     * Reescritura de la funcion ejecutar, heredada de la clase Transaccion.
     * Solicita al banco en uso la ejecucion del Deposito 'this'.
     * @param banco El banco en uso.
     * @throws Status El resultado de la transaccion. (ok. si es exitosa y un
     * mensaje de error en caso contrario)
     */
    @Override
    public void ejecutar(Banco banco) throws Status {
        banco.hacerDeposito(this);
    }

    /**
     * Reescritura de la funcion toString, heredada de la clase Transaccion.
     * Convierte la transaccion 'this' a un String que lo representa, segun el
     * formato establecido:
     * dep [numCuenta] [monto]
     * @param banco El banco en uso.
     * @throws Status El resultado de la transaccion. (ok. si es exitosa y un
     * mensaje de error en caso contrario)
     */
    @Override
    public String toString() {
        String s;
        s = "dep " + this.nroCuenta + " " + this.monto;
        return s;
    }

    /**
     * Getter del atributo 'monto'.
     * @return el monto del deposito 'this'.
     */
    public int obtMonto() {
        return this.monto;
    }

    /**
     * Getter del atributo 'nroCuenta'.
     * @return el el numero de cuenta donde se efectuara el deposito 'this'.
     */
    public int obtCuenta() {
        return this.nroCuenta;
    }
}