/**
 * Clase que implementa el objeto <code>Status</code>. Representa el estado de
 * salida de la ejecucion de una transaccion. Los posibles mensajes de retorno
 * son:
 * <p><code>Ok.</code> - Transaccion realizada con exito</p>
 * <p><code>Error: # cuenta incorrecto</code> - Numero de cuenta no existe</p>
 * <p><code>Error: # cuenta1 incorrecto</code> - Cuenta de origen de la
 * transferencia no existe</p>
 * <p><code>Error: # cuenta2 incorrecto</code> - Cuenta de destino de la
 * transferencia no existe</p>
 * <p><code>Error: # cuenta1 igual a # cuenta2</code> - Ambas cuentas en una
 * transferencia son iguales</p>
 * <p><code>Error: monto incorrecto</code> - Monto negativo, o superior al saldo
 * de la cuenta de la que se sustraerá.</p>
 * @see Transaccion
 * @version 1.0 - 11/05/2010
 * @author Victor De Ponte, 05-38087
 * @author Karina Valera, 06-40414
 */
public class Status extends Exception {

    private boolean error;
    private String msg;

    public static String msg_error_cuenta = "# cuenta incorrecto";
    public static String msg_error_cuenta1 = "# cuenta1 incorrecto";
    public static String msg_error_cuenta2 = "# cuenta2 incorrecto";
    public static String msg_error_cuenta1_cuenta2 = "# cuenta1 igual a # cuenta2";
    public static String msg_error_monto = "monto incorrecto";

    /**
     * Construye un <code>Status</code> sin error (Ok.)
     */
    public Status() {
        error = false;
        msg = "";
    }

    /**
     * Construye un <code>Status</code> que devolverá el mensaje
     * <code>msg</code>, el cual sera de error en caso de que
     * <code>error</code> sea igual a <code>true</code>.
     * @param error booleano que indica si hay o no error. En caso de usar este
     * constructor, lo mas probable es que haya error.
     * @param msg El mensaje de error que devolvera el programa
     */
    public Status(boolean error, String msg) {
        this.error = error;
        this.msg = msg;
    }

    /**
     * Fabrica un <code>String</code> que contiene la salida del status de la
     * transaccion realizada con el formato estandar.
     * @return String con el mensaje de salida ("Ok." o algun mensaje de error).
     */
    public String toString() {
        String s;
        if(error)
            s = "Error: " +  msg +  ".";
        else
            s = "Ok.";
        return s;
    }

}

