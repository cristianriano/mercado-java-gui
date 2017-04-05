/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaNegocio;

import java.util.List;

/**
 *
 * @author Cristian
 */
public class Factura {
    
    private String metodo;
    private int id;
    private float total;
    private Cliente cliente;
    private List<Venta> ventas;
    
    public Factura(){}

    public Factura(String metodo, int id, float total, Cliente cliente) {
        this.metodo = metodo;
        this.id = id;
        this.total = total;
        this.cliente = cliente;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
    
    
}
