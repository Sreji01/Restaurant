/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.narudzbina;

import domain.Narudzbina;
import domain.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import respository.db.DatabaseBroker;
import so.ApstraktnaSO;

/**
 *
 * @author Sreja
 */
public class VratiListuNarudzbina extends ApstraktnaSO {

    private List<Narudzbina> narudzbine;

    @Override
    public void executeOperation(OpstiDomenskiObjekat odo) throws Exception {
        narudzbine = (List<Narudzbina>) (ArrayList<?>) DatabaseBroker.getInstance().selectList((Narudzbina) odo);
        System.out.println(narudzbine.size());
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
    }

    public List<Narudzbina> vratiNarudzbine() {
        return narudzbine;
    }
}
