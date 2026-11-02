package service;

import entity.Mascota;
import dao.MascotaDAO;

import java.util.InputMismatchException;

public class MascotaService {
    MascotaDAO mascotaDAO;

    public boolean registrarMascota(Mascota m){
        mascotaDAO = new MascotaDAO();

        if(m.getNombre().length() < 2 || m.getNombre().length() > 20){
            return false;
        }
        if(m.getEspecie().length() < 2 || m.getEspecie().length() > 20){
            return false;
        }
        //valido edad
        try {
            int edad = Integer.parseInt(m.getEdad().trim());
            if(edad <= 0){
                System.out.println("La edad debe ser mayor que cero");
                return false;
            }
        }catch (InputMismatchException e){
            System.out.println("Introduce un numero entero para la edad de la mascota");
            return false;
        }

        String chip = m.getChip().trim();

        //Compruebo que el chip este entre 2 y 20 caracteres
        if(chip.length() < 2 || chip.length() > 20){
            System.out.println("El chip debe de estar entre 2 y 20 caracteres");
            return false;
        }
        //valido que no exista ese chip
        if(!mascotaDAO.registrarMascota(m)){
            System.out.println("Ya existe una mascota con ese chip");
            return false;
        }


        return mascotaDAO.registrarMascota(m);


    }
    public void listarMascota(){
        mascotaDAO = new MascotaDAO();
    }
    public void modificarMascota(Mascota m){
        mascotaDAO = new MascotaDAO();

        if(m.getNombre().length() < 2 || m.getNombre().length() > 20){
            System.out.println("El nombre debe tener entre 2 y 20 caracteres");
        }

        //valido edad
        try {
            int edad = Integer.parseInt(m.getEdad().trim());
            if(edad <= 0){
                System.out.println("La edad debe ser mayor que cero");
            }
        }catch (InputMismatchException e){
            System.out.println("Introduce un numero entero para la edad de la mascota");
        }
    }


    public void eliminarMascota(Mascota m){
        mascotaDAO = new MascotaDAO();
        boolean estaEliminado = mascotaDAO.eliminarMascota(m);

        if(estaEliminado){
            System.out.println("La persona ha sido eliminada");
        }else{
            System.out.println("La persona no existe ");
        }
    }


}
