package negocio;


public class Habitacion {
    private int numh;
    private String tipo;
    private double pre;

    public Habitacion() {
    }

    public Habitacion(int numh, String tipo, double pre) {
        this.numh = numh;
        this.tipo = tipo;
        this.pre = pre;
    }

    public int getNumh() {
        return numh;
    }

    public void setNumh(int numh) {
        this.numh = numh;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPre() {
        return pre;
    }

    public void setPre(double pre) {
        this.pre = pre;
    }

    
}