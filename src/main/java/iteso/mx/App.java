package iteso.mx;

public class App {

    private Controller theController;
    private Model theModel;
    private View theView;

    public App() {
        theModel = new Model();
        theView = new View();
        theController = new Controller(theModel,theView);
        connect();

    }

    public static void main(String args[]) {
        App mainApp = new App();

    }

    public void connect() {
        theModel.ds.setIntegratedSecurity(true);
        theModel.ds.setServerName("localhost");
        theModel.ds.setPortNumber(1433);
        theModel.ds.setDatabaseName("Lab1");
        try {
            theModel.con = theModel.ds.getConnection();
        } catch (Exception e) {

        }
    }
}
