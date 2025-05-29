/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sreja
 */
public class StavkaNarudzbine implements OpstiDomenskiObjekat, Serializable{
    private Narudzbina narudzbina;
    private int rb;
    private double cena;
    private int kolicina;
    private double iznos;
    private String napomena;
    private Jelo jelo;

    public StavkaNarudzbine() {
    }

    public StavkaNarudzbine(Narudzbina narudzbina, int rb, double cena, int kolicina, double iznos, String napomena, Jelo jelo) {
        this.narudzbina = narudzbina;
        this.rb = rb;
        this.cena = cena;
        this.kolicina = kolicina;
        this.iznos = iznos;
        this.napomena = napomena;
        this.jelo = jelo;
    }

    public Narudzbina getNarudzbina() {
        return narudzbina;
    }

    public void setNarudzbina(Narudzbina narudzbina) {
        this.narudzbina = narudzbina;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Jelo getJelo() {
        return jelo;
    }

    public void setJelo(Jelo jelo) {
        this.jelo = jelo;
    }

    @Override
    public String toString() {
        return "StavkaNarudzbine{" + "narudzbina=" + narudzbina + ", rb=" + rb + ", cena=" + cena + ", kolicina=" + kolicina + ", iznos=" + iznos + ", napomena=" + napomena + ", jelo=" + jelo + '}';
    }

    @Override
    public String getTableName() {
        return "stavka_narudzbine";
    }

    @Override
    public String getColumnsForInsert() {
        return "idNarudzbina, rb, idJelo, cena, kolicina, iznos, napomena";
    }

    @Override
    public String getParamsForInsert() {
        return narudzbina.getIdNarudzbina() + ", " + rb + ", " + jelo.getIdJelo() + ", " + cena + ", " + kolicina + ", " + iznos + ", '" + napomena + "'";
    }

    @Override
    public String setAtrValue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getPrimaryKey() {
        return "idNarudzbina = " + narudzbina.getIdNarudzbina();
    }

    @Override
    public String alijas() {
        return "sn";
    }

    @Override
    public String join() {
        return "JOIN narudzbina n ON sn.idNarudzbina = n.idNarudzbina "
                + "JOIN zaposleni z ON n.idZaposleni = z.idZaposleni JOIN gost g ON n.idGost = g.idGost "
                + "JOIN grad gr ON g.idGrad = gr.idGrad JOIN jelo j ON sn.idJelo = j.idJelo";
    }

    @Override
    public String getWhereCondition() {
        return "WHERE sn.idNarudzbina = " + narudzbina.getIdNarudzbina();
    }

    @Override
    public OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException {
        return new StavkaNarudzbine(new Narudzbina(rs.getInt("n.idNarudzbina"), rs.getFloat("n.ukupanIznos"), getUTILDatumVreme(rs.getTimestamp("n.datumIVreme")), rs.getString("n.status"),
                new Zaposleni(rs.getInt("z.idZaposleni"), rs.getString("z.ime"), rs.getString("z.prezime"), rs.getString("z.korisnickoIme"), rs.getString("z.sifra")),
                new Gost(rs.getInt("g.idGost"), rs.getString("g.ime"), rs.getString("g.prezime"), rs.getString("g.brojTelefona"),
                        new Grad(rs.getInt("gr.idGrad"), rs.getString("gr.naziv"), rs.getInt("gr.brojStanovnika"))), null), rs.getInt("sn.rb"), rs.getFloat("sn.cena"), 
                rs.getInt("sn.kolicina"), rs.getFloat("sn.iznos"), rs.getString("sn.napomena"), new Jelo(rs.getInt("j.idJelo"), rs.getString("j.naziv"), 
                        rs.getString("j.vrstaJela"), rs.getFloat("j.cena")));
    }
    
    private java.util.Date getUTILDatumVreme(java.sql.Timestamp datumSQL) {
        return new java.util.Date(datumSQL.getTime());
    }
    
}
