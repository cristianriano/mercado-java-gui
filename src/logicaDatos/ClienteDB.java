/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaDatos;

import logicaNegocio.Cliente;

/**
 *
 * @author Cristian
 */
public class ClienteDB {
    
    private Conexion conexion;
    
    public ClienteDB(){
        conexion = new Conexion();
        conexion.connect();
    }
    
    public boolean insertCliente(Cliente cliente){
        String sql = "INSERT INTO clientes (nombre, cedula, telefono, id) "
                + "VALUES ('"+cliente.getNombre()+"', '"+cliente.getCedula()+"', "
                + "'"+cliente.getTelefono()+"', "+conexion.getMaxId("clientes")+")";
        System.out.println(sql);
        if(conexion.execute(sql) > 0) return true;
        return false;
    }
    
    public Cliente findCliente(String query){
        Cliente cliente;
        if(conexion.consult("SELECT * FROM clientes WHERE cedula = '"+query+"'")){
            if(conexion.next()){
                cliente = new Cliente();
                cliente.setNombre(conexion.getString("nombre"));
                cliente.setCedula(conexion.getString("cedula"));
                cliente.setTelefono(conexion.getString("telefono"));
                cliente.setId(conexion.getInt("id"));
                return cliente;
            }
        }
        return null;
    }
    
    public boolean editCliente(int id, Cliente cliente){
        String sql = "UPDATE clientes SET nombre = '"+cliente.getNombre()+"', cedula = '"+cliente.getCedula()+"', "
                + "telefono = '"+cliente.getTelefono()+"' WHERE id = "+id;
        System.out.println(sql);
        if(conexion.execute(sql) > 0) return true;
        return false;
    }
    
    public boolean deleteCliente(int id){
        String sql = "DELETE FROM clientes WHERE id = "+id;
        System.out.println(sql);
        if(conexion.execute(sql) > 0) return true;
        return false;
    }
}
