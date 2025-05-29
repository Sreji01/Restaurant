/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sreja
 */
public interface OpstiDomenskiObjekat {
    public String getTableName();
    public String getColumnsForInsert();
    public String getParamsForInsert();
    public String setAtrValue();
    public String getPrimaryKey();
    public String alijas();
    public String join();
    public String getWhereCondition();
    public OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException;
}
