/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaDatos;

import java.util.ArrayList;
import java.util.List;
import logicaNegocio.Producto;

/**
 *
 * @author Cristian
 */
public class ProductoDB {
    
    private Conexion conexion;
    
    public ProductoDB(){
        conexion = new Conexion();
        conexion.connect();
    }
    
    public boolean insertProducto(Producto producto){
        String sql = "INSERT INTO productos (nombre, codigo, cantidad, costo, precio, id) "
                + "VALUES ('"+producto.getNombre()+"', '"+producto.getCodigo()+"', "
                + ""+producto.getCantidad()+", "+producto.getCosto()+", "+producto.getPrecio()+", "+conexion.getMaxId("productos")+")";
        System.out.println(sql);
        if(conexion.execute(sql) > 0) return true;
        return false;
    }
    
    public List<Producto> listProductos(){
        String sql = "SELECT * FROM productos";
        System.out.println(sql);
        if(conexion.consult(sql)){
            List<Producto> productos = new ArrayList<>();
            Producto producto;
            while(conexion.next()){
                producto = new Producto();
                producto.setId(conexion.getInt("id"));
                producto.setNombre(conexion.getString("nombre"));
                producto.setCodigo(conexion.getString("codigo"));
                producto.setCantidad(conexion.getInt("cantidad"));
                producto.setCosto(conexion.getFloat("costo"));
                producto.setPrecio(conexion.getFloat("precio"));
                productos.add(producto);
            }
            return productos;
        }
        return null;
    }
    
    public Producto findProducto(String query){
        String sql = "SELECT * FROM productos WHERE codigo = '"+query+"'";
        System.out.println(sql);
        if(conexion.consult(sql)){
            Producto producto;
            if(conexion.next()){
                producto = new Producto();
                producto.setId(conexion.getInt("id"));
                producto.setNombre(conexion.getString("nombre"));
                producto.setCodigo(conexion.getString("codigo"));
                producto.setCantidad(conexion.getInt("cantidad"));
                producto.setCosto(conexion.getFloat("costo"));
                producto.setPrecio(conexion.getFloat("precio"));
                return producto;
            }
        }
        return null;
    }
    
    public boolean editProduct(int id, Producto producto){
        String sql = "UPDATE productos SET nombre = '"+producto.getNombre()+"', codigo = '"+producto.getCodigo()+"', "
                + "precio = "+producto.getPrecio()+", costo = "+producto.getCosto()+" WHERE id = "+id;
        System.out.println(sql);
        if(conexion.execute(sql) > 0) return true;
        return false;
    }
    
    public boolean deleteProduct(int id){
        String sql = "DELETE FROM productos WHERE id = "+id;
        System.out.println(sql);
        if(conexion.execute(sql) > 0) return true;
        return false;
    }
    
}
