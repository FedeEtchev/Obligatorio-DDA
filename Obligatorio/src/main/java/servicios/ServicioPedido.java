/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import dominio.ItemMenu;
import dominio.Pedido;
import dominio.Servicio;
import excepciones.StockInsuficienteException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import observer.EventoPedido;
import observer.Observable;

/**
 *
 * @author benjaminrodriguez
 */
public class ServicioPedido extends Observable{
    private final AtomicInteger secuencia = new AtomicInteger(1);
    private final Map<Integer,Pedido> pedidos = new ConcurrentHashMap<>();
    private final ServicioStock servicioStock;
    private final ServicioServicio servicioServicio;
    
    public ServicioPedido(ServicioStock stockSrv, ServicioServicio servicioServicio){
        this.servicioStock=servicioStock;
        this.servicioServicio=servicioServicio;
    }
    
    public Pedido crearPedido(int idServicio, int idItemMenu, String comentario){
        Servicio servicio=servicioServicio.obtenerServicioPorId(idServicio);
        ItemMenu item = null; /*por ahora*/
        int id = secuencia.getAndIncrement();
        Pedido p=new Pedido(id, item, comentario);
        pedidos.put(id,p);
        servicio.getPedidos().add(p);
        return p;
    }
    
    public void confirmarPedido(int idPedido)
            throws StockInsuficienteException{
        Pedido p = pedidos.get(idPedido);
        p.confirmar();
        servicioStock.chequearYDescontar(p.getItem());
        avisar(new EventoPedido(EventoPedido.Tipo.PEDIDO_CONFIRMADO,p));
    }
    
    public void finalizarPedido(int idPedido){
        Pedido p=pedidos.get(idPedido);
        p.finalizar();
        avisar(new EventoPedido(EventoPedido.Tipo.PEDIDO_FINALIZADO,p));
    }
    
    public void entregarPedido(int idPedido){
        Pedido p=pedidos.get(idPedido);
        p.entregar();
        avisar(new EventoPedido(EventoPedido.Tipo.PEDIDO_ENTREGADO,p));
    }
}
