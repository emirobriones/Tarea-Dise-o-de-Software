package Negocio;

import Asientos.Asiento;
import java.util.ArrayList;
import java.util.List;

// Clase que representa una sala de cine, que contiene asientos y tiene una capacidad total.

public class Sala {
    private String idSala;
    private String nombreSala;
    private int capacidadTotal;
    private List<Asiento> asientos; // la sala contiene asientos

    public Sala(String idSala, String nombreSala, int capacidadTotal) {
        this.idSala = idSala;
        this.nombreSala = nombreSala;
        this.capacidadTotal = capacidadTotal;
        this.asientos = new ArrayList<>();
    }

    // Método para agregar un asiento a la sala

    public void agregarAsiento(Asiento asiento) {
        this.asientos.add(asiento);
    }

    // Método para obtener la capacidad disponible de la sala,
    // contando los asientos disponibles

    public int obtenerCapacidadDisponible() {
        int contador = 0;
        for (Asiento a : asientos) {
            if (a.verificarDisponibilidad()) {
                contador++;
            }
        }
        return contador;
    }

    // Getters
    public String getIdSala() { return idSala; }
    public String getNombreSala() { return nombreSala; }
    public int getCapacidadTotal() { return capacidadTotal; }
    public List<Asiento> getAsientos() { return asientos; }
}