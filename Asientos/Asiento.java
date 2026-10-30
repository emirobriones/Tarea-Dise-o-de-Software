package Nucleo;

//Superclase Asiento con comportamientos bases

public abstract class Asiento {
    protected int numeroAsiento;
    protected char fila;
    protected EstadoAsiento estado;

    public Asiento(int numeroAsiento, char fila) {
        this.numeroAsiento = numeroAsiento;
        this.fila = fila;
        this.estado = EstadoAsiento.DISPONIBLE; // Todo asiento nace disponible
    }

    public boolean verificarDisponibilidad() {
        return this.estado == EstadoAsiento.DISPONIBLE;
    }

    // Metodo para cambiar el estado de un asiento, al comprarlo


    public void actualizarEstado(EstadoAsiento nuevoEstado) {
        this.estado = nuevoEstado;
    }

    // Metodo abstracto que las subclases (Standard, VIP, 4D) obligatoriamente implementaran
    
    public abstract double calcularPrecioBase(double precioFuncion);

    // Getters

    public int getNumeroAsiento() { return numeroAsiento; }

    public char getFila() { return fila; }

    public EstadoAsiento getEstado() { return estado; }
}