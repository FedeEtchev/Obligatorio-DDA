// ConsoleApp.java
package com.mycompany.obligatorio;

import servicios.Fachada;
import dominio.Servicio;
import excepciones.AutenticacionException;
import excepciones.ClienteYaActivoException;
import excepciones.DispositivoOcupadoException;

import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) {
        Fachada fachada = new Fachada();        // “new Fachada()” porque tu clase se llama así
        Scanner sc = new Scanner(System.in);

        Integer numeroClienteActivo = null;
        Integer idDispositivoActivo = null;
        Integer idServicioActivo   = null;

        while (true) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1) Identificarse");
            System.out.println("2) Finalizar servicio");
            System.out.println("3) Salir");
            System.out.print("Elija opción: ");

            String opcion = sc.nextLine().trim();
            switch (opcion) {
                case "1":
                    // CU1: Identificarse
                    try {
                        System.out.print("Número de cliente: ");
                        int numero = Integer.parseInt(sc.nextLine().trim());

                        System.out.print("Contraseña: ");
                        String pwd = sc.nextLine().trim();

                        System.out.print("ID Dispositivo: ");
                        int idDisp = Integer.parseInt(sc.nextLine().trim());

                        Servicio svc = fachada.identificarCliente(numero, pwd, idDisp);
                        numeroClienteActivo = numero;
                        idDispositivoActivo = idDisp;
                        idServicioActivo   = svc.getIdServicio();

                        System.out.println("¡Bienvenido, " + svc.getCliente().getNombre() + "!");
                        System.out.println("Servicio creado con ID = " + idServicioActivo);
                        System.out.println("Estado del servicio: " + svc.getEstadoServicio());
                        System.out.println("Monto total (centavos): " + svc.getMontoTotal());

                    } catch (NumberFormatException e) {
                        System.out.println("Error: ingrese un número válido.");
                    } catch (AutenticacionException | ClienteYaActivoException | DispositivoOcupadoException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;

                case "2":
                    // CU3: Finalizar servicio
                    if (numeroClienteActivo == null
                        || idDispositivoActivo == null
                        || idServicioActivo == null) {
                        System.out.println("No hay un servicio activo para finalizar.");
                    } else {
                        fachada.finalizarServicio(
                            numeroClienteActivo,
                            idDispositivoActivo
                        );
                        System.out.println("Servicio finalizado (ID = " + idServicioActivo + ").");
                        numeroClienteActivo = null;
                        idDispositivoActivo = null;
                        idServicioActivo    = null;
                    }
                    break;

                case "3":
                    System.out.println("Saliendo. ¡Hasta luego!");
                    sc.close();
                    return;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
}
