/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author benjaminrodriguez
 */
public class Servicio {
    private final int idServicio;
    private final Cliente cliente;
    private final Dispositivo dispositivo;
    private List<Object> pedidos = new ArrayList<>();
    private long montoTotal;
    private EstadoServicio estado= EstadoServicio.GENERADO;
    
    public Servicio(int idServicio, Cliente cliente, Dispositivo dispositivo){
        this.idServicio=idServicio;
        this.cliente=cliente;
        this.dispositivo=dispositivo;
        this.montoTotal=0L;
    }
    
    public int getIdServicio(){
        return idServicio;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public Dispositivo getDispositivo(){
        return dispositivo;
    }
    
    public long getMontoTotal(){
        return montoTotal;
    }
    
    public EstadoServicio getEstado(){
        return estado;
    }
    
    
    public void abonarServicio(){
        if(!estado.puedeAvanzarA(EstadoServicio.ABONADO)){
            throw new IllegalStateException("No se puede abonar un servicio aún no generado");
        }
        this.estado=EstadoServicio.ABONADO;
    }
}

