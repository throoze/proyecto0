abstract public class Transaccion {

    abstract public void ejecutar(Banco banco) throws Status;
    abstract public String toString();

}

