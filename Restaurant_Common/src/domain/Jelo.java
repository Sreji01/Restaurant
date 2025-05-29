/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author Sreja
 */
public class Jelo implements OpstiDomenskiObjekat, Serializable{
    private int idJelo;
    private String naziv;
    private String vrstaJela;
    private double cena;

    public Jelo() {
    }

    public Jelo(int idJelo, String naziv, String vrstaJela, double cena) {
        this.idJelo = idJelo;
        this.naziv = naziv;
        this.vrstaJela = vrstaJela;
        this.cena = cena;
    }

    public int getIdJelo() {
        return idJelo;
    }

    public void setIdJelo(int idJelo) {
        this.idJelo = idJelo;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getVrstaJela() {
        return vrstaJela;
    }

    public void setVrstaJela(String vrstaJela) {
        this.vrstaJela = vrstaJela;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
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
        final Jelo other = (Jelo) obj;
        if (this.idJelo != other.idJelo) {
            return false;
        }
        return Objects.equals(this.naziv, other.naziv);
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String getTableName() {
        return "jelo";
    }

    @Override
    public String getColumnsForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getParamsForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        return "j";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public String getWhereCondition() {
        return "";
    }

    @Override
    public OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException {
        return new Jelo(rs.getInt("idJelo"), rs.getString("naziv"), rs.getString("vrstaJela"), rs.getFloat("cena"));
    }
    
    
}
