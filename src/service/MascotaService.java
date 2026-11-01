package service;

import dao.MascotaDAO;

public class MascotaService {
    MascotaDAO mascotaDAO;

    public void registrarMascota(){
        mascotaDAO = new MascotaDAO();
    }
    public void listarMascota(){
        mascotaDAO = new MascotaDAO();
    }
    public void modificarMascota(){
        mascotaDAO = new MascotaDAO();
    }
    public void eliminarMascota(){
        mascotaDAO = new MascotaDAO();
    }
}
