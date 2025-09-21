/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author franc
 */
import java.util.Scanner;

public class TeatroMoro {
    // Variables estáticas
    static int totalAsientos = 10;
    static int reservados = 0;
    static int vendidos = 0;

    // Variables de instancia
    int[] asientos = new int[totalAsientos]; // 0=libre, 1=reservado, 2=vendido

    Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ TEATRO MORO ---");
            System.out.println("1. Reservar asiento");
            System.out.println("2. Modificar reserva");
            System.out.println("3. Comprar entrada");
            System.out.println("4. Imprimir boleta");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> reservar();
                case 2 -> modificar();
                case 3 -> comprar();
                case 4 -> boleta();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }

    // Reservar asiento
    public void reservar() {
        System.out.print("Ingrese número de asiento (1-10): ");
        int num = sc.nextInt(); // variable local
        if (asientos[num - 1] == 0) {
            asientos[num - 1] = 1;
            reservados++;
            System.out.println("Asiento reservado.");
        } else {
            System.out.println("Asiento no disponible.");
        }
    }

    // Modificar reserva
    public void modificar() {
        System.out.print("Ingrese asiento reservado que desea cambiar: ");
        int viejo = sc.nextInt();
        if (asientos[viejo - 1] == 1) {
            System.out.print("Ingrese nuevo asiento: ");
            int nuevo = sc.nextInt();
            if (asientos[nuevo - 1] == 0) {
                asientos[viejo - 1] = 0;
                asientos[nuevo - 1] = 1;
                System.out.println("Reserva cambiada.");
            } else {
                System.out.println("El nuevo asiento no está disponible.");
            }
        } else {
            System.out.println("El asiento indicado no estaba reservado.");
        }
    }

    // Comprar entrada
    public void comprar() {
        System.out.print("Ingrese asiento a comprar: ");
        int num = sc.nextInt();
        if (asientos[num - 1] == 0 || asientos[num - 1] == 1) {
            if (asientos[num - 1] == 1) reservados--;
            asientos[num - 1] = 2;
            vendidos++;
            System.out.println("Compra realizada con éxito.");
        } else {
            System.out.println("Ese asiento ya fue vendido.");
        }
    }

    // Imprimir boleta
    public void boleta() {
        System.out.println("=== BOLETA ===");
        System.out.println("Teatro: Teatro Moro");
        System.out.println("Entradas vendidas: " + vendidos);
        int precio = 4000;
        System.out.println("Total: $" + (vendidos * precio));
    }

    public static void main(String[] args) {
        TeatroMoro app = new TeatroMoro();
        app.menu();
    }
}
