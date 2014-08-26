/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import modelo.Monitor;

/**
 *
 * @author manuela
 */
public interface MonitorControle {
    
    public void salvar(Monitor monitor);
    
    public void excluir(Monitor monitor);
    
    public ArrayList<Monitor> listar();
    
    public void atualizar(Monitor monitor);
    
}
