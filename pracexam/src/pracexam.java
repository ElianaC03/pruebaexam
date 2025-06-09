import java.util.Scanner;

public class pracexam {


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // 1. Cuántos puestos de control
            System.out.print("¿Cuántos puestos de control hay? ");
            int numPuestos = scanner.nextInt();
            scanner.nextLine(); // limpiar el buffer

            // 2. Cuántos chapulines commit esto
            System.out.print("¿Cuántos chapulines competirán? ");
            int numChapulines = scanner.nextInt();
            scanner.nextLine();

            // 3. Crear vectores y matriz
            String[] puestosControl = new String[numPuestos];
            String[] chapulines = new String[numChapulines];
            int[][] tiempos = new int[numChapulines][numPuestos];

            // 4. Nombres de puestos de control
            for (int i = 0; i < numPuestos; i++) {
                System.out.print("Nombre del puesto de control #" + (i + 1) + ": ");
                puestosControl[i] = scanner.nextLine();
            }

            // 5. Nombres de chapulines
            for (int i = 0; i < numChapulines; i++) {
                System.out.print("Nombre del Chapulín #" + (i + 1) + ": ");
                chapulines[i] = scanner.nextLine();
            }

            // 6. Iniciar el rally
            System.out.println("\n🏁 ¡Inicio del Rally!\n");

            for (int i = 0; i < numChapulines; i++) {
                for (int j = 0; j < numPuestos; j++) {
                    System.out.println("Chapulín: " + chapulines[i] + " - Puesto de control: " + puestosControl[j]);
                    System.out.print("Ingrese el tiempo (en minutos): ");
                    tiempos[i][j] = scanner.nextInt();
                }
            }

            // 7. Calcular tiempos totales y encontrar ganador
            int[] tiemposTotales = new int[numChapulines];
            int menorTiempo = Integer.MAX_VALUE;
            int indiceGanador = -1;

            System.out.println("\n⏱️ Resultados finales:");
            for (int i = 0; i < numChapulines; i++) {
                int suma = 0;
                for (int j = 0; j < numPuestos; j++) {
                    suma += tiempos[i][j];
                }
                tiemposTotales[i] = suma;
                System.out.println("Chapulín: " + chapulines[i] + " - Tiempo total: " + suma + " minutos");

                if (suma < menorTiempo) {
                    menorTiempo = suma;
                    indiceGanador = i;
                }
            }

            // 8. Mostrar ganador
            System.out.println("\n🏆 ¡Ganador del Rally!");
            System.out.println("Chapulín: " + chapulines[indiceGanador] + " con " + menorTiempo + " minutos.");
        }
    }
