/**
 *
 * @author victor
 */
public class Transferencia extends Transaccion {

    // Modelo de representacion (atributos):
    private int ctaOrigen;
    private int ctaDestino;
    private int monto;

    // Operaciones:

    Transferencia(int orig, int dest, int mont) {
        this.ctaDestino = dest;
        this.ctaOrigen = orig;
        this.monto = mont;
    }

    @Override
    public void ejecutar(Banco banco) throws Status {
        banco.hacerTransferencia(this);
    }

    @Override
    public String toString() {
        String s;
        s = "trn " + this.ctaOrigen + " " + this.ctaDestino + " " + this.monto;
        return s;
    }

    public int obtCtaOrigen() {
        return this.ctaOrigen;
    }
    
    public int obtCtaDestino() {
        return this.ctaDestino;
    }

    public int obtMonto() {
        return this.monto;
    }
}
