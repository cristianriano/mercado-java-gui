/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaNegocio;

/**
 *
 * @author Cristian
 */
public class Empleado extends Persona{
    
    private String nombre, cedula, edad, usuario, password, fecha;
    private int horas;
    private float valor;
    
    public Empleado(){}

    public Empleado(String nombre, String cedula, String edad, int horas, float valor, String fecha, String usuario, String password) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.horas = horas;
        this.valor = valor;
        this.fecha = fecha;
        this.usuario = usuario;
        this.password = password;
    }
    
    public String imprimir(){
        return "Nombre: "+nombre+"\nCedula: "+cedula+"\nEdad: "+edad+"\nHoras trabajadas: "+horas+"\nValor hora: "+valor
                + "\n Fecha de ingreso: "+fecha+"\nUsuario: "+usuario; 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
