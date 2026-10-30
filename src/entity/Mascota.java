package entity;

public class Mascota {

    //Declaro las variables a usar y en private porque son la clase padre
    private int id;
    private String chip;
    private String nombre;
    private String especie;
    private int edad;

    //Creo un constructor con to
    public Mascota(int id, String chip, String nombre, String especie, int edad) {
        this.id = id;
        this.chip = chip;
        this.nombre = nombre;
        this.especie = especie;
    }
    //y creo uno vacio para rellenar con los parametros que quiera
    public Mascota() {

    }

    //getters y setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getChip() {
        return chip;
    }
    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }


}
