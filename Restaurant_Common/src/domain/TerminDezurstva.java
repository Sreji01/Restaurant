/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Sreja
 */
public class TerminDezurstva implements OpstiDomenskiObjekat, Serializable {

    private int idTerminDezurstva;
    private Date datumIVremePocetka;
    private Date datumIVremeZavrsetka;

    public TerminDezurstva() {
    }

    public TerminDezurstva(int idTerminDezurstva, Date datumIVremePocetka, Date datumIVremeZavrsetka) {
        this.idTerminDezurstva = idTerminDezurstva;
        this.datumIVremePocetka = datumIVremePocetka;
        this.datumIVremeZavrsetka = datumIVremeZavrsetka;
    }

    public int getIdTerminDezurstva() {
        return idTerminDezurstva;
    }

    public void setIdTerminDezurstva(int idTerminDezurstva) {
        this.idTerminDezurstva = idTerminDezurstva;
    }

    public Date getDatumIVremePocetka() {
        return datumIVremePocetka;
    }

    public void setDatumIVremePocetka(Date datumIVremePocetka) {
        this.datumIVremePocetka = datumIVremePocetka;
    }

    public Date getDatumIVremeZavrsetka() {
        return datumIVremeZavrsetka;
    }

    public void setDatumIVremeZavrsetka(Date datumIVremeZavrsetka) {
        this.datumIVremeZavrsetka = datumIVremeZavrsetka;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TerminDezurstva other = (TerminDezurstva) obj;
        if (this.idTerminDezurstva != other.idTerminDezurstva) {
            return false;
        }
        if (!Objects.equals(this.datumIVremePocetka, other.datumIVremePocetka)) {
            return false;
        }
        return Objects.equals(this.datumIVremeZavrsetka, other.datumIVremeZavrsetka);
    }

    @Override
    public String toString() {
        return "TerminDezurstva{" + "idTerminDezurstva=" + idTerminDezurstva + ", datumIVremePocetka=" + datumIVremePocetka + ", datumIVremeZavrsetka=" + datumIVremeZavrsetka + '}';
    }

    @Override
    public String getTableName() {
        return "termin_dezurstva";
    }

    @Override
    public String getColumnsForInsert() {
        return "datumIVremePocetka, datumIVremeZavrsetka";
    }

    @Override
    public String getParamsForInsert() {
        return "'" + getSQLDatumVreme(datumIVremePocetka) + "', '" + getSQLDatumVreme(datumIVremeZavrsetka) + "'";
    }

    @Override
    public String setAtrValue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getPrimaryKey() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String alijas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String join() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private java.sql.Timestamp getSQLDatumVreme(Date datumUTIL) {
        return new java.sql.Timestamp(datumUTIL.getTime());
    }
}
