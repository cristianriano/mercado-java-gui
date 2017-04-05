/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Cristian
 */
public class Conexion {
    
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String login = "mercado";
    private String password = "mercado";
    private Connection conexion;
    private Statement query;
    private ResultSet res;
    
    public Conexion(){}
    
    public boolean connect(){
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conexion = DriverManager.getConnection(url, login, password);
            query = conexion.createStatement();
            System.out.println("conectado");
            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public int execute(String sql){
        try{            
            int rs = query.executeUpdate(sql);
            return rs;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return -1;
    }
    
    public boolean consult(String sql){
        try{
            res = query.executeQuery(sql);
            return true;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean next(){
        try{
            if(res.next()){
                return true;
            }
            else{
                return false;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public String getString(String nombre){
        try{
            return res.getString(nombre);
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    public int getInt(String nombre){
        try{
            return res.getInt(nombre);
        }
        catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
    
    public float getFloat(String nombre){
        try{
            return res.getFloat(nombre);
        }
        catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
    
    public int getMaxId(String tabla){
        try{
            String sql = "SELECT max(id) FROM "+tabla;
            System.out.println(sql);
            consult(sql);
            next();
            return res.getInt(1) + 1;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    
}
