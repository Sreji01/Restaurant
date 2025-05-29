/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.grad;

import domain.Grad;
import domain.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import respository.db.DatabaseBroker;
import so.ApstraktnaSO;

/**
 *
 * @author Sreja
 */
public class VratiListuSviGrad extends ApstraktnaSO {
    private List<Grad> gradovi;

    @Override
    public void executeOperation(OpstiDomenskiObjekat odo) throws Exception {
        gradovi = (List<Grad>) (ArrayList<?>) DatabaseBroker.getInstance().selectList((Grad) odo);
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
    }
    
    public List<Grad> vratiGradove(){
        return gradovi;
    }
}
