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
public class Gerente extends Persona{
    
    private String usuario, password;

    public Gerente(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }
    
    public Gerente(){}

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
