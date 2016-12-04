package iteso.mx;


import iteso.mx.Models.Client;
import iteso.mx.UI.ClientCreationPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Controller {

    private Model theModel;
    private View theView;
    public static final int SOURCE_CITIES = 0;
    public static final int DESTINATION_CITIES = 1;

    public Controller(final Model theModel, final View theView) {
        this.theModel = theModel;
        this.theView = theView;
        addActionListeners();
    }

    public void addActionListeners() {
        addWelcomeActionListeners();
        addSignInActionListeners();
        addRegistrationActionListeners();
        addGlobalActionListeners();
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

    public void addGlobalActionListeners() {
        theView.salesPanel.header.cerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                theView.windowPicker.show(theView.windowsPanel, theView.SING_IN_PANEL);
                theView.setSize(400,400);
                theView.setLocationRelativeTo(null);
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
                theView.setSize(new Dimension(400,400));
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
                    int idEmployee = theModel.getIDEmployeeDB(userName);
                    theModel.setIDEmployee(idEmployee);
                    showSalesPanel();
                }
            }
        });

        theView.singInPanel.addForgottenPasswordListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
                        int idEmployee = theModel.getIDEmployeeDB(user);
                        theModel.setIDEmployee(idEmployee);
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
                String user = theView.registrationPanel.getUserTextField();
                String password = theView.registrationPanel.getPasswordTextField();
                String name = theView.registrationPanel.getNameTF();
                String apP = theView.registrationPanel.getApTF();
                String apM = theView.registrationPanel.getAmTF();
                String gender = theView.registrationPanel.getGenderTF().substring(0,1);
                if(validateNewEmployee()) {

                } else {

                }
                theModel.insertClient(user, password, name, apP, apM, gender);


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

    public void addCities(int cities) {
        int index;
        if(cities == SOURCE_CITIES) {
            index = theView.salesPanel.sellPanel.srcStateIDs.get(theView.salesPanel.sellPanel.srcStateComboBox.getSelectedIndex());
            theView.salesPanel.sellPanel.addSrcCities(theModel.getCities(index));
        }
        else {
            index = theView.salesPanel.sellPanel.destStateIDs.get(theView.salesPanel.sellPanel.destStateComboBox.getSelectedIndex());
            theView.salesPanel.sellPanel.addDestCities(theModel.getCities(index));
        }
    }

    public void addSellActionListeners() {

        theView.salesPanel.sellPanel.addSrcStateComboBoxActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addCities(SOURCE_CITIES);
            }
        });

        theView.salesPanel.sellPanel.addDestStateComboBoxActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addCities(DESTINATION_CITIES);
            }
        });

        theView.salesPanel.sellPanel.addSellButtonActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = theView.salesPanel.sellPanel.clientNameField.getText();
                Client client = theModel.getClient(name);
                if (client.Nombre == null) {
                    JFrame crearClienteJF = new JFrame("Agregar Cliente");
                    JPanel crearClienteP = new ClientCreationPanel();
                    crearClienteJF.add(crearClienteP);
                    crearClienteJF.setSize(300, 400);
                    crearClienteJF.setLocationRelativeTo(null);
                    crearClienteJF.setEnabled(true);
                    crearClienteJF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    JOptionPane.showMessageDialog(null, "Este cliente no se encuentra registrado", "Cliente no registrado", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    int idClient = client.IDCliente;
                    Integer selectedDay = (Integer) theView.salesPanel.sellPanel.dayCBox.getSelectedItem();
                    Integer selectedMonth = new Integer(theView.salesPanel.sellPanel.monthCBox.getSelectedIndex());
                    Integer selectedYear = (Integer) theView.salesPanel.sellPanel.yearCBox.getSelectedItem();
                    int numberTickets = theView.salesPanel.sellPanel.numberTicketsCBox.getSelectedIndex() + 1;
                    String srcCity = (String) theView.salesPanel.sellPanel.srcCityCBox.getSelectedItem();
                    String destCity = (String) theView.salesPanel.sellPanel.destCityCBox.getSelectedItem();
                    int route = theModel.getRouteID(srcCity, destCity);
                    int idEmployee = theModel.idEmployee;
                    String comments = theView.salesPanel.sellPanel.comment.getText();
                    String date = selectedYear.toString() + "-" + selectedMonth.toString() + "-" + selectedDay.toString();
                    theModel.registerSell(date, numberTickets, route, idEmployee, idClient, comments);
                    setModifySellTable();
                }
            }
        });

        theView.salesPanel.sellPanel.addNumberTicketsActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int total = theView.salesPanel.sellPanel.numberTicketsCBox.getSelectedIndex() + 1;
                theView.salesPanel.sellPanel.totalLabel.setText("$ " + (new Integer(100 * total)).toString() + ".00");
                theView.salesPanel.sellPanel.totalPrice = 100 * total;
            }
        });
    }

    public void showSalesPanel() {
        theView.singInPanel.eraseData();
        theView.windowPicker.show(theView.windowsPanel, theView.SALES_PANEL);
        theView.setSize(new Dimension(600,600));
        theView.setLocationRelativeTo(null);
        addStates();
        addSellActionListeners();
        theView.salesPanel.sellPanel.selectDefault();
        setModifySellTable();
    }

    public void setModifySellTable(){theView.salesPanel.modifySellPanel.setData(theModel.getAllSells());
    }

    public boolean validateNewEmployee() {
        return true;
    }
}
