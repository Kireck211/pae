package iteso.mx.DataBaseConnection;

public class Commons {
    public static String USER 		= "acer1"; //aquí es el nombre del usuario
    public static String PASSWORD 	= "ItesoLTI10"; //aquí se pone el password

    private static String IP = "localhost";
    private static String PORT = "3306";
    private static String SERVER = IP+":"+PORT+"/";
    //jdbc:mysql://localhost:3306/
    public static String URL 		= "jdbc:mysql://"+SERVER; //"jdbc:sqlserver://localhost:1433"; //
    public static String DBNAME 	= "AUTOBUS"; //aquí es el nombre de la base de datos
    public static String DRIVER 	= "com.mysql.jdbc.Driver"; //"com.microsoft.jdbc.sqlserver.SQLServerDriver"; //

}