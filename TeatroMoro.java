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
            System.out.println("4. Imprimir boleta (resumen)");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> reservar();
                case 2 -> modificar();
                case 3 -> comprar();
                case 4 -> boleta(); // ahora existe esta versión
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

    // Compra de entradas
    public void comprar() {
        System.out.print("Ingrese asiento a comprar: ");
        int num = sc.nextInt();

        if (asientos[num - 1] == 0 || asientos[num - 1] == 1) {
            if (asientos[num - 1] == 1) reservados--;
            asientos[num - 1] = 2;
            vendidos++;
            System.out.println("Compra realizada con éxito.");

            // Boleta individual
            boleta(num, 1); 
        } else {
            System.out.println("Ese asiento ya fue vendido.");
        }
    }

    // Boleta general que contiene el resumen de todo
    public void boleta() {
        int precio = 4000;
        int total = vendidos * precio;

        System.out.println("\n=== BOLETA GENERAL ===");
        System.out.println("Teatro: Teatro Moro");
        System.out.println("Entradas vendidas: " + vendidos);
        System.out.println("Precio unitario: $" + precio);
        System.out.println("Total acumulado: $" + total);
        System.out.println("======================\n");
    }

    // Boleta con detalle
    public void boleta(int asiento, int cantidad) {
        int precio = 4000;
        int total = cantidad * precio;

        System.out.println("\n=== BOLETA COMPRA ===");
        System.out.println("Teatro: Teatro Moro");
        System.out.println("Asiento: " + asiento);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio unitario: $" + precio);
        System.out.println("Total a pagar: $" + total);
        System.out.println("=====================\n");
    }

    public static void main(String[] args) {
        TeatroMoro app = new TeatroMoro();
        app.menu();
    }
}
