/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.narudzbina;

import domain.Narudzbina;
import domain.OpstiDomenskiObjekat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import respository.db.DatabaseBroker;
import so.ApstraktnaSO;

/**
 *
 * @author Sreja
 */
public class KreirajNarudzbina extends ApstraktnaSO {
    private Narudzbina narudzbina;

    @Override
    public void executeOperation(OpstiDomenskiObjekat odo) throws Exception {
        PreparedStatement ps = DatabaseBroker.getInstance().insert((Narudzbina) odo);
        ResultSet resultSet = ps.getGeneratedKeys();
        resultSet.next();
        int idNarudzbina = resultSet.getInt(1);
        narudzbina = new Narudzbina();
        narudzbina.setIdNarudzbina(idNarudzbina);
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
    }
    
    public Narudzbina vratiNarudzbinu(){
        return narudzbina;
    }
}
