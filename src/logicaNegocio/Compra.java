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
public class Compra {
    
    private int id, cantidad;
    private float total;
    private FacCompra facCompra;
    private Producto producto;
    
    public Compra(){}

    public Compra(int id, int cantidad, float total, FacCompra facCompra, Producto producto) {
        this.id = id;
        this.cantidad = cantidad;
        this.total = total;
        this.facCompra = facCompra;
        this.producto = producto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public FacCompra getFacCompra() {
        return facCompra;
    }

    public void setFacCompra(FacCompra facCompra) {
        this.facCompra = facCompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    
}
