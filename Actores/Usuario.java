package Actores;

// Clase Usuario que representa a un usuario del sistema de cine

public class Usuario {
    protected String idUsuario;
    protected String nombre;
    protected String correo;
    protected String telefono;

    public Usuario(String idUsuario, String nombre, String correo, String telefono) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public void seleccionarAsiento(String idAsiento) {
        
        // Lógica para registrar la selección del asiento

        System.out.println(nombre + " ha seleccionado el asiento con ID: " + idAsiento);
    }

    public boolean realizarPago(double monto) {
        
        // Simulación del procesamiento del pago

        System.out.println("Procesando pago por un monto de: $" + monto);
        return true; 
        
        // Asumimos pago exitoso por defecto para la simulación
    }

    // Getters
    public String getIdUsuario() { return idUsuario; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
}