/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author benjaminrodriguez
 */
public class Pedido {
    private final int id;
    private final ItemMenu item;
    private final String comentario;
    private EstadoPedido estado;
    
    public Pedido(int id, ItemMenu item, String comentario){
        this.id=id;
        this.item=item;
        this.comentario=comentario != null ? comentario:"";
        this.estado=EstadoPedido.NO_CONFIRMADO;
    }
    
    public int getId(){
        return id;
    }
    
    public ItemMenu getItem(){
        return item;
    }
    
    public String getComentario(){
        return comentario;
    }
    
    public EstadoPedido getEstado(){
        return estado;
    }
    
    public void confirmar(){
        if(!estado.puedeAvanzarA(EstadoPedido.CONFIRMADO)){
            throw new IllegalStateException("No se puede confirmar");
        }
        this.estado=EstadoPedido.CONFIRMADO;
    }
    
    public void iniciarProceso(){
        if(!estado.puedeAvanzarA(EstadoPedido.EN_PROCESO)){
            throw new IllegalStateException("No se puede iniciar proceso");
        }
        this.estado=EstadoPedido.EN_PROCESO;
    }
    
    public void finalizar(){
        if(!estado.puedeAvanzarA(EstadoPedido.FINALIZADO)){
            throw new IllegalStateException("No se puede finalizar el pedido");
        }
        this.estado=EstadoPedido.FINALIZADO;
    }
    
    public void entregar(){
        if(!estado.puedeAvanzarA(EstadoPedido.ENTREGADO)){
            throw new IllegalStateException("No se puede finalizar el pedido");
        }
        this.estado=EstadoPedido.ENTREGADO;
    }
}
