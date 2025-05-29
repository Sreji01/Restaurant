/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table.models;

import domain.Gost;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sreja
 */
public class ModelTabeleGosti extends AbstractTableModel {
    private List<Gost> gosti;
    private String[] kolone = {"Ime", "Prezime", "Broj telefona", "Gost"};
    
    public ModelTabeleGosti(List<Gost> gosti){
        this.gosti = gosti;
    }

    @Override
    public int getRowCount() {
        return gosti.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Gost gost = gosti.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return gost.getIme();
            case 1:
                return gost.getPrezime();
            case 2:
                return gost.getBrojTelefona();
            case 3:
                return gost.getGrad();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
}
