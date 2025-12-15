package cFilPrincipal;

import cFil.cFil;
import java.util.Scanner;

public class cFilPrincipal {

  public static void main (String [] pArguments) {

    System.out.println("Fil principal iniciat.");
    System.out.println("Fil secundari iniciat.");

    // Nombre màxim de processos fills permès
    final int MAX_FILLS = 10;

    // L’usuari indica quants processos fills vol crear
    Scanner sc = new Scanner(System.in);
    int numFills = sc.nextInt();

    // Es comprova que el nombre estigui dins del límit
    if (numFills < 1 || numFills > MAX_FILLS) {
      System.out.println("Nombre de processos no permès.");
      return;
    }

    // Array per guardar tots els fils fills
    Thread[] vFils = new Thread[numFills];

    cFil vObjecteFil = new cFil("#1");

    // El primer procés fill té la temporització més petita
    vObjecteFil.setTemps(200);

    //alternativa: innecessari
    Thread vFil = new Thread(vObjecteFil);

    // Es guarda el primer fil dins l’array
    vFils[0] = vFil;

    //alternativa: vObjecteFil
    vFil.start();

    // Es creen i s’executen la resta de processos fills amb temporització creixent
    for (int i = 1; i < numFills; i++) {

      cFil vObjecteFilExtra = new cFil("#" + (i + 1));
      vObjecteFilExtra.setTemps(200 + (i * 200));

      Thread vFilExtra = new Thread(vObjecteFilExtra);
      vFils[i] = vFilExtra;
      vFilExtra.start();
    }

    System.out.println("Iniciant execució procés principal");

    try {

      for (int vComptador = 0; vComptador < 10; vComptador++) {
        Thread.sleep(500);
        System.out.println("Despertant aturada " + vComptador + " procès principal");
      }

      // El procés principal espera que tots els processos fills hagin finalitzat
      for (int i = 0; i < numFills; i++) {
        vFils[i].join();
      }

    } catch (InterruptedException pExcepcio) {
      System.out.println("Interrompent execució procès principal");
    }

    System.out.println("Acabant execució procès principal");
  }
}
