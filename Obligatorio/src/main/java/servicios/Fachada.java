/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import dominio.Cliente;
import dominio.Dispositivo;
import dominio.Servicio;
import excepciones.AutenticacionException;
import excepciones.ClienteYaActivoException;
import excepciones.DispositivoOcupadoException;

/**
 *
 * @author benjaminrodriguez
 */
public class Fachada {
    private final ServicioCliente servicioCliente;
    private final ServicioDispositivo servicioDispositivo;
    private final ServicioServicio servicioServicio;
    
    public Fachada(){
        this.servicioCliente = new ServicioCliente();
        this.servicioDispositivo = new ServicioDispositivo();
        this.servicioServicio = new ServicioServicio();
    }
    
    public Servicio identificarCliente(int numeroCliente, String contrasenia, int idDispositivo)
            throws AutenticacionException,ClienteYaActivoException, DispositivoOcupadoException{
        Cliente c = servicioCliente.validarCredenciales(numeroCliente,contrasenia);
        servicioDispositivo.marcarOcupado(idDispositivo);
        servicioCliente.registrarActivo(numeroCliente, idDispositivo);
        
        Dispositivo d = servicioDispositivo.obtener(idDispositivo);
        return servicioServicio.crearServicio(c,d);
    }
    
    public void finalizarServicio(int numeroCliente, int idDispositivo){
        servicioCliente.liberarCliente(numeroCliente);
        servicioDispositivo.liberar(idDispositivo);
        servicioServicio.finalizarServicio(numeroCliente,idDispositivo);
    }

}
