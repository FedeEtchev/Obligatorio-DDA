/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.List;

/**
 *
 * @author benjaminrodriguez
 */
public class ItemMenu {
    private int idItem;
    private String nombre;
    private long precio;
    private List<Ingrediente> ingredientes;
    
    public ItemMenu(int id, String nombre, long precio,
            List<Ingrediente> ingredientes){
        this.idItem=id;
        this.nombre=nombre;
        this.precio=precio;
        this.ingredientes=ingredientes;
    }
    
    public int getId(){
        return idItem;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public long getPrecio(){
        return precio;
    }
    
    public List<Ingrediente> getIngredientes(){
        return ingredientes;
    }
}
