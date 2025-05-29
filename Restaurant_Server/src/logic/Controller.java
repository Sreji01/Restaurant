/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.Gost;
import domain.Grad;
import domain.Jelo;
import domain.Narudzbina;
import domain.TerminDezurstva;
import domain.Zaposleni;
import java.util.List;
import so.gost.KreirajGost;
import so.gost.ObrisiGost;
import so.gost.PretraziGost;
import so.gost.PromeniGost;
import so.gost.VratiListuGost;
import so.gost.VratiListuSviGost;
import so.grad.VratiListuSviGrad;
import so.jelo.VratiListuSviJelo;
import so.narudzbina.KreirajNarudzbina;
import so.narudzbina.PretraziNarudzbina;
import so.narudzbina.PromeniNarudzbina;
import so.narudzbina.VratiListuNarudzbina;
import so.narudzbina.VratiListuSviNarudzbina;
import so.terminDezurstva.KreirajTerminDezurstva;
import so.zaposleni.PrijaviZaposleni;
import so.zaposleni.VratiListuSviZaposleni;

/**
 *
 * @author Sreja
 */
public class Controller {

    private static Controller instance;
    //private List<Bibliotekar> trenutnoUlogovani = new ArrayList<>();
    //private List<Bibliotekar> bibliotekari = new ArrayList<>();
    private int MaksBrojKlijenata;

    private Controller() {
        /*Bibliotekar b1 = new Bibliotekar(1, "pera", "pera");
        Bibliotekar b2 = new Bibliotekar(2, "zika", "zika");
        Bibliotekar b3 = new Bibliotekar(3, "mile", "mile");
        bibliotekari.add(b1);
        bibliotekari.add(b2);
        bibliotekari.add(b3);*/

    }

    public int getMaksBrojKlijenata() {
        return MaksBrojKlijenata;
    }

    public void setMaksBrojKlijenata(int MaksBrojKlijenata) {
        this.MaksBrojKlijenata = MaksBrojKlijenata;
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public List<Grad> vratiListuSviGrad() throws Exception {
        VratiListuSviGrad vratiListuSviGrad = new VratiListuSviGrad();
        vratiListuSviGrad.execute(new Grad());
        return vratiListuSviGrad.vratiGradove();
    }

    public Gost kreirajGost(Gost gost) throws Exception {
        KreirajGost kreirajGost = new KreirajGost();
        kreirajGost.execute(gost);
        return kreirajGost.vratiGosta();
    }

    public void promeniGost(Gost gost) throws Exception {
        PromeniGost promeniGost = new PromeniGost();
        promeniGost.execute(gost);
    }

    public List<Gost> vratiListuGost(Gost gost) throws Exception {
        VratiListuGost vratiListuGost = new VratiListuGost();
        vratiListuGost.execute(gost);
        return vratiListuGost.vratiGoste();
    }

    public Gost pretraziGost(Gost gost) throws Exception {
        PretraziGost pretraziGost = new PretraziGost();
        pretraziGost.execute(gost);
        return pretraziGost.vratiGosta();
    }

    public void obrisiGost(Gost gost) throws Exception {
        ObrisiGost obrisiGost = new ObrisiGost();
        obrisiGost.execute(gost);
    }

    public Zaposleni prijaviZaposleni(Zaposleni zaposleni) throws Exception {
        PrijaviZaposleni prijaviZaposleni = new PrijaviZaposleni();
        prijaviZaposleni.execute(zaposleni);
        return prijaviZaposleni.vratiZaposlenog();
    }

    public List<Zaposleni> vratiListuSviZaposleni() throws Exception {
        VratiListuSviZaposleni vratiListuSviZaposleni = new VratiListuSviZaposleni();
        vratiListuSviZaposleni.execute(new Zaposleni());
        return vratiListuSviZaposleni.vratiZaposlene();
    }

    public List<Gost> vratiListuSviGost() throws Exception {
        VratiListuSviGost vratiListuSviGost = new VratiListuSviGost();
        vratiListuSviGost.execute(new Gost());
        return vratiListuSviGost.vratiGoste();
    }

    public Narudzbina kreirajNarudzbina(Narudzbina narudzbina) throws Exception {
        KreirajNarudzbina kreirajNarudzbina = new KreirajNarudzbina();
        kreirajNarudzbina.execute(narudzbina);
        return kreirajNarudzbina.vratiNarudzbinu();
    }

    public List<Jelo> vratiListuSviJelo() throws Exception {
        VratiListuSviJelo vratiListuSviJelo = new VratiListuSviJelo();
        vratiListuSviJelo.execute(new Jelo());
        return vratiListuSviJelo.vratiJela();
    }

    public void promeniNarudzbina(Narudzbina narudzbina) throws Exception {
        PromeniNarudzbina promeniNarudzbina = new PromeniNarudzbina();
        promeniNarudzbina.execute(narudzbina);
    }

    public List<Narudzbina> vratiListuNarudzbina(Narudzbina narudzbina) throws Exception {
        VratiListuNarudzbina vratiListuNarudzbina = new VratiListuNarudzbina();
        vratiListuNarudzbina.execute(narudzbina);
        return vratiListuNarudzbina.vratiNarudzbine();
    }

    public Narudzbina pretraziNarudzbina(Narudzbina narudzbina) throws Exception {
        PretraziNarudzbina pretraziNarudzbina = new PretraziNarudzbina();
        pretraziNarudzbina.execute(narudzbina);
        return pretraziNarudzbina.vratiNarudzbinu();
    }

    public List<Narudzbina> vratiListuSviNarudzbina() throws Exception {
        VratiListuSviNarudzbina vratiListuSviNarudzbina = new VratiListuSviNarudzbina();
        vratiListuSviNarudzbina.execute(new Narudzbina());
        return vratiListuSviNarudzbina.vratiNarudzbine();
    }

    public void kreirajTerminDezurstva(TerminDezurstva terminDezurstva) throws Exception {
        KreirajTerminDezurstva kreirajTerminDezurstva = new KreirajTerminDezurstva();
        kreirajTerminDezurstva.execute(terminDezurstva);
    }

}
