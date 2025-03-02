import java.util.Random;
import java.util.Scanner;

/**
 * Clase principal del juego "Piedra, Papel o Tijera".
 * Este juego permite que el usuario juegue contra la computadora,
 * mostrando los resultados y actualizando los puntajes.
 */
public class ppt {
    public static Scanner input = new Scanner(System.in);  // Scanner para capturar las entradas del usuario.
    public static Random random = new Random();  // Generador de números aleatorios para la computadora.

    /**
     * Método principal donde se inicia el juego.
     * Llama al método `piedrapapeltijera` y muestra el resultado final.
     *
     */
    public static void main(String[] args) {
        // Llamamos al método piedrapapeltijera desde el main y mostramos el resultado
        String resultado = piedrapapeltijera();
        System.out.println(resultado);
    }

    /**
     * Método que simula el juego de Piedra, Papel o Tijera entre el usuario y la computadora.
     * El juego se repite hasta que el usuario decide salir.
     *
     * @return String que indica el estado final del juego, como "Juego terminado." cuando el usuario decide salir.
     */
    public static String piedrapapeltijera() {
        System.out.println("Bienvenido al mejor juego de piedra, papel o tijera");
        int puntajeUsuario = 0;  // Puntaje del usuario.
        int puntajeComputadora = 0;  // Puntaje de la computadora.

        // Bucle que repite el juego hasta que el usuario decida salir.
        while (true) {
			/** @param El usuario selecciona una de las opciones: 1. Piedra, 2. Papel, 3. Tijera, o 0 para salir.
			 * @return No retorna valor, solo muestra el menú en consola.
			 */
            System.out.println("Elige una de las siguientes opciones:");
            System.out.println("1. Piedra");
            System.out.println("2. Papel");
            System.out.println("3. Tijera");
            System.out.println("0. Salir del juego");

            int eleccionUsuario = input.nextInt();  // Entrada del usuario (piedra, papel o tijera)
            input.nextLine();  // Limpiar el buffer del scanner para evitar problemas de lectura.
            String opcionUsuario;  // Variable para almacenar la opción del usuario como texto.

            /**
             * Proceso para seleccionar la opción del usuario.
             *
             * @param eleccionUsuario Opción seleccionada por el usuario (número entre 1 y 3).
             * @return Se asigna el texto correspondiente a la opción seleccionada.
             */
            switch (eleccionUsuario) {
                case 0:
                    opcionUsuario = "Saliendo del programa.";
                    return opcionUsuario; // Devuelve el mensaje y termina el juego.

                case 1:
                    opcionUsuario = "Elegiste Piedra.";
                    break;

                case 2:
                    opcionUsuario = "Elegiste Papel.";
                    break;

                case 3:
                    opcionUsuario = "Elegiste Tijera.";
                    break;

                default:
                    opcionUsuario = "Opción inválida. Intenta de nuevo.";
                    break;
            }

            // Solo se muestra la opción elegida, no el menú completo.
            System.out.println(opcionUsuario);

            /**
             * Elección de la computadora (número aleatorio entre 1 y 3).
             *
             * @param No recibe parámetros.
             * @return Un valor aleatorio entre 1 y 3 representando Piedra, Papel o Tijera.
             */
            int eleccionComputadora = random.nextInt(3) + 1;  // El valor de la computadora es numérico (1-3)
            String opcionComputadora = "";  // La opción de la computadora se maneja como texto para mostrarla.

            /**
             * Proceso para determinar qué eligió la computadora.
             *
             * @param eleccionComputadora Opción aleatoria entre 1 y 3.
             * @return Asigna el texto correspondiente a la opción seleccionada por la computadora.
             */
            switch (eleccionComputadora) {
                case 1:
                    opcionComputadora = "La computadora eligió Piedra \n";
                    break;
                case 2:
                    opcionComputadora = "La computadora eligió Papel \n";
                    break;
                case 3:
                    opcionComputadora = "La computadora eligió Tijera \n ";
                    break;
            }
            System.out.println(opcionComputadora);  // Mostrar la elección de la computadora.

            /**
             * Si la opción elegida es 0, el programa terminará y no volverá a preguntar.
             *
             * @param eleccionUsuario La elección del usuario (0 para salir).
             * @return No retorna valor, solo termina el juego.
             */
            if (eleccionUsuario == 0) {
                break;  // Salir del ciclo.
            } else {
                /**
                 * Comparar las elecciones del usuario y la computadora.
                 *
                 * @param eleccionUsuario La elección del usuario (1: Piedra, 2: Papel, 3: Tijera).
                 * @param eleccionComputadora La elección de la computadora (1: Piedra, 2: Papel, 3: Tijera).
                 * @return Aumenta el puntaje del usuario o de la computadora según el resultado.
                 */
                if ((eleccionUsuario == 1 && eleccionComputadora == 3) ||
                    (eleccionUsuario == 2 && eleccionComputadora == 1) ||
                    (eleccionUsuario == 3 && eleccionComputadora == 2)) {
                    puntajeUsuario += 1;  // Aumenta el puntaje del usuario si gana.
                    System.out.println("¡GANASTE!");
                } else if (eleccionUsuario == eleccionComputadora) {
                    System.out.println("EMPATE");
                } else {
                    puntajeComputadora += 1;  // Aumenta el puntaje de la computadora si gana.
                    System.out.println("PERDISTE :(");
                }
            }

            /**
             * Muestra el puntaje actual después de cada ronda.
             *
             * @param puntajeUsuario El puntaje del usuario.
             * @param puntajeComputadora El puntaje de la computadora.
             * @return No retorna valor, solo muestra el puntaje actual.
             */
            System.out.println("Puntaje del Usuario: " + puntajeUsuario + "\n");
            System.out.println("Puntaje de la Computadora: " + puntajeComputadora + "\n");
        }

        /**
         * Al finalizar el juego, devuelve un mensaje de fin.
         *
         * @return String indicando que el juego ha terminado, como "Juego terminado."
         */
        return "Juego terminado.";  // Mensaje de fin del juego.
    }
}


