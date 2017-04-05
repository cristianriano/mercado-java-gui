/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaDatos;

import logicaNegocio.FacCompra;

/**
 *
 * @author Cristian
 */
public class FacCompraDB {
    
    private Conexion conexion;
    private CompraDB com;
    
    public FacCompraDB(){
        conexion = new Conexion();
        conexion.connect();
        com = new CompraDB();
    }
    
    public int getId(){
        return conexion.getMaxId("fac_compras");
    }
    
    public boolean facturar(FacCompra factura){
        String sql = "INSERT INTO fac_compras (id, total, id_empleado, proveedor) VALUES ("+factura.getId()+", "+factura.getTotal()+", "+factura.getEmpleado().getId()+", "
                + "'"+factura.getProveedor()+"')";
        if(conexion.execute(sql) > 0){
            for(int i =0; i<factura.getCompras().size(); i++){
                com.comprar(factura.getCompras().get(i));
            }
            return true;
        }
        return false;
    }
    
}
