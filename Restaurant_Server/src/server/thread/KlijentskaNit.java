/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server.thread;

import communication.Odgovor;

import communication.Zahtev;
import domain.Gost;
import domain.Grad;
import domain.Jelo;
import domain.Narudzbina;
import domain.TerminDezurstva;
import domain.Zaposleni;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import logic.Controller;

/**
 *
 * @author Sreja
 */
public class KlijentskaNit extends Thread {

    private Socket clientSocket;

    public KlijentskaNit() {
    }

    public KlijentskaNit(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            while (!clientSocket.isClosed()) {
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                Zahtev zahtev = (Zahtev) in.readObject();
                Odgovor odgovor = obradiZahtev(zahtev);
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                out.writeObject(odgovor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Odgovor obradiZahtev(Zahtev zahtev) {
        Odgovor odgovor = new Odgovor();
        List<Grad> gradovi;
        List<Gost> gosti;
        List<Zaposleni> listaZaposlenih;
        List<Jelo> jela;
        List<Narudzbina> narudzbine;
        Gost gost;
        Zaposleni zaposleni;
        Narudzbina narudzbina;
        try {
            switch (zahtev.getOperacija()) {
                case VRATI_LISTU_SVI_GRAD:
                    gradovi = Controller.getInstance().vratiListuSviGrad();
                    odgovor.setRezultat(gradovi);
                    break;
                case KREIRAJ_GOST:
                    gost = Controller.getInstance().kreirajGost((Gost) zahtev.getParametar());
                    odgovor.setRezultat(gost);
                    break;
                case PROMENI_GOST:
                    Controller.getInstance().promeniGost((Gost) zahtev.getParametar());
                    break;
                case VRATI_LISTU_GOST:
                    gosti = Controller.getInstance().vratiListuGost((Gost) zahtev.getParametar());
                    odgovor.setRezultat(gosti);
                    break;
                case PRETRAZI_GOST:
                    gost = Controller.getInstance().pretraziGost((Gost) zahtev.getParametar());
                    odgovor.setRezultat(gost);
                    break;
                case OBRISI_GOST:
                    Controller.getInstance().obrisiGost((Gost) zahtev.getParametar());
                    break;
                case PRIJAVI_ZAPOSLENI:
                    zaposleni = Controller.getInstance().prijaviZaposleni((Zaposleni) zahtev.getParametar());
                    odgovor.setRezultat(zaposleni);
                    break;
                case VRATI_LISTU_SVI_ZAPOSLENI:
                    listaZaposlenih = Controller.getInstance().vratiListuSviZaposleni();
                    odgovor.setRezultat(listaZaposlenih);
                    break;
                case VRATI_LISTU_SVI_GOST:
                    gosti = Controller.getInstance().vratiListuSviGost();
                    odgovor.setRezultat(gosti);
                    break;
                case KREIRAJ_NARUDZBINA:
                    narudzbina = Controller.getInstance().kreirajNarudzbina((Narudzbina) zahtev.getParametar());
                    odgovor.setRezultat(narudzbina);
                    break;
                case VRATI_LISTU_SVI_JELO:
                    jela = Controller.getInstance().vratiListuSviJelo();
                    odgovor.setRezultat(jela);
                    break;
                case PROMENI_NARUDZBINA:
                    Controller.getInstance().promeniNarudzbina((Narudzbina) zahtev.getParametar());
                    break;
                case VRATI_LISTU_NARUDZBINA:
                    narudzbine = Controller.getInstance().vratiListuNarudzbina((Narudzbina) zahtev.getParametar());
                    odgovor.setRezultat(narudzbine);
                    break;
                case PRETRAZI_NARUDZBINA:
                    narudzbina = Controller.getInstance().pretraziNarudzbina((Narudzbina) zahtev.getParametar());
                    odgovor.setRezultat(narudzbina);
                    break;
                case VRATI_LISTU_SVI_NARUDZBINA:
                    narudzbine = Controller.getInstance().vratiListuSviNarudzbina();
                    odgovor.setRezultat(narudzbine);
                    break;
                case KREIRAJ_TERMIN_DEZURSTVA:
                    Controller.getInstance().kreirajTerminDezurstva((TerminDezurstva) zahtev.getParametar());
                    break;
                default:
                    throw new AssertionError();
            }

        } catch (Exception e) {
            odgovor.setException(e);
        }
        return odgovor;
    }

}
