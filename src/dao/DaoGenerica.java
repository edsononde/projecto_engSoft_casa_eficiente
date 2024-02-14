/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.ArrayList;

/**
 *
 * @author Jason Matias
 * @param <ObjectoGenerico>
 */
public interface DaoGenerica<ObjectoGenerico>{
    
    public void inserir(ObjectoGenerico obj);
    
    public ArrayList<ObjectoGenerico> consultar();
    
    public void alterar(ObjectoGenerico obj);
    
    public void excluir(String obj);
}
