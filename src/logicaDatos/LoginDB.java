/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaDatos;

import logicaNegocio.Empleado;
import logicaNegocio.Gerente;
import logicaNegocio.Persona;

/**
 *
 * @author Cristian
 */
public class LoginDB {
    
    private Conexion conexion;
    
    public LoginDB(){
        conexion = new Conexion();
        conexion.connect();
    }
    
    //Retorna 0 si los datos son erroneos, 1 si es gerente y 2 si es empleado
    public Persona autenticar(String login, String password){
        String sql = "SELECT * FROM gerentes WHERE usuario = '"+login+"' AND PASSWORD = '"+password+"'";
        if(conexion.consult(sql)){
            if(conexion.next()){
                return new Gerente();
            }
        }
        sql = "SELECT * FROM empleados WHERE usuario = '"+login+"' AND PASSWORD = '"+password+"'";
        if(conexion.consult(sql)){
            if(conexion.next()){
                Empleado empleado = new Empleado();
                empleado.setCedula(conexion.getString("cedula"));
                empleado.setId(conexion.getInt("id"));
                return empleado;
            }
        }
        return null;
    }
    
}
