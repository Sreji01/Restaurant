/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.gost;

import domain.Gost;
import domain.OpstiDomenskiObjekat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import respository.db.DatabaseBroker;
import so.ApstraktnaSO;

/**
 *
 * @author Sreja
 */
public class KreirajGost extends ApstraktnaSO {

    private Gost gost;

    @Override
    public void executeOperation(OpstiDomenskiObjekat odo) throws Exception {
        PreparedStatement ps = DatabaseBroker.getInstance().insert((Gost) odo);
        ResultSet resultSet = ps.getGeneratedKeys();
        resultSet.next();
        int idGost = resultSet.getInt(1);
        gost = new Gost();
        gost.setIdGost(idGost);
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
    }

    public Gost vratiGosta() {
        return gost;
    }
}
