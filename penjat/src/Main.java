import java.util.Random;
/**
 * @author isaacruiiiz
 * @verion 1.0
 * @param introduceString
 * @param menu
 * @param buscarParaula
 * @param reemplazarString
 */

public class Main {

    public static void main(String[] args) {
        String[] palabras = arrayPalabras();
        adivinarPalabras(palabras);
    }

    private static void adivinarPalabras(String[] palabras) {
        String acertado;
        int sucesionPal = 0;
        int errores = 0;
        int vidas = 6;
        boolean restaVida;
        int posicion = 0;
        char[] arrayB = new char[25];
        Random r = new Random();
        posicion = r.nextInt(palabras.length);
        char letra;
        char arrayA[] = new char[palabras[posicion].length()];
        for (int i = 0; i < palabras[posicion].length(); i++) {
            arrayA[i] = '_';
        }
        System.out.println(arrayA);
        do {
            System.out.println("Introdueix una lletra: ");
            letra = Teclat.llegirChar();
            restaVida = true;
            for (int j = 0; j < palabras[posicion].length(); j++) {
                if (letra == palabras[posicion].charAt(j)) {
                    arrayA[j] = letra;
                    restaVida = false;
                }
            }
            if (restaVida == true) {
                vidas = vidas - 1;
                dibujos(vidas);
            }
            System.out.println(arrayA);
            letrasUsadas(letra,sucesionPal,arrayB);
            sucesionPal++;
            acertado = String.valueOf(arrayA);
        }
        while (vidas > 0 && !acertado.equalsIgnoreCase(palabras[posicion]));
        if (vidas == 0) {
            System.out.println("Has muerto");
        }
        if (acertado.equalsIgnoreCase(palabras[posicion])) {
            System.out.println("Has ganado");
        }

    }


    public static String[] arrayPalabras() {
        String[] palabras = {"perro", "mierda", "dinosaurio", "teclado", "galleta", "camiseta", "telefono", "cable", "leopardo", "lapiz", "raton", "botella", "ventana", "pollo", "jabon", "pastel", "lagarto", "lentejas", "cacahuete", "chocolate", "hoja", "papelera", "tortuga", "casa", "relampago", "arbol", "arbusto", "letra", "palabra", "procesador"};

        return palabras;
    }

    public static void dibujos(int vidas) {
        if (vidas == 5) {
            System.out.println("  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========");
        }
        if (vidas == 4) {
            System.out.println("+---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========");
        }
        if (vidas == 3) {
            System.out.println(" +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========");
        }
        if (vidas == 2) {
            System.out.println(" +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========");
        }
        if (vidas == 1) {
            System.out.println("  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========");
        }
        if (vidas == 0) {
            System.out.println(" +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "=========");
        }
    }
    public static void letrasUsadas(char letra, int sucesionPal, char[] arrayB) {
        arrayB[sucesionPal] = letra;
        System.out.println("Has introducido las letras: ");
        for (int i = 0; i <= sucesionPal; i++)
        {
            System.out.print(arrayB[i] + ",");
        }
        System.out.print("\n");
        }
    }