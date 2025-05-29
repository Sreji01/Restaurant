/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.terminDezurstva;

import domain.OpstiDomenskiObjekat;
import domain.TerminDezurstva;
import java.util.Date;
import respository.db.DatabaseBroker;
import so.ApstraktnaSO;

/**
 *
 * @author Sreja
 */
public class KreirajTerminDezurstva extends ApstraktnaSO {

    @Override
    public void executeOperation(OpstiDomenskiObjekat odo) throws Exception {
        DatabaseBroker.getInstance().insert((TerminDezurstva) odo);
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        TerminDezurstva terminDezurstva = (TerminDezurstva) odo;
        if(terminDezurstva.getDatumIVremePocetka().before(new Date())){
            throw new Exception();
        }
        if (terminDezurstva.getDatumIVremeZavrsetka().before(terminDezurstva.getDatumIVremePocetka())) {
            throw new Exception();
        }
    }

}
