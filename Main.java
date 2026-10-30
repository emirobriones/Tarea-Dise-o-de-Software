import Asientos.*;
import Actores.*;
import Negocio.*;

import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       SISTEMA CINEMASEAT - INICIANDO PRUEBAS     ");
        System.out.println("==================================================");

        // 1. CREACIÓN DE SALAS Y ASIENTOS (Demostrando Composición y Polimorfismo)
        Sala sala1 = new Sala("SALA-01", "Sala Principal 4D & VIP", 3);
        
        // Creamos diferentes tipos de asientos polimórficos
        Asiento asiento1 = new AsientoStandar(1, 'A');
        Asiento asiento2 = new AsientoVIP(2, 'A', true, 5.00);
        Asiento4D asiento3 = new Asiento4D(3, 'A', 8.00); // Guardamos referencia para activar efectos especiales
        
        sala1.agregarAsiento(asiento1);
        sala1.agregarAsiento(asiento2);
        sala1.agregarAsiento(asiento3);

        System.out.println("\n[INFO] Sala creada: " + sala1.getNombreSala() + " con capacidad total de: " + sala1.getCapacidadTotal());

        // 2. CREACIÓN DE FUNCIONES (Agregando función asociada a la sala)
        Funcion funcionCine = new Funcion("Avengers: Secret Wars", LocalDateTime.now().plusHours(2), 10.00, sala1);
        System.out.println("[INFO] Función programada para la película: " + funcionCine.getPelicula() + " con precio base de $" + funcionCine.getPrecioBase());

        // 3. INSTANCIACIÓN DE ACTORES
        Usuario cliente = new Usuario("U-001", "Javier Romo", "javier.romo@espol.edu.ec", "0991234567");
        Administrador admin = new Administrador("A-001", "Carlos Admin", "carlos.admin@cinemaseat.com", "0999876543", 1);
        AgenteSoporte agente = new AgenteSoporte("S-001", "Lucía Soporte", "lucia.soporte@cinemaseat.com", "0984567891", "Matutino");

        // ==========================================================
        // SIMULACIÓN DE CASOS DE USO (CU-01 al CU-04)
        // ==========================================================

        // --- CASO DE USO 02: Administrar Salas y Funciones ---
        System.out.println("\n--- [CU-02] ADMINISTRACIÓN DE SALAS Y FUNCIONES ---");
        admin.gestionarInventarioSalas(sala1.getIdSala());
        System.out.println("Capacidad disponible actual en la sala: " + sala1.obtenerCapacidadDisponible() + " asientos.");

        // --- CASO DE USO 03: Ajustar Costos por Clase de Asientos (Demostrando OCP y Polimorfismo) ---
        System.out.println("\n--- [CU-03] AJUSTE DE COSTOS Y PRECIOS DIFERENCIADOS ---");
        admin.configurarPreciosAsiento("VIP", 15.00);
        admin.configurarPreciosAsiento("4D", 18.00);
        
        // Probando el cálculo polimórfico de precios para cada asiento
        System.out.println("Precio final Asiento Standard (Fila " + asiento1.getFila() + asiento1.getNumeroAsiento() + "): $" + asiento1.calcularPrecioBase(funcionCine.getPrecioBase()));
        System.out.println("Precio final Asiento VIP (Fila " + asiento2.getFila() + asiento2.getNumeroAsiento() + "): $" + asiento2.calcularPrecioBase(funcionCine.getPrecioBase()));
        
        // Activamos efectos especiales en 4D tal como dicta el diagrama de secuencia CU-03
        asiento3.activarEfectosEspeciales();
        System.out.println("Efectos especiales 4D activos: " + asiento3.isEfectosEspecialesActivos());
        System.out.println("Precio final Asiento 4D (Fila " + asiento3.getFila() + asiento3.getNumeroAsiento() + "): $" + asiento3.calcularPrecioBase(funcionCine.getPrecioBase()));

        // --- CASO DE USO 01: Adquirir el Boleto y Temporizador ---
        System.out.println("\n--- [CU-01] PROCESO DE ADQUISICIÓN DE BOLETOS ---");
        
        // El cliente selecciona el Asiento VIP (asiento2)
        cliente.seleccionarAsiento("A2 (VIP)");
        
        if (asiento2.verificarDisponibilidad()) {
            // Cambiamos el estado a EN_PROCESO según el diagrama de secuencia CU-01
            asiento2.actualizarEstado(EstadoAsiento.EN_PROCESO);
            System.out.println("Estado del asiento actualizado a: " + asiento2.getEstado());

            // Iniciamos el temporizador de reserva de 5 minutos
            TemporizadorReserva temporizador = new TemporizadorReserva(5);
            temporizador.iniciarTemporizador("A2");

            // Simulación del pago aprobado
            double montoPagar = asiento2.calcularPrecioBase(funcionCine.getPrecioBase());
            boolean pagoExitoso = cliente.realizarPago(montoPagar);

            if (pagoExitoso) {
                // Actualizamos a RESERVADO y generamos el boleto
                asiento2.actualizarEstado(EstadoAsiento.RESERVADO);
                Boleto boletoGenerado = new Boleto(montoPagar);
                System.out.println("[ÉXITO] ¡Pago aprobado! Estado final del asiento: " + asiento2.getEstado());
                System.out.println("Boleto generado exitosamente. Monto total pagado: $" + boletoGenerado.getMontoTotal());

                // Envío de notificación de confirmación
                Notificacion noti = new Notificacion("Su compra para " + funcionCine.getPelicula() + " ha sido confirmada con éxito.", "2026-10-30 20:30");
                noti.enviarNotificacion(cliente);
            }
        }

        // --- CASO DE USO 04: Informar Inconvenientes con la Compra ---
        System.out.println("\n--- [CU-04] GESTIÓN DE SOPORTE E INCIDENCIAS ---");
        ReporteSoporte reporte = new ReporteSoporte("REP-9988", "El pago se descontó pero el boleto no se generó visualmente.");
        reporte.registrarReporte();

        // El agente de soporte toma el caso
        agente.atenderReporte(reporte.getIdReporte());
        reporte.actualizarEstadoReporte("En Atencion", "Verificando pasarela de pagos.");

        // Simulando que el agente requiere escalarlo al administrador
        agente.escalarReporte(reporte.getIdReporte(), "Requiere validación de reembolso por administración.");
        
        // El admin resuelve el caso
        reporte.actualizarEstadoReporte("Resuelto por Administrador", "Reembolso y reasignación de asiento aprobados.");

        System.out.println("\n==================================================");
        System.out.println("      PRUEBAS FINALIZADAS EXITOSAMENTE          ");
        System.out.println("==================================================");
    }
}