package iteso.mx;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model theModel;
    private View theView;

    public Controller(Model theModel, final View theView) {
        this.theModel = theModel;
        this.theView = theView;

        theView.welcomePanel.addWelcomeJButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                theView.windowPicker.show(theView.windowsPanel, theView.SING_IN_PANEL);
                theView.setSize(new Dimension(400,400));
                theView.setLocationRelativeTo(null);
            }
        });
    }
}
