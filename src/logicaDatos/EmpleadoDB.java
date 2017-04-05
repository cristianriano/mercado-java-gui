/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaDatos;

import logicaNegocio.Empleado;

/**
 *
 * @author Cristian
 */
public class EmpleadoDB {
    
    private Conexion conexion;
    
    public EmpleadoDB(){
        conexion = new Conexion();
        conexion.connect();
    }
    
    public boolean insertEmpleado(Empleado empleado){
        String sql = "INSERT INTO empleados (nombre, cedula, edad, horas, valor, fecha, usuario, password, id) "
                + "VALUES ('"+empleado.getNombre()+"', '"+empleado.getCedula()+"', "
                + "'"+empleado.getEdad()+"', "+empleado.getHoras()+", "+empleado.getValor()+", '"+empleado.getFecha()+"', "
                + "'"+empleado.getUsuario()+"', '"+empleado.getPassword()+"', "+conexion.getMaxId("empleados")+")";
        System.out.println(sql);
        if(conexion.execute(sql) > 0) return true;
        return false;
    }
    
    public Empleado findEmpleado(String query){
        Empleado empleado;
        if(conexion.consult("SELECT * FROM empleados WHERE cedula = '"+query+"'")){
            if(conexion.next()){
                empleado = new Empleado();
                empleado.setNombre(conexion.getString("nombre"));
                empleado.setCedula(conexion.getString("cedula"));
                empleado.setEdad(conexion.getString("edad"));
                empleado.setHoras(conexion.getInt("horas"));
                empleado.setValor(conexion.getFloat("valor"));
                empleado.setFecha(conexion.getString("fecha").substring(0, 10));
                empleado.setUsuario( conexion.getString("usuario"));
                empleado.setPassword( conexion.getString("password"));
                empleado.setId(conexion.getInt("id"));
                return empleado;
            }
        }
        return null;
    }
    
    public boolean editEmpleado(int id, Empleado empleado){
        String sql = "UPDATE empleados SET nombre = '"+empleado.getNombre()+"', cedula = '"+empleado.getCedula()+"', "
                + "edad = '"+empleado.getEdad()+"', horas = "+empleado.getHoras()+", "
                + "valor = "+empleado.getValor()+", fecha = '"+empleado.getFecha()+"', usuario = '"+empleado.getUsuario()+"', "
                + "password = '"+empleado.getPassword()+"' WHERE id = "+id;
        System.out.println(sql);
        if(conexion.execute(sql) > 0) return true;
        return false;
    }
    
    public boolean deleteEmpleado(int id){
        String sql = "DELETE FROM empleados WHERE id = "+id;
        System.out.println(sql);
        if(conexion.execute(sql) > 0) return true;
        return false;
    }
    
}
