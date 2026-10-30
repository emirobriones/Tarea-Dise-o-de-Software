package Actores;

public class AgenteSoporte extends Usuario {
    private String turnoAsignado;

    public AgenteSoporte(String idUsuario, String nombre, String correo, String telefono, String turnoAsignado) {
        super(idUsuario, nombre, correo, telefono);
        this.turnoAsignado = turnoAsignado;
    }

    public void atenderReporte(String idReporte) {
        System.out.println("Agente de soporte " + nombre + " está atendiendo el reporte con ID: " + idReporte);
    }

    public void escalarReporte(String idReporte, String motivo) {
        System.out.println("Reporte " + idReporte + " escalado a administración. Motivo: " + motivo);
    }

    public String getTurnoAsignado() { return turnoAsignado; }
}