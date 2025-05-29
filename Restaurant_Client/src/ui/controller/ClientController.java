/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.controller;

import communication.Odgovor;
import communication.Operacije;
import communication.Zahtev;
import domain.Gost;
import domain.Grad;
import domain.Jelo;
import domain.Narudzbina;
import domain.TerminDezurstva;
import domain.Zaposleni;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Marko
 */
public class ClientController {

    private Socket socket;

    private static ClientController instance;

    private ClientController() throws Exception {
        try {
            socket = new Socket("localhost", 9000);
        } catch (IOException ex) {
            throw new Exception("Server je ugasen!");
        }
    }

    public static ClientController getInstance() throws Exception {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    private Object posaljiZahtev(Operacije operacija, Object parametar) throws Exception {
        Zahtev zahtev = new Zahtev(operacija, parametar);

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(zahtev);
        ///
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        Odgovor odgovor = (Odgovor) in.readObject();
        if (odgovor.getException() == null) {
            return odgovor.getRezultat();
        } else {
            throw odgovor.getException();
        }
    }

    public List<Grad> vratiListuSviGrad() throws Exception {
        return (List<Grad>) posaljiZahtev(Operacije.VRATI_LISTU_SVI_GRAD, null);
    }

    public Gost kreirajGost(Gost gost) throws Exception {
        return (Gost) posaljiZahtev(Operacije.KREIRAJ_GOST, gost);
    }

    public void promeniGost(Gost gost) throws Exception {
        posaljiZahtev(Operacije.PROMENI_GOST, gost);
    }

    public List<Gost> vratiListuGost(Gost gost) throws Exception {
        return (List<Gost>) posaljiZahtev(Operacije.VRATI_LISTU_GOST, gost);
    }

    public Gost pretraziGost(Gost gost) throws Exception {
        return (Gost) posaljiZahtev(Operacije.PRETRAZI_GOST, gost);
    }

    public void obrisiGost(Gost gost) throws Exception {
        posaljiZahtev(Operacije.OBRISI_GOST, gost);
    }

    public Zaposleni prijaviZaposleni(Zaposleni zaposleni) throws Exception {
        return (Zaposleni) posaljiZahtev(Operacije.PRIJAVI_ZAPOSLENI, zaposleni);
    }

    public List<Zaposleni> vratiListuSviZaposleni() throws Exception {
        return (List<Zaposleni>) posaljiZahtev(Operacije.VRATI_LISTU_SVI_ZAPOSLENI, null);
    }

    public List<Gost> vratiListuSviGost() throws Exception {
        return (List<Gost>) posaljiZahtev(Operacije.VRATI_LISTU_SVI_GOST, null);
    }

    public Narudzbina kreirajNarudzbina(Narudzbina narudzbina) throws Exception {
        return (Narudzbina) posaljiZahtev(Operacije.KREIRAJ_NARUDZBINA, narudzbina);
    }

    public List<Jelo> vratiListuSviJelo() throws Exception {
        return (List<Jelo>) posaljiZahtev(Operacije.VRATI_LISTU_SVI_JELO, null);
    }

    public void promeniNarudzbina(Narudzbina narudzbina) throws Exception {
        posaljiZahtev(Operacije.PROMENI_NARUDZBINA, narudzbina);
    }

    public List<Narudzbina> vratiListuNarudzbina(Narudzbina narudzbina) throws Exception {
        return (List<Narudzbina>) posaljiZahtev(Operacije.VRATI_LISTU_NARUDZBINA, narudzbina);
    }

    public Narudzbina pretraziNarudzbina(Narudzbina narudzbina) throws Exception {
        return (Narudzbina) posaljiZahtev(Operacije.PRETRAZI_NARUDZBINA, narudzbina);
        }

    public List<Narudzbina> vratiListuSviNarudzbina() throws Exception {
        return (List<Narudzbina>) posaljiZahtev(Operacije.VRATI_LISTU_SVI_NARUDZBINA, null);
    }

    public void kreirajTerminDezurstva(TerminDezurstva terminDezurstva) throws Exception {
        posaljiZahtev(Operacije.KREIRAJ_TERMIN_DEZURSTVA, terminDezurstva);
    }
}
