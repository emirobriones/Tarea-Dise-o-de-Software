package Actores;

public class Administrador extends Usuario {
    private int nivelAcceso;

    public Administrador(String idUsuario, String nombre, String correo, String telefono, int nivelAcceso) {
        super(idUsuario, nombre, correo, telefono);
        this.nivelAcceso = nivelAcceso;
    }

    public void configurarPreciosAsiento(String tipoAsiento, double nuevoPrecio) {
        System.out.println("Administrador " + nombre + " actualizó el precio de los asientos " + tipoAsiento + " a $" + nuevoPrecio);
    }

    public void gestionarInventarioSalas(String idSala) {
        System.out.println("Administrador " + nombre + " gestionando el inventario de la sala: " + idSala);
    }

    public int getNivelAcceso() { return nivelAcceso; }
}