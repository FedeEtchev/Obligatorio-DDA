/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import excepciones.InsumoException;

/**
 *
 * @author benjaminrodriguez
 */
public class Insumo {
    private int idInsumo;
    private String nombre;
    private int stockMinimo;
    private int stockActual;
    
    public Insumo(int idInsumo, String nombre, int stockInicial, int stockMinimo){
        this.idInsumo=idInsumo;
        this.nombre=nombre;
        this.stockMinimo=stockMinimo;
        this.stockActual=stockInicial;
    }
    
    public int getIdInsumo(){
        return idInsumo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getStockActual(){
        return stockActual;
    }
    
    public int getStockMinimo(){
        return stockMinimo;
    }
    
    public void descontarStock(int cantidad) throws InsumoException{
        if(cantidad<=0) return;
        if(stockActual - cantidad < 0){
            throw new InsumoException("Stock insuficiente para insumo "+nombre);
        }
        stockActual -= cantidad;
    }
}
