/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Observer;

/**
 *
 * @author benjaminrodriguez
 */
public class UnidadProcesadora implements Observer {
    private String nombre;
    
    public UnidadProcesadora(String nombre){
        this.nombre=nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    @Override
    public void update(EventoPedido evento){
        if(evento.get)
    }
}
