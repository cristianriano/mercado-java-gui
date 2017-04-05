/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaDatos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian
 */
public class BalanceDB {
    
    private Conexion conexion;
    
    public BalanceDB(){
        conexion = new Conexion();
        conexion.connect();
    }
    
    public List<Float> calcularVentas(){
        List<Float> ventas = new ArrayList<>();
        String sql = "SELECT total FROM facturas";
        if(conexion.consult(sql)){
            while(conexion.next()){
                ventas.add(conexion.getFloat("total"));
            }
        }
        return ventas;
    }
    
    public List<Float> calcularCompras(){
        List<Float> compras = new ArrayList<>();
        String sql = "SELECT total FROM fac_compras";
        if(conexion.consult(sql)){
            while(conexion.next()){
                compras.add(conexion.getFloat("total"));
            }
        }
        return compras;
    }
    
}
