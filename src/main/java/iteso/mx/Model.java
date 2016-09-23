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
}
