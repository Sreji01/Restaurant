/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.jelo;

import domain.Jelo;
import domain.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import respository.db.DatabaseBroker;
import so.ApstraktnaSO;

/**
 *
 * @author Sreja
 */
public class VratiListuSviJelo extends ApstraktnaSO {
    private List<Jelo> jela;

    @Override
    public void executeOperation(OpstiDomenskiObjekat odo) throws Exception {
        jela = (List<Jelo>) (ArrayList<?>) DatabaseBroker.getInstance().selectList((Jelo) odo);
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
    }
    
    public List<Jelo> vratiJela(){
        return jela;
    }
}
