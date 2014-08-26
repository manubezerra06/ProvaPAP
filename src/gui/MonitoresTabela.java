/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelo.Monitor;

/**
 *
 * @author Regio
 */
public class MonitoresTabela extends AbstractTableModel {

    private ArrayList<Monitor> monitores = new ArrayList<Monitor>();
    private String[] colunas = {"Marca", "Preco", "Novo"};
    
    public static final int INDICE_MARCA = 0;
    public static final int INDICE_PRECO = 1;
    public static final int INDICE_NOVO = 2;

    public int getRowCount() {
        return monitores.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] linha = monitores.get(rowIndex).toArray();
        return linha[columnIndex];
    }

    public void addMonitor(Monitor monitor) {
        monitores.add(monitor);
        this.fireTableDataChanged();
    }

    public Monitor getSelectedMonitor(int linhaSelecionada) {
        return monitores.get(linhaSelecionada);
    }
    
    public void removeMonitor(int linhaSelecionada){
        monitores.remove(linhaSelecionada);
        this.fireTableDataChanged();
    }
    
    /**
     * Adiciona uma lista de monitores ao jtable
     * 
     * @param monitores 
     */
    public void setMonitores(ArrayList<Monitor> monitores){
        this.monitores = monitores;
        this.fireTableDataChanged();
    }

}
