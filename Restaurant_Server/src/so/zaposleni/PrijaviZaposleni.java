/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.zaposleni;

import domain.OpstiDomenskiObjekat;
import domain.Zaposleni;
import respository.db.DatabaseBroker;
import so.ApstraktnaSO;

/**
 *
 * @author Sreja
 */
public class PrijaviZaposleni extends ApstraktnaSO {
    private Zaposleni zaposleni;

    @Override
    public void executeOperation(OpstiDomenskiObjekat odo) throws Exception {
        zaposleni = (Zaposleni) DatabaseBroker.getInstance().select((Zaposleni) odo);
        if(zaposleni.getIdZaposleni()== 0){
            throw new Exception();
        }
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
    }
    
    public Zaposleni vratiZaposlenog(){
        return zaposleni;
    }
}
