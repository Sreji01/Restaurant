/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.zaposleni;

import domain.OpstiDomenskiObjekat;
import domain.Zaposleni;
import java.util.ArrayList;
import java.util.List;
import respository.db.DatabaseBroker;
import so.ApstraktnaSO;

/**
 *
 * @author Sreja
 */
public class VratiListuSviZaposleni extends ApstraktnaSO {
    private List<Zaposleni> zaposleni;

    @Override
    public void executeOperation(OpstiDomenskiObjekat odo) throws Exception {
        zaposleni = (List<Zaposleni>) (ArrayList<?>) DatabaseBroker.getInstance().selectList((Zaposleni) odo);
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
    }
    
    public List<Zaposleni> vratiZaposlene(){
        return zaposleni;
    }
}
