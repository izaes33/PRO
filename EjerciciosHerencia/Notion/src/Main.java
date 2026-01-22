import controller.Centralita;
import model.Llamada;
import model.LlamadaLocal;
import model.LlamadaNacional;
import model.LlamadaProvincial;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;
        Centralita centralita = new Centralita();

        do {
            System.out.println("1. Registrar llamada");
            System.out.println("2. Mostrar llamadas");
            System.out.println("3. Mostrar caja");
            System.out.println("4. Salir");
            System.out.println("Que quieres hacer");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Indica que llamada quieres registrar: ");
                    System.out.println("1-Local");
                    System.out.println("2-Provincial");
                    System.out.println("3-Nacional");
                    int tipo = sc.nextInt();

                    System.out.println("Indica nOrigen: ");
                    long nOrigen = sc.nextLong();
                    System.out.println("Indica nDestino: ");
                    long nDestino = sc.nextLong();
                    System.out.println("Indica duracion: ");
                    int duracion = sc.nextInt();

                    Llamada llamada = null;

                    switch (tipo) {
                        case 1 -> llamada = new LlamadaLocal(nOrigen, nDestino, duracion);
                        case 2 -> llamada = new LlamadaProvincial(nOrigen, nDestino, duracion);
                        case 3 -> {
                            System.out.println("Indica franja");
                            int franja = sc.nextInt();
                            llamada = new LlamadaNacional(nOrigen, nDestino, duracion, franja);
                        }
                        default -> System.out.println("Tipo de llamada invalido");
                    }

                    if (llamada != null) {
                        centralita.registrarLlamada(llamada);
                    }
                }
                case 2 -> centralita.mostrarDatosLlamadas();
                case 3 -> centralita.mostrarCaja();
                case 4 -> System.out.println("Saliendo");
                default -> System.out.println("Opcion invalida");
            }

        } while (opcion != 4);
    }
}
