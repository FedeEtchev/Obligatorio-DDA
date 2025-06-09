/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import dominio.Cliente;
import dominio.Dispositivo;
import dominio.Servicio;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author benjaminrodriguez
 */
public class ServicioServicio {
    private final AtomicInteger secuenciaIds = new AtomicInteger(1);
    final Map<Integer, Servicio> serviciosActivosPorId = new ConcurrentHashMap<>();
    final Map<Integer, Servicio> serviciosActivosPorCliente = new ConcurrentHashMap<>();
    
    public Servicio crearServicio(Cliente cliente, Dispositivo dispositivo){
        int nuevoId = secuenciaIds.getAndIncrement();
        Servicio s = new Servicio(nuevoId,cliente,dispositivo);
        serviciosActivosPorId.put(nuevoId, s);
        serviciosActivosPorCliente.put(cliente.getNroCliente(),s);
        return s;
    }
    
    public Servicio obtenerServicioPorCliente(int numeroCliente){
        return serviciosActivosPorCliente.get(numeroCliente);
    }
    
    public Servicio obtenerServicioPorId(int idServicio){
        return serviciosActivosPorId.get(idServicio);
    }
    
    public void finalizarServicio(int numeroCliente,int idServicio){
        Servicio s = serviciosActivosPorId.remove(idServicio);
        if(s!=null){
            serviciosActivosPorCliente.remove(numeroCliente);
        }
    }
}
