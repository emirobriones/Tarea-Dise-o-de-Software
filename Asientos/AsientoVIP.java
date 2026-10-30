package Asientos;

//el asiento VIP ofrece beneficios adicionales,
// como espacio extra y recargos exclusivos

public class AsientoVIP extends Asiento {
    private boolean espacioExtra;
    private double recargoVIP;

    public AsientoVIP(int numeroAsiento, char fila, boolean espacioExtra, double recargoVIP) {
        super(numeroAsiento, fila);
        this.espacioExtra = espacioExtra;
        this.recargoVIP = recargoVIP;
    }

    // Implementación del método abstracto para calcular el precio base del asiento VIP

    @Override
    public double calcularPrecioBase(double precioFuncion) {
        // Suma el precio de la función más el recargo exclusivo VIP
        return precioFuncion + recargoVIP;
    }

    // Getters

    public boolean isEspacioExtra() { return espacioExtra;}
    public double getRecargoVIP() {return recargoVIP; }

}