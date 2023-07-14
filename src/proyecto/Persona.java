/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author diego
 */
public class Persona {
    
    private String cedula;
    private String nombres;
    private String facultad;
    private String carrera;

    public Persona(String cedula, String nombre, String facultad, String carrera) {
        this.cedula = cedula;
        this.nombres = nombre;
        this.facultad = facultad;
        this.carrera = carrera;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    
    
    @Override
    public String toString()
    {
        return "CI: "+cedula+"| Nombres: "+nombres+"| Facultad: "+facultad+"| Carrera: "+carrera;
                
    }      
}