package cFilPrincipal;   // Paquete donde está la clase principal

// Importa la clase cFil del otro paquete
import cFil.cFil;

public class cFilPrincipal {

    // Método principal: aquí empieza el programa
    public static void main(String[] pArguments) {

        // Mensajes iniciales
        System.out.println("Fil principal iniciat.");
        System.out.println("Fil secundari iniciat.");

        // Crea el objeto que contiene la tarea del hilo
        cFil vObjecteFil = new cFil("#1");

        // Crea el hilo real y le pasa la tarea
        Thread vFil = new Thread(vObjecteFil);

        // Inicia el hilo secundario
        // Esto ejecuta el método run() de cFil
        vFil.start();

        // El hilo principal sigue ejecutándose
        System.out.println("Iniciant execució procés principal");

        try {

            // Bucle del hilo principal
            for (int vComptador = 0; vComptador < 10; vComptador++) {

                // Espera 500 ms
                Thread.sleep(500);

                // Imprime mensaje
                System.out.println(
                    "Despertant aturada " +
                    vComptador +
                    " procès principal"
                );
            }

        }
        catch (InterruptedException pExcepcio) {

            // Si el hilo principal es interrumpido
            System.out.println(
                "Interrompent execució procès principal"
            );
        }

        // Final del hilo principal
        System.out.println(
            "Acabant execució procès principal"
        );
    }
}
