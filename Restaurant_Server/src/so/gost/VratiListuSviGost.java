/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.gost;

import domain.Gost;
import domain.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import respository.db.DatabaseBroker;
import so.ApstraktnaSO;

/**
 *
 * @author Sreja
 */
public class VratiListuSviGost extends ApstraktnaSO {
    private List<Gost> gosti;

    @Override
    public void executeOperation(OpstiDomenskiObjekat odo) throws Exception {
        gosti = (List<Gost>) (ArrayList<?>) DatabaseBroker.getInstance().selectList((Gost) odo);
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
    }
    
    public List<Gost> vratiGoste(){
        return gosti;
    }
}
