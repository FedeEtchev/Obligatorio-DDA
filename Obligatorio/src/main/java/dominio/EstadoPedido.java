/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author benjaminrodriguez
 */
public enum EstadoPedido {
    NO_CONFIRMADO,
    CONFIRMADO,
    EN_PROCESO,
    FINALIZADO,
    ENTREGADO;
    
    public boolean puedeAvanzarA(EstadoPedido siguiente){
        switch(this){
            case NO_CONFIRMADO: return siguiente==CONFIRMADO;
            case CONFIRMADO: return siguiente==EN_PROCESO;
            case EN_PROCESO: return siguiente==FINALIZADO;
            case FINALIZADO: return siguiente==ENTREGADO;
            default: return false;
        }
    }
}
