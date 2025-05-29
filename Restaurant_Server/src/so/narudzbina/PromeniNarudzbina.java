/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.narudzbina;

import domain.Narudzbina;
import domain.OpstiDomenskiObjekat;
import domain.StavkaNarudzbine;
import respository.db.DatabaseBroker;
import so.ApstraktnaSO;

/**
 *
 * @author Sreja
 */
public class PromeniNarudzbina extends ApstraktnaSO {

    @Override
    public void executeOperation(OpstiDomenskiObjekat odo) throws Exception {
        Narudzbina narudzbina = (Narudzbina) odo;
        DatabaseBroker.getInstance().update(narudzbina);
        StavkaNarudzbine sn = new StavkaNarudzbine();
        sn.setNarudzbina(narudzbina);
        DatabaseBroker.getInstance().delete(sn);
        int rb = 1;
        for (StavkaNarudzbine stavkaNarudzbine : narudzbina.getStavkeNarudzine()) {
            stavkaNarudzbine.setNarudzbina(narudzbina);
            stavkaNarudzbine.setRb(rb);
            DatabaseBroker.getInstance().insert(stavkaNarudzbine);
            rb++;
        }
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        Narudzbina narudzbina = (Narudzbina) odo;
        if (!Character.isUpperCase(narudzbina.getStatus().charAt(0))) {
            throw new Exception();
        }
        for (StavkaNarudzbine stavkaNarudzbine : narudzbina.getStavkeNarudzine()) {
            if (stavkaNarudzbine.getKolicina() < 1 || stavkaNarudzbine.getKolicina() > 50) {
                throw new Exception();
            }
            if (!Character.isUpperCase(stavkaNarudzbine.getNapomena().charAt(0))) {
                throw new Exception();
            }
        }
    }
}
