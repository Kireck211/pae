package iteso.mx;


import javax.swing.*;
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
                theView.setSize(new Dimension(500, 500));
                theView.setLocationRelativeTo(null);
            }
        });

        theView.singInPanel.addSignInListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = theView.singInPanel.getUserJTextField();
                String password = theView.singInPanel.getPasswordJTextField();
                if(isUserPasswordCorrect(userName, password)){
                    showSalesPanel();
                }
            }
        });

        theView.singInPanel.addForgottenPasswordListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                theModel.sendEmail.sendMessage();
            }
        });

        theView.singInPanel.addKeyListeners(new KeyListener() {
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {

            }

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String user = theView.singInPanel.getUserJTextField();
                    String password = theView.singInPanel.getPasswordJTextField();
                    if (isUserPasswordCorrect(user, password)) {
                        showSalesPanel();
                    }
                }
            }
        }, new KeyListener() {
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {

            }

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String user = theView.singInPanel.getUserJTextField();
                    String password = theView.singInPanel.getPasswordJTextField();
                    if (isUserPasswordCorrect(user, password)) {
                        showSalesPanel();
                    }
                }
            }
        });
    }

    public void addRegistrationActionListeners() {
        theView.registrationPanel.addOkListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                theView.registrationPanel.eraseData();
                String userName = theView.registrationPanel.getUserTextField();
                String password = theView.registrationPanel.getPasswordTextField();
                if(isUserNameAccepted(userName)) {
                    if(isPasswordSecure(password)) {

                    }
                    else {

                    }
                } else {

                }

                theView.windowPicker.show(theView.windowsPanel, theView.WELCOME_PANEL);
                theView.windowPicker.show(theView.windowsPanel, theView.WELCOME_PANEL);
                theView.setSize(new Dimension(500,500));
                theView.setLocationRelativeTo(null);
            }
        });

        theView.registrationPanel.addCancelListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                theView.registrationPanel.eraseData();
                theView.windowPicker.show(theView.windowsPanel, theView.WELCOME_PANEL);
                theView.windowPicker.show(theView.windowsPanel, theView.WELCOME_PANEL);
                theView.setSize(new Dimension(500,500));
                theView.setLocationRelativeTo(null);
            }
        });
    }

    public boolean isUserNameAccepted(String userName) {
        return true;
    }

    public boolean isPasswordSecure(String password) {
        return true;
    }

    public boolean isUserPasswordCorrect(String user, String password) {
        String realPass = theModel.getPassword(user);
        if (realPass != "No connection" && realPass != "" && realPass.equals(password)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Usuario y/o contraseña son incorrectos", "Información incorrecta", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void addStates() {
        theView.salesPanel.sellPanel.addStates(theModel.getStates());
    }

    public void addCities() {
        int selectedItem = theView.salesPanel.sellPanel.stateComboBox.getSelectedIndex();
        int index = theView.salesPanel.sellPanel.stateIDs.get(selectedItem);
        theView.salesPanel.sellPanel.addCities(theModel.getCities(index));
    }

    public void addSellActionListeners() {

        theView.salesPanel.sellPanel.addStateComboBoxActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                System.out.println(theView.salesPanel.sellPanel.stateComboBox.getSelectedIndex());
                addCities();
            }
        });
    }

    public void showSalesPanel() {
        theView.windowPicker.show(theView.windowsPanel, theView.SALES_PANEL);
        theView.setSize(new Dimension(500,500));
        theView.setLocationRelativeTo(null);
        addStates();
        addSellActionListeners();
    }
}
