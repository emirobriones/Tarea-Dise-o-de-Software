package Negocio;

import Asientos.Asiento;
import java.time.LocalDateTime;
import java.util.List;

// Clase que representa una función de cine, que tiene una película, un horario,
// un precio base y está asociada a una sala.

public class Funcion {
    private String pelicula;
    private LocalDateTime horario;
    private double precioBase;
    private Sala sala; // Agregación con Sala

    public Funcion(String pelicula, LocalDateTime horario, double precioBase, Sala sala) {
        this.pelicula = pelicula;
        this.horario = horario;
        this.precioBase = precioBase;
        this.sala = sala;
    }

    // Método para consultar la disponibilidad de asientos en la sala asociada a la función
    
    public List<Asiento> consultarDisponibilidadSala() {
        System.out.println("Consultando asientos disponibles para la función de: " + pelicula);
        return sala.getAsientos();
    }

    // Getters
    public String getPelicula() { return pelicula; }
    public LocalDateTime getHorario() { return horario; }
    public double getPrecioBase() { return precioBase; }
    public Sala getSala() { return sala; }
    
    // Setters
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
}