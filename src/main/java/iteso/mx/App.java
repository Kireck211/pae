package iteso.mx;

import iteso.mx.UI.SalesPanel;

import javax.swing.*;

public class App {

    private Controller theController;
    private Model theModel;
    private View theView;

    public App() {
        theModel = new Model();
        theView = new View();
        theController = new Controller(theModel,theView);
    }

    public static void main(String args[]) {
        App mainApp = new App();
    }

}
