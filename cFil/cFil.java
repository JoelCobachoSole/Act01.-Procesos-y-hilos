package cFil;   // Indica el paquete al que pertenece la clase

// Alternativa a "extends Thread":
// aquí usamos "implements Runnable" para que la clase pueda ejecutarse como hilo
public class cFil implements Runnable {

    // Nombre identificativo del hilo/proceso
    String aNomFil;

    // Tiempo de espera entre ejecuciones (en milisegundos)
    int aTemporitzacio;

    // Constructor: recibe el nombre del hilo
    public cFil(String pNomFil) {

        // Tiempo por defecto = 500 ms
        aTemporitzacio = 500;

        // Guarda el nombre recibido
        aNomFil = pNomFil;
    }

    // Getter: devuelve el nombre del hilo
    public String gNomFil() {
        return aNomFil;
    }

    // Setter: cambia el tiempo de espera
    public void sTemporitzacio(int pTemporitzacio) {
        aTemporitzacio = pTemporitzacio;
    }

    // Método que ejecutará el hilo
    // Es obligatorio al implementar Runnable
    public void run() {

        // Mensaje inicial
        System.out.println("Iniciant execució procés " + aNomFil);

        try {

            // Bucle que se repite 10 veces
            for (int vComptador = 0; vComptador < 10; vComptador++) {

                // Pausa el hilo durante el tiempo indicado
                Thread.sleep(aTemporitzacio);

                // Muestra el número de iteración
                System.out.println(
                    "Despertant aturada " + vComptador +
                    " procès " + aNomFil
                );
            }

        }
        // Captura la excepción si el hilo es interrumpido
        catch (InterruptedException pExcepcio) {

            System.out.println(
                "Interrompent execució procès " + aNomFil
            );
        }

        // Mensaje final al terminar
        System.out.println(
            "Acabant execució procès " + aNomFil
        );
    }
}
