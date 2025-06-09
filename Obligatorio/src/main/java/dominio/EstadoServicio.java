/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author benjaminrodriguez
 */
public enum EstadoServicio {
    GENERADO,
    ABONADO;
    
    public boolean puedeAvanzarA(EstadoServicio siguiente){
        return this == GENERADO && siguiente==ABONADO;
    }
}
