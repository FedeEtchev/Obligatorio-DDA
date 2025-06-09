/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author benjaminrodriguez
 */
public class Ingrediente {
    private Insumo insumo;
    private int cantidadNecesaria;
    
    public Ingrediente(Insumo insumo, int cantidadNecesaria){
        this.insumo=insumo;
        this.cantidadNecesaria=cantidadNecesaria;
    }
    
    public Insumo getInsumo(){
        return insumo;
    }
    
    public int getCantidadNecesaria(){
        return cantidadNecesaria;
    }
}
