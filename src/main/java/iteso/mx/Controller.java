package iteso.mx;


import iteso.mx.Models.Client;
import iteso.mx.Models.Employee;
import iteso.mx.UI.ClientCreationPanel;
import iteso.mx.Validators.ClientValidator;
import iteso.mx.Validators.EmployeeValidator;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

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
        addModifySellListeners();
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
                theView.setSize(400, 400);
                theView.setLocationRelativeTo(null);
            }
        });
    }

    public void addWelcomeActionListeners() {
        theView.welcomePanel.addSignInListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                theView.windowPicker.show(theView.windowsPanel, theView.SING_IN_PANEL);
                theView.setSize(new Dimension(400, 400));
                theView.setLocationRelativeTo(null);
            }
        });

        theView.welcomePanel.addSignUpListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                theView.windowPicker.show(theView.windowsPanel, theView.REGISTRATION_PANEL);
                theView.setSize(new Dimension(400, 400));
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
                if (isUserPasswordCorrect(userName, password)) {
                    theModel.setIDEmployeeDB(userName);
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
                        theModel.setIDEmployeeDB(user);
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
                        theModel.setIDEmployeeDB(user);
                        showSalesPanel();
                    }
                }
            }
        });
    }

    public void addRegistrationActionListeners() {
        theView.registrationPanel.addOkListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = theView.registrationPanel.getUserTextField();
                String password = theView.registrationPanel.getPasswordTextField();
                String name = theView.registrationPanel.getNameTF();
                String apP = theView.registrationPanel.getApTF();
                String apM = theView.registrationPanel.getAmTF();
                String gender = theView.registrationPanel.getGenderTF().substring(0, 1);
                theView.registrationPanel.eraseData();
                Employee employee = new Employee(user, password, name, apP, apM, gender);
                EmployeeValidator employeeValidator = new EmployeeValidator();
                if (employeeValidator.isValidEmployee(employee)) {
                    theModel.insertEmployee(employee);
                    theView.windowPicker.show(theView.windowsPanel, theView.WELCOME_PANEL);
                    theView.windowPicker.show(theView.windowsPanel, theView.WELCOME_PANEL);
                    theView.setSize(new Dimension(500, 500));
                    theView.setLocationRelativeTo(null);
                }
            }
        });

        theView.registrationPanel.addCancelListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                theView.registrationPanel.eraseData();
                theView.windowPicker.show(theView.windowsPanel, theView.WELCOME_PANEL);
                theView.windowPicker.show(theView.windowsPanel, theView.WELCOME_PANEL);
                theView.setSize(new Dimension(500, 500));
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
        if (cities == SOURCE_CITIES) {
            if (theView.salesPanel.sellPanel.srcStateComboBox.getItemCount() == 0)
                return;
            index = theView.salesPanel.sellPanel.srcStateIDs.get(theView.salesPanel.sellPanel.srcStateComboBox.getSelectedIndex());
            theView.salesPanel.sellPanel.addSrcCities(theModel.getCities(index));
        } else {
            if (theView.salesPanel.sellPanel.destStateComboBox.getItemCount() == 0)
                return;
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
                final Client client = theModel.getClient(name);
                if (client.Nombre == null) {
                    final JFrame crearClienteJF = new JFrame("Agregar Cliente");
                    crearClienteJF.setUndecorated(true);
                    final ClientCreationPanel crearClienteP = new ClientCreationPanel();
                    crearClienteP.addOkButtonActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            ClientValidator clientValidator = new ClientValidator();
                            Client client_verificator = new Client(crearClienteP.getNameTF(), crearClienteP.getDayCB(), crearClienteP.getMonthCB(), crearClienteP.getYearCB(), crearClienteP.getGenderCB(), crearClienteP.getRFCTF());
                            if (clientValidator.isValidClient(client_verificator)) {
                                crearClienteJF.setVisible(false);
                                crearClienteJF.setEnabled(false);
                                theModel.insertClient(client_verificator);
                                theView.setVisible(true);
                                theView.salesPanel.sellPanel.clientNameField.setText(client_verificator.Nombre);
                            }
                        }
                    });
                    crearClienteJF.add(crearClienteP);
                    crearClienteJF.setSize(350, 270);
                    crearClienteJF.setLocationRelativeTo(null);
                    theView.setVisible(false);
                    crearClienteJF.setEnabled(true);
                    crearClienteJF.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Este cliente no se encuentra registrado", "Cliente no registrado", JOptionPane.ERROR_MESSAGE);
                } else {
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
                    JOptionPane.showMessageDialog(null, "La venta fue realizada con éxito", "Venta realizada", JOptionPane.INFORMATION_MESSAGE);
                    theView.salesPanel.sellPanel.eraseData();
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
        theView.setSize(new Dimension(600, 600));
        theView.setLocationRelativeTo(null);
        addStates();
        addSellActionListeners();
        theView.salesPanel.sellPanel.selectDefault();
        theModel.setNameEmployee();
        theView.salesPanel.header.idEmpleadoL.setText(theModel.getIDEmpleado().toString());
        theView.salesPanel.header.nombreEmpleadoL.setText(theModel.getNameEmployee());
        setModifySellTable();
    }

    public void setModifySellTable() {
        theView.salesPanel.modifySellPanel.setData(theModel.getAllSells());
    }

    public void addModifySellListeners() {
        theView.salesPanel.modifySellPanel.addDeleteButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int row = theView.salesPanel.modifySellPanel.getTable().getSelectedRow();
                int index = Integer.parseInt((String) theView.salesPanel.modifySellPanel.getData(row).elementAt(0));

                theModel.deleteSell(index);
                theView.salesPanel.modifySellPanel.deleteRow();

            }
        });

        theView.salesPanel.modifySellPanel.addRowSelectedListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if(!theView.salesPanel.modifySellPanel.getTable().getSelectionModel().isSelectionEmpty() ) {
                    int row = theView.salesPanel.modifySellPanel.getTable().getSelectedRow();
                    Vector<Object> data = theView.salesPanel.modifySellPanel.getData(row); //Necesita ser casteado para cada objeto
                    //theView.salesPanel.modifySellPanel.getPanel2().clientNameField.setText((String) data.elementAt(2));
                    theView.salesPanel.modifySellPanel.getPanel2().commentField.setText((String) data.elementAt(9));
                    theModel.setComment((String) data.elementAt(9));
                    theModel.setFolio(Integer.parseInt((String)data.elementAt(0)));
                }
            }
        });

        theView.salesPanel.modifySellPanel.addModifyButton(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                theModel.setComment(theView.salesPanel.modifySellPanel.getPanel2().commentField.getText());
                theModel.modifySell(theModel.folio,theModel.comment);
            }
        });


    }
}