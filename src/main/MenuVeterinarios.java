package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuVeterinarios {
    /*
    En este menu se harán las validaciones del modulo de mascotas
    (Una vez el usuario seleccione la opcion de modulo de veterinarios vendremos a esta clase)

     */
    static Scanner sc = new Scanner(System.in);
    static void main() {
        int opcion = 0;

        try {

            System.out.println("Módulo de Veterinarios\n" +
                    "1. Registrar veterinario: Valida que el número de colegiado no exista.\n" +
                    "2. Buscar por colegiado: Muestra la información del profesional.\n" +
                    "3. Listar veterinarios: Muestra todos los veterinarios activos.\n" +
                    "4. Modificar especialidad: Actualiza los datos del profesional.\n" +
                    "5. Eliminar veterinario: Retira la instancia de la BDOO.");
            opcion = sc.nextInt();

            if(opcion < 1 || opcion > 5) {
                System.out.println("Introduce un numero entre 1 y 5");

            }
        }catch (InputMismatchException e){
            System.out.println("Introduce un numero");
        }
    }






    }
}
