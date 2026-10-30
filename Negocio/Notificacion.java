package Negocio;

import Actores.Usuario;

// Clase que representa una notificación que puede ser enviada a un usuario,
// con un mensaje y una fecha/hora de envío.

public class Notificacion {
    private String mensaje;
    private String fechaHoraEnvio;

    public Notificacion(String mensaje, String fechaHoraEnvio) {
        this.mensaje = mensaje;
        this.fechaHoraEnvio = fechaHoraEnvio;
    }

    // Método para enviar la notificación a un usuario específico,
    // mostrando un mensaje de confirmación

    public void enviarNotificacion(Usuario usuario) {
        System.out.println("Enviando notificación a " + usuario.getCorreo() + " / Teléfono: " + usuario.getTelefono());
        System.out.println("Mensaje: " + mensaje + " [Enviado a las: " + fechaHoraEnvio + "]");
    }
}