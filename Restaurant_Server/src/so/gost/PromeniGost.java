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
public class PromeniGost extends ApstraktnaSO {

    @Override
    public void executeOperation(OpstiDomenskiObjekat odo) throws Exception {
        DatabaseBroker.getInstance().update((Gost) odo);
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        Gost gost = (Gost) odo;
        if (!gost.getIme().matches("[A-Za-z]+")) {
            throw new Exception();
        }
        if (!Character.isUpperCase(gost.getIme().charAt(0))) {
            throw new Exception();
        }
        if (!gost.getPrezime().matches("[A-Za-z]+")) {
            throw new Exception();
        }
        if (!Character.isUpperCase(gost.getPrezime().charAt(0))) {
            throw new Exception();
        }
        if (!gost.getBrojTelefona().matches("[0-9]+")) {
            throw new Exception();
        }
        if (gost.getBrojTelefona().length() < 9 || gost.getBrojTelefona().length() > 10) {
            throw new Exception();
        }
    }
}
