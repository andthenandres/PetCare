package main;

import entity.Mascota;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuMascotas {
    /*
    En este menu se harán las validaciones del modulo de mascotas
    (Una vez el usuario seleccione la opcion de modulo de veterinarios vendremos a esta clase)

     */
    static Scanner sc = new Scanner(System.in);
    static void main() {

        int opcion = 0;

        while (opcion < 1 || opcion > 5) {

            try {

                System.out.println("Módulo de Mascotas\n" +
                        "1. Registrar mascota: Solicita datos y valida que el código de chip sea único.\n" +
                        "2. Buscar por microchip: Recupera y muestra la mascota.\n" +
                        "3. Listar mascotas: Muestra todas las mascotas registradas en la BDOO.\n" +
                        "4. Modificar datos: Actualiza la edad o el nombre de la mascota.\n" +
                        "5. Eliminar mascota: Elimina la instancia de la base de datos.");
                opcion = sc.nextInt();

                if(opcion < 1 || opcion > 5) {
                    System.out.println("Introduce un numero entre 1 y 5");

                }
            }catch (InputMismatchException e){
                System.out.println("Introduce un numero");
            }
        }


    }
    public void registrarMascota() {

        String chip = "";
        String nombre = "";
        String especie = "";
        int edad = 0;


        System.out.println("Introduce el nombre de la mascota: ");
        nombre = sc.nextLine();





    }


    public void modificarDatos(){

        String chip = "";
        String nombre = "";
        String especie = "";
        int edad = 0;

        Mascota m =  new Mascota();

        System.out.println("Introduce un nombre");
        nombre.setNombre(sc.nextLine());

        System.out.println("Introduce una especie");
        especie = sc.nextLine();

        //valido edad positiva
        while(edad <= 0) {

            try {
                System.out.println("Introduce una edad");
                edad = sc.nextInt();
                if(edad <= 0) {
                    System.out.println("Introduce una edad positiva");
                }
            }catch (InputMismatchException e){
                System.out.println("Introduce un numero entero");
            }
        }

    }



}
