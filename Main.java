import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Programa cliente suministrado por la catedra. Deberia chequear la validez de
 * los comandos introducidos.
 * @author La Catedra de Algoritmos y Estructuras III
 */
public class Main {

    private BufferedReader in;
    private PrintStream out;
    private Banco banco;

    public Main() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = System.out;
        banco = new Banco();
    }

    public Main(String fin, String fout) {
       
        this();
        
        BufferedReader in = null;
        PrintStream out = null;

        try {
            in = new BufferedReader(new FileReader(fin));
            out = new PrintStream(fout);

            // si no hubo error, los asigno a los dos
            this.in = in;
            this.out = out;
        } catch (FileNotFoundException fnfe) {
            System.err.println("Error al crear archivos, usando entrada y" +
                    " salida estandar");
        }
    }

    private Transaccion crearTransaccion(String linea) {
        String[] tokens = linea.split(" ");
        String tipoOp = tokens[0];
        Transaccion t = null;
        
        if (tipoOp.equals("apt")) {
            t = new Apertura(Integer.parseInt(tokens[1]),
                             Integer.parseInt(tokens[2]),
                             Integer.parseInt(tokens[3]));
        } else if (tipoOp.equals("dep")) {
            t = new Deposito(Integer.parseInt(tokens[1]),
                             Integer.parseInt(tokens[2]));            
        } else if (tipoOp.equals("ret")) {
            t = new Retiro(Integer.parseInt(tokens[1]),
                           Integer.parseInt(tokens[2]));   
        } else if (tipoOp.equals("trn")) {
            t = new Transferencia(Integer.parseInt(tokens[1]),
                                  Integer.parseInt(tokens[2]),
                                  Integer.parseInt(tokens[3]));
        } else if (tipoOp.equals("edc")) {
            t = new EstadoDeCuenta(Integer.parseInt(tokens[1]),out);
            
        }
        return t;
    }
    
    private void procesar() {
        String linea = "";
        try {
            while ((linea = in.readLine()) != null) {             
                Transaccion t = crearTransaccion(linea);
                Status s = banco.ejecutarTransaccion(t);
                out.println(s.toString());
            }
        } catch (IOException ioe) {
            System.err.println("Error: " + ioe);
        }
    }

    public static void main(String[] args) {
        Main m = null;

        if (args.length == 2) {
            m = new Main(args[0],args[1]);
        } else if (args.length == 0) {
           m = new Main();
        } else {
           System.err.println("Sintaxis: prog <ArchivoEntrada> " +
                   "<ArchivoSalida>");
           System.exit(-1);
        }

        m.procesar();
    }
}