/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import respository.db.DatabaseBroker;

/**
 *
 * @author Sreja
 */
public abstract class ApstraktnaSO {
    
    public void execute(OpstiDomenskiObjekat odo) throws Exception{
        try {
            validate(odo);
            executeOperation(odo);
            commit();
        } catch (Exception ex) {
            rollback();
            throw ex;
        }
    }
    
    public abstract void executeOperation(OpstiDomenskiObjekat odo) throws Exception;
    
    protected abstract void validate(OpstiDomenskiObjekat odo) throws Exception;
    
    private void commit() throws Exception{
        DatabaseBroker.getInstance().getConnection().commit();
    }
    
    private void rollback() throws Exception{
        DatabaseBroker.getInstance().getConnection().rollback();
    }
}
