/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table.models;

import domain.Jelo;
import domain.StavkaNarudzbine;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import ui.form.narudzbina.NarudzbinaForma;

/**
 *
 * @author Marko
 */
public class ModelTabeleStavkeNarudzbine extends AbstractTableModel {

    private List<StavkaNarudzbine> stavkeNarudzbine = new ArrayList<>();
    private String[] kolone = {"Rb.", "Jelo", "Cena ", "Kolicina", "Iznos", "Napomena"};
    private NarudzbinaForma nf;

    public ModelTabeleStavkeNarudzbine(List<StavkaNarudzbine> stavkeNarudzbine) {
        this.stavkeNarudzbine = stavkeNarudzbine;
    }

    public List<StavkaNarudzbine> getStavkePlana() {
        return stavkeNarudzbine;
    }

    public void setStavkePlana(List<StavkaNarudzbine> stavkaNarudzbines) {
        this.stavkeNarudzbine = stavkaNarudzbines;
    }

    public NarudzbinaForma getNf() {
        return nf;
    }

    public void setNf(NarudzbinaForma nf) {
        this.nf = nf;
    }

    @Override
    public int getRowCount() {
        if (stavkeNarudzbine != null) {
            return stavkeNarudzbine.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (stavkeNarudzbine != null) {
            StavkaNarudzbine stavkaNarudzbine = stavkeNarudzbine.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return rowIndex + 1;
                case 1:
                    return stavkaNarudzbine.getJelo();
                case 2:
                    if (stavkaNarudzbine.getCena() == 0) {
                        return null;
                    }
                    return stavkaNarudzbine.getCena();
                case 3:
                    if (stavkaNarudzbine.getKolicina() == 0) {
                        return null;
                    }
                    return stavkaNarudzbine.getKolicina();
                case 4:
                    if (stavkaNarudzbine.getIznos() == 0) {
                        return null;
                    }
                    return stavkaNarudzbine.getIznos();
                case 5:
                    return stavkaNarudzbine.getNapomena();
                default:
                    return "N/A";
            }
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        double iznos;
        if (stavkeNarudzbine != null) {
            StavkaNarudzbine stavkaNarudzbine = stavkeNarudzbine.get(rowIndex);
            if (stavkaNarudzbine != null) {
                switch (columnIndex) {
                    case 1:
                        stavkaNarudzbine.setJelo((Jelo) aValue);
                        break;
                    case 3:
                        try {
                        stavkaNarudzbine.setKolicina(Integer.parseInt((String) aValue));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(nf, "Kolicina mora biti broj!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                    case 5:
                        stavkaNarudzbine.setNapomena((String) aValue);
                        break;
                    default:
                        break;
                }
                if (stavkaNarudzbine.getJelo() != null) {
                    stavkaNarudzbine.setCena(stavkaNarudzbine.getJelo().getCena());
                }
                iznos = stavkaNarudzbine.getCena() * stavkaNarudzbine.getKolicina();
                stavkaNarudzbine.setIznos(iznos);
                if (stavkaNarudzbine.getIznos() != 0) {
                    //ptf.promeniProsecanNapor();
                }
            }
            fireTableDataChanged();
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodajStavku(StavkaNarudzbine stavkaNarudzbine) {
        stavkeNarudzbine.add(stavkaNarudzbine);
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return false;
            case 3:
                return true;
            case 4:
                return false;
            case 5:
                return true;
            default:
                return false;
        }
    }

    public void obrisiStavku(int selektovaniRed) {
        stavkeNarudzbine.remove(selektovaniRed);
        fireTableDataChanged();
    }

}
