/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.gost;

import domain.Gost;
import domain.OpstiDomenskiObjekat;
import respository.db.DatabaseBroker;
import so.ApstraktnaSO;

/**
 *
 * @author Sreja
 */
public class PretraziGost extends ApstraktnaSO {
    private Gost gost;

    @Override
    public void executeOperation(OpstiDomenskiObjekat odo) throws Exception {
        gost = (Gost) DatabaseBroker.getInstance().select((Gost) odo);
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
    }
    
    public Gost vratiGosta(){
        return gost;
    }
}
