package vario;

import java.util.Random;
import java.util.Scanner;

public class Matrices {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int filasA, columnasA, filasB, columnasB;

        filasA = leerEntero(sc, "Ingrese el número de filas que desea en la Matriz A (1-6):\n ");
        columnasA = leerEntero(sc, "Ingrese el número de columnas que desea en la Matriz A (1-6):\n ");
        filasB = leerEntero(sc, "Ingrese el número de filas que desea en la Matriz B (1-6):\n ");
        columnasB = leerEntero(sc, "Ingrese el número de columnas que desea en la Matriz B (1-6):\n ");

//valida la compatibilidad de las multiplicaciones 
        if (columnasA != filasB) {
            System.out.println("\nNo es posible multiplicar, Las columnas de A deben ser iguales a las filas de B.");
            return;
        }

// Llama a la función para que cree y llene las matrices
        int[][] A =  matrizAleatoria(filasA, columnasA, rand);
        int[][] B =  matrizAleatoria(filasB, columnasB, rand);

// Calcula el resultado de la multiplicacion 
        int[][] C = multiplicarMatrices(A, B);

//Muestra los resultados ya alineados
        mostrarMatrices(A, B, C);
    }

//valida que los valores se encuentren entre 1 y 6
    public static int leerEntero(Scanner sc, String mensaje) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            valor = sc.nextInt();
            if (valor >= 1 && valor <= 6) break;
            System.out.println("El valor se encuentra fuera de rango. Intentelo nuevamente (1-6).");
        }
        return valor;
    }

// Genera la matriz con valores aleatorios entre -10 y 10
    public static int[][] matrizAleatoria(int filas, int columnas, Random rand) {
        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                matriz[i][j] = rand.nextInt(21) - 10;
        return matriz;
    }

// Realiza la Multiplicación clásica de matrices
    public static int[][] multiplicarMatrices(int[][] A, int[][] B) {
        int filasA = A.length;
        int columnasA = A[0].length;
        int columnasB = B[0].length;
        int[][] C = new int[filasA][columnasB];

        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                for (int k = 0; k < columnasA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

// Muestrar las matrices alineadas horizontalmente
    public static void mostrarMatrices(int[][] A, int[][] B, int[][] C) {
        int filas = Math.max(Math.max(A.length, B.length), C.length);
        System.out.println("\nMatriz A                 Matriz B            Resultado");

        for (int i = 0; i < filas; i++) {
            String filaA = (i < A.length) ? formatearFila(A[i]) : " ".repeat(15);
            String filaB = (i < B.length) ? formatearFila(B[i]) : " ".repeat(15);
            String filaC = (i < C.length) ? formatearFila(C[i]) : " ".repeat(15);

            String operador = (i == filas / 2) ? " × " : "   ";
            String igual = (i == filas / 2) ? " = " : "   ";

            System.out.printf("%-15s%s%-15s%s%-15s%n", filaA, operador, filaB, igual, filaC);
        }
    }

// Da formato a una fila de la matriz
    public static String formatearFila(int[] fila) {
        StringBuilder sb = new StringBuilder("[ ");
        for (int val : fila) sb.append(String.format("%3d ", val));
        sb.append("]");
        return sb.toString();
    }	
	
}
