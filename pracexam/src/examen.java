import java.util.Scanner;

public class examen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Paso 1: Cantidad de puestos de control
        System.out.print("Ingrese la cantidad de puestos de control: ");
        int cantidadPuestos = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        String[] puestos = new String[cantidadPuestos];
        for (int i = 0; i < cantidadPuestos; i++) {
            System.out.print("Nombre del puesto de control #" + (i + 1) + ": ");
            puestos[i] = scanner.nextLine();
        }

        // Paso 2: Cantidad de chapulines
        System.out.print("Ingrese la cantidad de chapulines: ");
        int cantidadChapulines = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        String[] chapulines = new String[cantidadChapulines];
        for (int i = 0; i < cantidadChapulines; i++) {
            System.out.print("Nombre del Chapulín #" + (i + 1) + ": ");
            chapulines[i] = scanner.nextLine();
        }

        // Paso 3: Matriz de tiempos
        int[][] tiempos = new int[cantidadChapulines][cantidadPuestos];

        // Paso 4: Llenar matriz con tiempos
        for (int i = 0; i < cantidadChapulines; i++) {
            for (int j = 0; j < cantidadPuestos; j++) {
                System.out.print("Minutos para " + chapulines[i] + " en " + puestos[j] + ": ");
                tiempos[i][j] = scanner.nextInt();
            }
        }

        // Paso 5: Calcular tiempos totales y determinar el ganador
        int[] tiemposTotales = new int[cantidadChapulines];
        int menorTiempo = Integer.MAX_VALUE;
        int indiceGanador = -1;

        for (int i = 0; i < cantidadChapulines; i++) {
            int suma = 0;
            for (int j = 0; j < cantidadPuestos; j++) {
                suma += tiempos[i][j];
            }
            tiemposTotales[i] = suma;
            if (suma < menorTiempo) {
                menorTiempo = suma;
                indiceGanador = i;
            }
        }

        // Paso 6: Mostrar resultados
        System.out.println("\nCompetidores\t" + String.join("\t", puestos) + "\tTiempo\tResultado");

        for (int i = 0; i < cantidadChapulines; i++) {
            System.out.print(chapulines[i] + "\t");
            for (int j = 0; j < cantidadPuestos; j++) {
                System.out.print(String.format("%02d", tiempos[i][j]) + "\t");
            }
            System.out.print(tiemposTotales[i] + "\t");
            if (i == indiceGanador) {
                System.out.println("Ganador");
            } else {
                System.out.println("---");
            }
        }

        scanner.close();
    }
}
