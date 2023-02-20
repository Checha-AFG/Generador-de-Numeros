import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerarNumerosAleatorios {

    public static void main(String[] args) {
        // Generar un millón de números aleatorios
        int cantidadNumeros = 1000000;
        int rango = 10000000;
        int[] numeros = new int[cantidadNumeros];
        Random random = new Random();
        for (int i = 0; i < cantidadNumeros; i++) {
            numeros[i] = random.nextInt(rango*2) - rango;
        }
        
        // Almacenar los números en un archivo de texto
        String rutaArchivo = "numeros.txt";
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
                for (int i = 0; i < cantidadNumeros; i++) {
                    writer.write(numeros[i] + "\n");
                }
            }
            System.out.println("Archivo creado correctamente.");
        } catch (IOException e) {
        }
        
        // Ordenar los números utilizando el algoritmo de burbuja
        int temp;
        for (int i = 0; i < cantidadNumeros - 1; i++) {
            for (int j = 0; j < cantidadNumeros - i - 1; j++) {
                if (numeros[j] > numeros[j+1]) {
                    temp = numeros[j];
                    numeros[j] = numeros[j+1];
                    numeros[j+1] = temp;
                }
            }
        }
        
        // Almacenar los números ordenados en un nuevo archivo de texto
        String rutaArchivoOrdenado = "numeros_ordenados.txt";
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivoOrdenado))) {
                for (int i = 0; i < cantidadNumeros; i++) {
                    writer.write(numeros[i] + "\n");
                }
            }
            System.out.println("Archivo de números ordenados creado correctamente.");
        } catch (IOException e) {
        }
    }

}

