/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaDatos;

import logicaNegocio.Compra;

/**
 *
 * @author Cristian
 */
public class CompraDB {
    
    private Conexion conexion;
    
    public CompraDB(){
        conexion = new Conexion();
        conexion.connect();
    }
    
    public boolean comprar(Compra compra){
        String sql = "INSERT INTO compras (id, cantidad, total, id_fac_compra, id_producto) VALUES "
                    + "("+conexion.getMaxId("compras")+", "+compra.getCantidad()+", "+compra.getTotal()+", "+compra.getFacCompra().getId()+", "
                + ""+compra.getProducto().getId()+")";
        System.out.println(sql);
        if(conexion.execute(sql) > 0) {
            sql = "UPDATE productos SET cantidad = "+(compra.getProducto().getCantidad()+compra.getCantidad())+" WHERE id = "+compra.getProducto().getId();
            conexion.execute(sql);
            return true;
        }
        return false;
    }
    
}
