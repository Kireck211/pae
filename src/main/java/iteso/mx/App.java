package iteso.mx;

public class App {

    private Controller theController;
    private Model theModel;
    private View theView;

    public App() {
        theController = new Controller();
        theModel = new Model();
        theView = new View();
    }

    public static void main(String args[]) {
        App mainApp = new App();
    }
}
