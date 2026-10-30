package Nucleo;

//el asiento 4D ofrece una experiencia inmersiva con efectos especiales,
// y tiene un recargo adicional por esta característica

public class Asiento4D extends Asiento {
    private boolean efectosEspecialesActivos;
    private double recargo4D;

    public Asiento4D(int numeroAsiento, char fila, double recargo4D) {
        super(numeroAsiento, fila);
        this.efectosEspecialesActivos = false; // Inicia inactivo hasta que se requiera
        this.recargo4D = recargo4D;
    }

    public void activarEfectosEspeciales() {
        this.efectosEspecialesActivos = true;
    }

    // Implementación del método abstracto para calcular el precio base del asiento 4D

    @Override
    public double calcularPrecioBase(double precioFuncion) {
        // Suma el precio de la función más el recargo por efectos 4D
        return precioFuncion + recargo4D;
    }

    // Getters

    public boolean isEfectosEspecialesActivos() { return efectosEspecialesActivos;}
    public double getRecargo4D() { return recargo4D; }

}