package dao;

import entity.Mascota;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import service.MascotaService;
import util.ConexionDb4o;

import java.util.ArrayList;

public class MascotaDAO {

    ConexionDb4o conexionBD;

    public boolean registrarMascota(Mascota m) {

        conexionBD = new ConexionDb4o();

        ObjectContainer bd = conexionBD.abrirConexion();

        buscarPorChip(m);
        int id = calcularId();

        bd.store(m);
        bd.commit();

        bd.close();
        return true;

    }


    public MascotaService modificarMascota(MascotaService m){

        conexionBD = new ConexionDb4o();

        ObjectContainer bd = conexionBD.abrirConexion();
        ObjectSet<MascotaService> todasMascotas = bd.queryByExample(m);

        MascotaService mascotas = null;

        if(todasMascotas.hasNext()){
            m = todasMascotas.next();
        }


        bd.close();

        return mascotas;

    }

    public boolean eliminarMascota(MascotaService m){
        conexionBD = new ConexionDb4o();

        ObjectContainer bd = conexionBD.abrirConexion();

        MascotaService mascota = buscarMascotaPorId(bd, m);

        if(mascota != null){
            bd.delete(mascota);
            bd.commit();
            bd.close();
            return true;
        }
        bd.close();
        return false;
    }


    public MascotaService buscarMascotaPorId(ObjectContainer db,MascotaService m){

        ObjectSet<MascotaService> resultado = db.queryByExample(m);

        if(resultado.hasNext()){
            m = resultado.next();
            return m;
        }
        return null;

    }

    public ArrayList<MascotaService> listadoMascota(){
        conexionBD = new ConexionDb4o();

        ObjectContainer bd = conexionBD.abrirConexion();

        ObjectSet<MascotaService> resultado = bd.queryByExample(new MascotaService());

        //select * from persona where id != 0;

        ArrayList<MascotaService> listaMascotas = new ArrayList<>();

        for (MascotaService m: resultado){
            listaMascotas.add(m);
        }
        bd.close();
        return listaMascotas;

    }


















    //funciones auxiliares para registrar el chip
    //private final static String CARACTERES = "ABDCDEFG123456789@-_";

    /*

    COMENTO ESTA FUNCION PORQUE EL CHIP SE PIDE POR TECLADO NO SE GENERA

    public String generarChipUnico(){
        String chip;

        do{
            chip = calcularChip();
        }while(buscarPorChip(chip) != null);
        return chip;

    }

    */

    /*
    COMENTO ESTA FUNCION PORQUE EL CHIP HABIA QUE PEDIRLO POR TECLADO Y NO ERA NECESARIO GENERARLO

    public String calcularChip() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 9; i++) {
            int pos = (int) (Math.random() * CARACTERES.length());
            sb.append(CARACTERES.charAt(pos));
        }
        return sb.toString();

    }

     */

    //buscamos el chip, si encuentra algo se devuelve si no devuelve un null
    public Mascota buscarPorChip(String chip){
        ObjectContainer bd = conexionBD.abrirConexion();
        Mascota m = new Mascota();

        m.setChip(chip);
        ObjectSet<Mascota> rs = bd.queryByExample(m);
        Mascota resultado = rs.hasNext() ? rs.next() : null;

        bd.close();
        return resultado;
    }





    public int calcularId() {

    }

}
