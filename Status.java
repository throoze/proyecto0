public class Status extends Exception {

    private boolean error;
    private String msg;

    public static String msg_error_cuenta = "# cuenta incorrecto";
    public static String msg_error_cuenta1 = "# cuenta1 incorrecto";
    public static String msg_error_cuenta2 = "# cuenta2 incorrecto";
    public static String msg_error_cuenta1_cuenta2 = "# cuenta1 igual a # cuenta2";
    public static String msg_error_monto = "monto incorrecto";

    public Status() {
        error = false;
        msg = "";
    }

    public Status(boolean error, String msg) {
        this.error = error;
        this.msg = msg;
    }

    public String toString() {
        String s;
        if(error)
            s = "Error: " +  msg +  ".";
        else
            s = "Ok.";
        return s;
    }

}

