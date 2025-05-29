/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Sreja
 */
public class Narudzbina implements OpstiDomenskiObjekat, Serializable {

    private int idNarudzbina;
    private double ukupanIznos;
    private Date datumIVreme;
    private String status;
    private Zaposleni zaposleni;
    private Gost gost;
    private List<StavkaNarudzbine> stavkeNarudzine;

    public Narudzbina() {
    }

    public Narudzbina(Date datumIVreme, String status, Zaposleni zaposleni, Gost gost, List<StavkaNarudzbine> stavkeNarudzine) {
        this.datumIVreme = datumIVreme;
        this.status = status;
        this.zaposleni = zaposleni;
        this.gost = gost;
        this.stavkeNarudzine = stavkeNarudzine;
        this.ukupanIznos = 0;
            for (StavkaNarudzbine stavkaNarudzbine : stavkeNarudzine) {
                this.ukupanIznos += stavkaNarudzbine.getIznos();
        }
    }

    public Narudzbina(int idNarudzbina, double ukupanIznos, Date datumIVreme, String status, Zaposleni zaposleni, Gost gost, List<StavkaNarudzbine> stavkeNarudzine) {
        this.idNarudzbina = idNarudzbina;
        this.ukupanIznos = ukupanIznos;
        this.datumIVreme = datumIVreme;
        this.status = status;
        this.zaposleni = zaposleni;
        this.gost = gost;
        this.stavkeNarudzine = stavkeNarudzine;
    }

    public int getIdNarudzbina() {
        return idNarudzbina;
    }

    public void setIdNarudzbina(int idNarudzbina) {
        this.idNarudzbina = idNarudzbina;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public Date getDatumIVreme() {
        return datumIVreme;
    }

    public void setDatumIVreme(Date datumIVreme) {
        this.datumIVreme = datumIVreme;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Gost getGost() {
        return gost;
    }

    public void setGost(Gost gost) {
        this.gost = gost;
    }

    public List<StavkaNarudzbine> getStavkeNarudzine() {
        return stavkeNarudzine;
    }

    public void setStavkeNarudzine(List<StavkaNarudzbine> stavkeNarudzine) {
        this.stavkeNarudzine = stavkeNarudzine;
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
        final Narudzbina other = (Narudzbina) obj;
        if (this.idNarudzbina != other.idNarudzbina) {
            return false;
        }
        return Objects.equals(this.datumIVreme, other.datumIVreme);
    }

    @Override
    public String toString() {
        return "Narudzbina{" + "idNarudzbina=" + idNarudzbina + ", ukupanIznos=" + ukupanIznos + ", datumIVreme=" + datumIVreme + ", status=" + status + ", zaposleni=" + zaposleni + ", gost=" + gost + ", stavkeNarudzine=" + stavkeNarudzine + '}';
    }

    @Override
    public String getTableName() {
        return "narudzbina";
    }

    @Override
    public String getColumnsForInsert() {
        return "datumIVreme, status, ukupanIznos, idZaposleni, idGost";
    }

    @Override
    public String getParamsForInsert() {
        return "NULL, NULL, NULL, NULL, NULL";
    }

    @Override
    public String setAtrValue() {
        return "datumIVreme = '" + getSQLDatumVreme(datumIVreme) + "', " + "status = '" + status + "', " + "ukupanIznos = " + ukupanIznos + ", "
                + "idZaposleni = " + zaposleni.getIdZaposleni() + ", " + "idGost = " + gost.getIdGost();
    }

    @Override
    public String getPrimaryKey() {
        return "idNarudzbina = " + idNarudzbina;
    }

    @Override
    public String alijas() {
        return "n";
    }

    @Override
    public String join() {
        return "join zaposleni z on n.idZaposleni = z.idZaposleni join gost g on n.idGost = g.idGost join grad gr on g.idGrad = gr.idGrad";
    }

    @Override
    public String getWhereCondition() {
        if (idNarudzbina != 0) {
            return "n.idNarudzbina = " + idNarudzbina;
        }
        if (zaposleni != null && gost != null) {
            return "WHERE n.idZaposleni = " + zaposleni.getIdZaposleni() + " AND n.idGost = " + gost.getIdGost();
        }
        if (zaposleni != null) {
            return "WHERE n.idZaposleni = " + zaposleni.getIdZaposleni();
        }
        if (gost != null) {
            return "WHERE n.idGost = " + gost.getIdGost();
        }
        return "";
    }

    @Override
    public OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException {
        return new Narudzbina(rs.getInt("n.idNarudzbina"), rs.getFloat("n.ukupanIznos"), getUTILDatumVreme(rs.getTimestamp("n.datumIVreme")), rs.getString("n.status"),
                new Zaposleni(rs.getInt("z.idZaposleni"), rs.getString("z.ime"), rs.getString("z.prezime"), rs.getString("z.korisnickoIme"), rs.getString("z.sifra")),
                new Gost(rs.getInt("g.idGost"), rs.getString("g.ime"), rs.getString("g.prezime"), rs.getString("g.brojTelefona"),
                        new Grad(rs.getInt("gr.idGrad"), rs.getString("gr.naziv"), rs.getInt("gr.brojStanovnika"))), null);
    }

    private java.sql.Timestamp getSQLDatumVreme(Date datumUTIL) {
        return new java.sql.Timestamp(datumUTIL.getTime());
    }

    private java.util.Date getUTILDatumVreme(java.sql.Timestamp datumSQL) {
        return new java.util.Date(datumSQL.getTime());
    }

}
