/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table.models;

import domain.Narudzbina;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sreja
 */
public class ModelTabeleNarudzbine extends AbstractTableModel {
    private List<Narudzbina> narudzbine;
    private String[] kolone = {"Datum i vreme", "Status", "Ukupan iznos", "Zaposleni", "Gost"};
    
    public ModelTabeleNarudzbine(List<Narudzbina> narudzbine){
        this.narudzbine = narudzbine;
    }

    @Override
    public int getRowCount() {
        return narudzbine.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Narudzbina narudzbina = narudzbine.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return getDatumString(narudzbina.getDatumIVreme());
            case 1:
                return narudzbina.getStatus();
            case 2:
                return narudzbina.getUkupanIznos();
            case 3:
                return narudzbina.getZaposleni();
            case 4:
                return narudzbina.getGost();
            default:
                throw new AssertionError();
        }
    }
    
    private String getDatumString(Date datum) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return format.format(datum);
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
}
