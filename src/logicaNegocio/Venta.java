/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaNegocio;

/**
 *
 * @author Cristian
 */
public class Venta {
    
    private int cantidad, id;
    private float total;
    private Factura factura;
    private Producto producto;
    
    public Venta(){}

    public Venta(int cantidad, int id, float total, Factura factura, Producto producto) {
        this.cantidad = cantidad;
        this.id = id;
        this.total = total;
        this.factura = factura;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
    
}
