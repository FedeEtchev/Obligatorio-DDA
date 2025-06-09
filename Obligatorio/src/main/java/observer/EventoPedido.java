/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

import dominio.Pedido;

/**
 *
 * @author benjaminrodriguez
 */
public class EventoPedido {
    public enum Tipo{
        PEDIDO_CONFIRMADO,
        PEDIDO_EN_PROCESO,
        PEDIDO_FINALIZADO,
        PEDIDO_ENTREGADO
    }
    
    private final Tipo tipo;
    private final Pedido pedido;
    
    public EventoPedido(Tipo tipo, Pedido pedido){
        this.tipo=tipo;
        this.pedido=pedido;
    }
    
    public Tipo getTipo(){
        return tipo;
    }
    
    public Pedido getPedido(){
        return pedido;
    }
}
