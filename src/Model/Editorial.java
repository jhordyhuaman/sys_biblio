/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author codsi
 */
public class Editorial {
      private int ideditorial;
    private String nombre;
    private String estado;

    public Editorial(int ideditorial, String nombre, String estado) {
        this.ideditorial = ideditorial;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Editorial( String nombre, String estado) {
        this.ideditorial = ideditorial;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Editorial() {
    }

    public int getIdeditorial() {
        return ideditorial;
    }

    public void setIdeditorial(int ideditorial) {
        this.ideditorial = ideditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
