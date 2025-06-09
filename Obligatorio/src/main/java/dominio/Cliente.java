/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author benjaminrodriguez
 */
public class Cliente {
    private final int nroCliente;
    private String contrasenia;
    private String nombre;
    private String apellido;
    
    public Cliente(int nroCliente, String contrasenia, String nombre, String apellido){
        this.nroCliente=nroCliente;
        this.contrasenia=contrasenia;
        this.nombre=nombre;
        this.apellido=apellido;
    }
    
    public int getNroCliente(){
        return nroCliente;
    }
    
    public String getContrasenia(){
        return contrasenia;
    }
    
    public String getNombreCompleto(){
        return nombre+" "+apellido;
    }   
    
    public boolean esValido(String clave){
        return this.contrasenia.equals(clave);
    }
}
