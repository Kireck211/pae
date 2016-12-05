package iteso.mx.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Vector;

/**
 * Created by Erick on 04/12/2016.
 */
public class ClientCreationPanel extends JPanel {
    private JLabel nameL;
    private JLabel birthdayL;
    private JLabel genderL;
    private JLabel RFCL;
    private JTextField nameTF;
    private JComboBox<Integer> dayCB;
    private JComboBox<String> monthCB;
    private JComboBox<Integer> yearCB;
    private JComboBox<String> genderCB;
    private JTextField RFCTF;
    public JButton okB;
    private JButton cancelB;

    public ClientCreationPanel() {
        nameL = new JLabel("Nombre Completo:");
        birthdayL = new JLabel("Fecha de Nacimiento:");
        genderL = new JLabel("Sexo:");
        RFCL = new JLabel("RFC:");
        nameTF = new JTextField(20);
        dayCB = new JComboBox<Integer>();
        monthCB = new JComboBox<String>();
        yearCB = new JComboBox<Integer>();
        addDates();
        genderCB = new JComboBox<String>(new Vector<String>(Arrays.asList("Femenino", "Masculino")));
        RFCTF = new JTextField(20);
        okB = new JButton("Registrar");
        cancelB = new JButton("Cancelar");

        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        //Add labels
        gb.gridx = 0;
        gb.gridy = 0;
        gb.insets = new Insets(0, 0, 20, 0);
        add(nameL, gb);

        gb.gridy++;
        add(birthdayL, gb);

        gb.gridy++;
        add(genderL, gb);

        gb.gridy++;
        add(RFCL, gb);

        // Add text fields
        gb.gridx = 1;
        gb.gridy = 0;
        gb.gridwidth = 3;
        gb.fill = GridBagConstraints.HORIZONTAL;
        add(nameTF, gb);

        gb.gridy++;
        gb.gridwidth = 1;
        gb.gridx = 1;
        gb.fill = GridBagConstraints.NONE;
        add(dayCB, gb);

        gb.gridx++;
        add(monthCB, gb);

        gb.gridx++;
        add(yearCB, gb);

        gb.gridx = 1;
        gb.gridy++;
        gb.gridwidth = 3;
        gb.fill = GridBagConstraints.HORIZONTAL;
        add(genderCB, gb);

        gb.gridy++;
        add(RFCTF, gb);

        // Add Buttons
        gb.gridy++;
        gb.gridx = 0;
        gb.gridwidth = 4;
        add(okB, gb);
    }

    public void addDates() {
        for(int i = 1; i < 32; i++) {
            dayCB.addItem(new Integer(i));
        }
        monthCB.addItem("Enero");
        monthCB.addItem("Febrero");
        monthCB.addItem("Marzo");
        monthCB.addItem("Abril");
        monthCB.addItem("Mayo");
        monthCB.addItem("Junio");
        monthCB.addItem("Julio");
        monthCB.addItem("Agosto");
        monthCB.addItem("Septiembre");
        monthCB.addItem("Octubre");
        monthCB.addItem("Noviembre");
        monthCB.addItem("Diciembre");
        for(int i = 0; i > -120; i--) {
            yearCB.addItem(Calendar.getInstance().get(Calendar.YEAR) + i);
        }
    }

    public void addOkButtonActionListener (ActionListener actionListener) {
        okB.addActionListener(actionListener);
    }

    public String getNameTF() {
        return nameTF.getText();
    }

    public Integer getDayCB() {
        return (Integer) dayCB.getSelectedItem();
    }

    public Integer getMonthCB() {
        return monthCB.getSelectedIndex() + 1;
    }

    public Integer getYearCB() {
        return (Integer) yearCB.getSelectedItem();
    }

    public String getGenderCB() {
        return ((String) genderCB.getSelectedItem()).substring(0,1);
    }

    public String getRFCTF() {
        return RFCTF.getText();
    }
}
