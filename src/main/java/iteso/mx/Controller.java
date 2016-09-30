package iteso.mx;


import java.awt.*;
import java.awt.event.*;

public class Controller {
    private Model theModel;
    private View theView;

    public Controller(final Model theModel, final View theView) {
        this.theModel = theModel;
        this.theView = theView;
        addActionListeners();
    }

    public void addActionListeners() {
        addWelcomeActionListeners();
        addSignInActionListeners();
        addRegistrationActionListeners();
        theView.addWindowListener(new WindowListener() {
            public void windowOpened(WindowEvent e) {

            }

            public void windowClosing(WindowEvent e) {
                theModel.closeConnection();
            }

            public void windowClosed(WindowEvent e) {

            }

            public void windowIconified(WindowEvent e) {

            }

            public void windowDeiconified(WindowEvent e) {

            }

            public void windowActivated(WindowEvent e) {

            }

            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    public void addWelcomeActionListeners() {
        theView.welcomePanel.addSignInListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                theView.windowPicker.show(theView.windowsPanel, theView.SING_IN_PANEL);
                theView.setSize(new Dimension(400,400));
                theView.setLocationRelativeTo(null);
            }
        });

        theView.welcomePanel.addSignUpListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                theView.windowPicker.show(theView.windowsPanel, theView.REGISTRATION_PANEL);
                theView.setSize(new Dimension(300,300));
                theView.setLocationRelativeTo(null);
            }
        });
    }

    public void addSignInActionListeners() {
        theView.singInPanel.addCancelListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                theView.singInPanel.eraseData();
                theView.windowPicker.show(theView.windowsPanel, theView.WELCOME_PANEL);
                theView.setSize(new Dimension(500,500));
                theView.setLocationRelativeTo(null);
            }
        });

        theView.singInPanel.addSignInListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        theView.singInPanel.addForgottenPasswordListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                theModel.sendEmail.sendMessage();
            }
        });
    }

    public void addRegistrationActionListeners() {
        theView.registrationPanel.addOkListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                theView.windowPicker.show(theView.windowsPanel, theView.WELCOME_PANEL);
                theView.windowPicker.show(theView.windowsPanel, theView.WELCOME_PANEL);
                theView.setSize(new Dimension(500,500));
                theView.setLocationRelativeTo(null);
            }
        });

        theView.registrationPanel.addCancelListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                theView.windowPicker.show(theView.windowsPanel, theView.WELCOME_PANEL);
                theView.windowPicker.show(theView.windowsPanel, theView.WELCOME_PANEL);
                theView.setSize(new Dimension(500,500));
                theView.setLocationRelativeTo(null);
            }
        });
    }
}
