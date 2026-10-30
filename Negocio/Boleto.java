package Negocio;

public class Boleto {
    private double montoTotal;

    public Boleto(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    // Getter
    
    public double getMontoTotal() {
        return montoTotal;
    }
}
