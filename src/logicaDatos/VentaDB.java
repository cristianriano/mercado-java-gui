/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaDatos;

import logicaNegocio.Venta;

/**
 *
 * @author Cristian
 */
public class VentaDB {
    
    private Conexion conexion;
    
    public VentaDB(){
        conexion = new Conexion();
        conexion.connect();
    }
    
    public boolean vender(Venta venta){
        String sql = "INSERT INTO ventas (id, cantidad, total, id_factura, id_producto) VALUES "
                    + "("+conexion.getMaxId("ventas")+", "+venta.getCantidad()+", "+venta.getTotal()+", "+venta.getFactura().getId()+", "
                + ""+venta.getProducto().getId()+")";
        System.out.println(sql);
        if(conexion.execute(sql) > 0) {
            sql = "UPDATE productos SET cantidad = "+(venta.getProducto().getCantidad()-venta.getCantidad())+" WHERE id = "+venta.getProducto().getId();
            conexion.execute(sql);
            return true;
        }
        return false;
    }
    
}
