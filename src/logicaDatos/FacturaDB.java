/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaDatos;

import logicaNegocio.Factura;

/**
 *
 * @author Cristian
 */
public class FacturaDB {
    
    private Conexion conexion;
    private VentaDB ven;
    
    public FacturaDB(){
        conexion = new Conexion();
        conexion.connect();
        ven = new VentaDB();
    }
    
    public int getId(){
        return conexion.getMaxId("facturas");
    }
    
    public boolean facturar(Factura factura){
        String sql = "INSERT INTO facturas (id, total, id_cliente, metodo) VALUES ("+factura.getId()+", "+factura.getTotal()+", "+factura.getCliente().getId()+", "
                + "'"+factura.getMetodo()+"')";
        if(conexion.execute(sql) > 0){
            for(int i =0; i<factura.getVentas().size(); i++){
                ven.vender(factura.getVentas().get(i));
            }
            return true;
        }
        return false;
    }
    
}
