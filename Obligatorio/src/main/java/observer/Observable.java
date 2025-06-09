/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author benjaminrodriguez
 */
public abstract class Observable {
    private final List<Observador> observers = new ArrayList<>();
    
    public void agregarObservador(Observador o){
        if(o != null && !observers.contains(o)){
            observers.add(o);
        }
    }
    
    public void removerObservador(Observador o){
        observers.remove(o);
    }
    
    protected void avisar(EventoSesion evento){
        for(Observador o : observers){
            o.actualizar(this,evento);
        }
    }
}
