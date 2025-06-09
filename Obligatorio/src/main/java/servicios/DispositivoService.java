/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import dominio.Dispositivo;
import excepciones.DispositivoOcupadoException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author benjaminrodriguez
 */
public class DispositivoService {
    private final Map<Integer, Dispositivo> dispositivos = new HashMap<>();
    
    public DispositivoService(){
        precargarDispositivos();
    }
    
    public void precargarDispositivos(){
        for(int i=1; i<=5; i++){
            dispositivos.put(i, new Dispositivo(i));
        }
    }
    
    public Dispositivo obtener(int idDispositivo){
        return dispositivos.get(idDispositivo);
    }
    
    public void marcarOcupado(int idDispositivo) throws DispositivoOcupadoException{
        Dispositivo d = dispositivos.get(idDispositivo);
        
        if(d==null){
            throw new DispositivoOcupadoException("Dispositivo no válido.");
        }
        if(d.estaOcupado()){
            throw new DispositivoOcupadoException("Debe primero finalizar el servicio actual");
        }
        
        d.setOcupado(true);
    }
    
    public void liberar(int idDispositivo){
        Dispositivo d = dispositivos.get(idDispositivo);
        
        if(d!=null){
            d.setOcupado(false);
        }
    }
}
