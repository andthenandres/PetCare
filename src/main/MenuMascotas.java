package main;

import entity.Mascota;
import jdk.jshell.execution.Util;
import service.MascotaService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuMascotas {
    /*
    En este menu se harán las validaciones del modulo de mascotas
    (Una vez el usuario seleccione la opcion de modulo de veterinarios vendremos a esta clase)

     */
    static Scanner sc = new Scanner(System.in);
    static MascotaService ms;
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

        String nombre;
        String especie;
        String edad;
        String chip;
        boolean esFallido = false;

        System.out.println("Introduce el nombre de la mascota: ");
        nombre = sc.nextLine();
        System.out.println("Introduce el nombre de la especia de la mascota: ");
        especie = sc.nextLine();
        System.out.println("Introduce una edad");
        edad = sc.nextLine();
        System.out.println("Introduce un chip");
        chip = sc.nextLine();



        Mascota mascota = new Mascota();
        mascota.setNombre(nombre);
        mascota.setEspecie(especie);
        mascota.setEdad(edad);
        mascota.setChip(chip);
        esFallido = ms.registrarMascota(mascota);

        //compruebo el valor que me devuelve mascotas
        if(esFallido) {
            System.out.println("Uno de los campos introducidos no es valido");
        }
        else{
            System.out.println("La mascota se ha registrado correctamente");
        }


    }

    public void buscarPorMicrochip() {

    }

    public void listarMascotas() {
        ms.ListarMascotas();
    }

    public void modificarDatos() {

        String nombre;
        String edad;



        System.out.println("Introduce nombre");
        nombre.sc.nextLine();

        System.out.println("Introduce edad");
        edad.sc.nextLine();

        Mascota m =  new Mascota();
        m.setNombre(nombre);
        m.setEdad(edad);

        ms.modificarMascota(m);
    }

    public void eliminarMascotas(){
        Mascota  m = new Mascota();

        //Simplemente pido la mascota
        System.out.println("Introduce el id de la mascota: ");
        m.setId(sc.nextInt());


        ms.eliminarMascota();
    }










    //FUNCIONES AUXILIARES

    //creo la lista de caracteres que se puede usar
    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_@";

    public static String  generarChip() {
        int longitud = 9;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            int pos =  (int) (Math.random() * CARACTERES.length());
            sb.append(CARACTERES.charAt(pos));
        }
        return sb.toString();
    }

    //llamo a la func generar chip y se genera uno hasta que no coincida con ninguno existente en la BDD
    public String generarChipUnico(){
        String chip;
        do{
            chip = generarChip();
        }while(dao.buscarPorChip(chip) != null);
            return chip;
        }
    }



}
