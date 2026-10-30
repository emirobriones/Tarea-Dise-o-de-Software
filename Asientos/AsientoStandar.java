package Asientos;

//el siento standar es el asiento base, no tiene recargos ni beneficios adicionales,
// solo cumple con la función de sentarse y ver la película

public class AsientoStandar extends Asiento {
    private String descripcionClasica;

    public AsientoStandar(int numeroAsiento, char fila) {
        super(numeroAsiento, fila);
        this.descripcionClasica = "Experiencia clásica de cine";
    }

    // Implementación del método abstracto para calcular el precio base del asiento estándar
    
    @Override
    public double calcularPrecioBase(double precioFuncion) {
        // El asiento estándar mantiene el precio base de la función
        return precioFuncion;
    }

    // Getters

    public String getDescripcionClasica() { return descripcionClasica; }
}