package Negocio;

// Clase que representa un reporte de soporte técnico, con un ID, descripción y estado.

public class ReporteSoporte {
    private String idReporte;
    private String descripcion;
    private String estadoReporte; // "Pendiente", "En Atencion", "Resuelto"

    public ReporteSoporte(String idReporte, String descripcion) {
        this.idReporte = idReporte;
        this.descripcion = descripcion;
        this.estadoReporte = "Pendiente";
    }

    // Método para registrar el reporte de soporte, mostrando un mensaje de confirmación

    public void registrarReporte() {
        System.out.println("Reporte con ID " + idReporte + " registrado exitosamente. Estado: " + estadoReporte);
    }

    // Método para actualizar el estado del reporte, mostrando un mensaje de confirmación
    
    public void actualizarEstadoReporte(String nuevoEstado, String motivo) {
        this.estadoReporte = nuevoEstado;
        System.out.println("Reporte " + idReporte + " actualizado a estado: " + estadoReporte + ". Motivo/Detalle: " + motivo);
    }

    // Getters
    public String getIdReporte() { return idReporte; }
    public String getDescripcion() { return descripcion; }
    public String getEstadoReporte() { return estadoReporte; }
}