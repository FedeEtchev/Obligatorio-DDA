/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author benjaminrodriguez
 */
public class Dispositivo {
    private final int nroIdentificador;
    private boolean ocupado;
    
    public Dispositivo(int nroIdentificador){
        this.nroIdentificador=nroIdentificador;
        this.ocupado=false;
    }
    
    public int getNroIdentificador(){
        return nroIdentificador;
    }
    
    public boolean estaOcupado(){
        return ocupado;
    }
    
    public void setOcupado(Boolean estado){
        this.ocupado=estado;
    }
    
}
