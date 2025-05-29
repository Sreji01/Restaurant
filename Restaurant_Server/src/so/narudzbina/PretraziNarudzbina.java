/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.narudzbina;

import domain.Narudzbina;
import domain.OpstiDomenskiObjekat;
import domain.StavkaNarudzbine;
import java.util.ArrayList;
import java.util.List;
import respository.db.DatabaseBroker;
import so.ApstraktnaSO;

/**
 *
 * @author Sreja
 */
public class PretraziNarudzbina extends ApstraktnaSO {
    private Narudzbina narudzbina;

    @Override
    public void executeOperation(OpstiDomenskiObjekat odo) throws Exception {
        narudzbina = (Narudzbina) DatabaseBroker.getInstance().select((Narudzbina) odo);
        StavkaNarudzbine stavkaNarudzbine = new StavkaNarudzbine();
        stavkaNarudzbine.setNarudzbina(narudzbina);
        List<StavkaNarudzbine> stavkeNarudzbine = (List<StavkaNarudzbine>) (ArrayList<?>) DatabaseBroker.getInstance().selectList(stavkaNarudzbine);
        narudzbina.setStavkeNarudzine(stavkeNarudzbine);
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
    }
    
    public Narudzbina vratiNarudzbinu(){
        return narudzbina;
    }
}
