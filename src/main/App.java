package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
    /*
    Dentro de esta clase va a ir la funcionalidad basica del menu, validar los datos basicos (que se introduzca un num...)
     */

        int opcion = 0;

        while(opcion != 3) {

            try {

                System.out.println("========================================\n" +
                        "SISTEMA VETERINARIO PETCARE (BDOO)\n" +
                        "========================================\n" +
                        "1. Módulo de Mascotas\n" +
                        "2. Módulo de Veterinarios\n" +
                        "3. Salir\n" +
                        "========================================");
                opcion = sc.nextInt();
                if(opcion > 3 || opcion < 1 ){
                    System.out.println("Introduce un numero entre las opciones indicadas");
                }

            }catch (InputMismatchException e){
                System.out.println("Introduce un numero dentro de las opciones indicadas");
            }
        }


    }
}