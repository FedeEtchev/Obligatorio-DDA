/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import dominio.Cliente;
import excepciones.AutenticacionException;
import excepciones.ClienteYaActivoException;
import java.util.HashMap;
import java.util.Map;
import observer.EventoSesion;
import observer.Observable;

/**
 *
 * @author benjaminrodriguez
 */
public class ServicioCliente extends Observable{
    private final Map<Integer, Cliente> clientesRegistrados = new HashMap<>();
    private final Map<Integer, Integer> clientesActivos = new HashMap<>();
    
    public ServicioCliente(){
        precargarClientes();
    }
    
    private void precargarClientes(){
        clientesRegistrados.put(1001, new Cliente(1001,"clave1","Ana","Gomez"));
        clientesRegistrados.put(1002, new Cliente(1002,"clave2","Benjamin","Rodriguez"));
        clientesRegistrados.put(1003, new Cliente(1003,"clave3","Diego","Saint"));
    }
    
    public Cliente validarCredenciales(int numeroCliente, String contrasenia)
            throws AutenticacionException,ClienteYaActivoException{
            
        Cliente cliente = clientesRegistrados.get(numeroCliente);
        if(cliente==null || !cliente.esValido(contrasenia)){
            throw new AutenticacionException("Credenciales incorrectas.");
        }
        if(clientesActivos.containsKey(numeroCliente)){
            throw new ClienteYaActivoException("Ud. ya está identificado en otro dispositivo");
        }
        
        return cliente;
    }
    
    public void registrarActivo(int numeroCliente, int idDispositivo){
        clientesActivos.put(numeroCliente, idDispositivo);
        avisar(EventoSesion.ALTA_SESION);
    }
    
    public void liberarCliente(int numeroCliente){
        clientesActivos.remove(numeroCliente);
        avisar(EventoSesion.BAJA_SESION);
    }
}
