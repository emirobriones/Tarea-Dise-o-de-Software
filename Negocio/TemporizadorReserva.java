package Negocio;

import Asientos.Asiento;
import Asientos.EstadoAsiento;
import java.time.LocalTime;

// Clase que representa un temporizador para la reserva de asientos en una función de cine.

public class TemporizadorReserva {
    private int tiempoLimiteMinutos;
    private LocalTime horaExpiracion;

    public TemporizadorReserva(int tiempoLimiteMinutos) {
        this.tiempoLimiteMinutos = tiempoLimiteMinutos;
    }

    // Método para iniciar el temporizador de reserva para un asiento específico

    public void iniciarTemporizador(String idAsiento) {
        this.horaExpiracion = LocalTime.now().plusMinutes(tiempoLimiteMinutos);
        System.out.println("Temporizador iniciado de " + tiempoLimiteMinutos + " minutos para el asiento ID: " + idAsiento);
        System.out.println("Expira a las: " + horaExpiracion);
    }
    
    // Método para verificar si el tiempo de reserva ha expirado

    public void expirarReserva(Asiento asiento) {
        asiento.actualizarEstado(EstadoAsiento.DISPONIBLE);
        System.out.println("El tiempo ha expirado. El asiento ha sido liberado.");
    }
}