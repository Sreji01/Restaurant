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
public class Gost implements OpstiDomenskiObjekat, Serializable {

    private int idGost;
    private String ime;
    private String prezime;
    private String brojTelefona;
    private Grad grad;

    public Gost() {
    }

    public Gost(int idGost, String ime, String prezime, String brojTelefona, Grad grad) {
        this.idGost = idGost;
        this.ime = ime;
        this.prezime = prezime;
        this.brojTelefona = brojTelefona;
        this.grad = grad;
    }

    public int getIdGost() {
        return idGost;
    }

    public void setIdGost(int idGost) {
        this.idGost = idGost;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Gost other = (Gost) obj;
        if (this.idGost != other.idGost) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        return Objects.equals(this.brojTelefona, other.brojTelefona);
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String getTableName() {
        return "gost";
    }

    @Override
    public String getColumnsForInsert() {
        return "ime, prezime, brojTelefona, idGrad";
    }

    @Override
    public String getParamsForInsert() {
        return "NULL, NULL, NULL, NULL";
    }

    @Override
    public String setAtrValue() {
        return "ime = '" + ime + "', " + "prezime = '" + prezime + "', " + "brojTelefona = '" + brojTelefona + "', " + "idGrad = " + grad.getIdGrad();
    }

    @Override
    public String getPrimaryKey() {
        return "idGost = " + idGost;
    }

    @Override
    public String alijas() {
        return "g";
    }

    @Override
    public String join() {
        return "JOIN grad gr ON g.idGrad = gr.idGrad";
    }

    @Override
    public String getWhereCondition() {
        if(idGost != 0){
            return "g.idGost = " + idGost;
        }
        if (grad != null) {
            return "WHERE g.idGrad = " + grad.getIdGrad();
        }
        return "";
    }

    @Override
    public OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException {
        return new Gost(rs.getInt("g.idGost"), rs.getString("g.ime"), rs.getString("g.prezime"), rs.getString("g.brojTelefona"), 
                new Grad(rs.getInt("gr.idGrad"), rs.getString("gr.naziv"), rs.getInt("gr.brojStanovnika")));
    }

}
