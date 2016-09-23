package iteso.mx;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;


/**
 * Created by Erick on 23/09/2016.
 */
public class Model {

    public Connection con = null;
    public CallableStatement cstmt = null;
    public ResultSet rs = null;
    public SQLServerDataSource ds;

    public Model() {
        ds = new SQLServerDataSource();
    }
/*
    try {
        // Establish the connection.
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setIntegratedSecurity(true);
        ds.setServerName("localhost");
        ds.setPortNumber(1433);
        ds.setDatabaseName("AdventureWorks");
        con = ds.getConnection();
    }

    // Handle any errors that may have occurred.
	    	catch (Exception e) {
        e.printStackTrace();
    }

	   	finally {
        if (rs != null) try { rs.close(); } catch(Exception e) {}
        if (cstmt != null) try { cstmt.close(); } catch(Exception e) {}
        if (con != null) try { con.close(); } catch(Exception e) {}
    }*/

}
