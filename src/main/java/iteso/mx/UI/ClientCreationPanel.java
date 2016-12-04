package iteso.mx.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Calendar;

/**
 * Created by Erick on 04/12/2016.
 */
public class ClientCreationPanel extends JPanel{
    private JLabel nameL;
    private JLabel birthdayL;
    private JLabel genderL;
    private JLabel RFCL;
    private JTextField nameTF;
    private JComboBox<Integer> dayCB;
    private JComboBox<String> monthCB;
    private JComboBox<Integer> yearCB;
    private JTextField genderTF;
    private JTextField RFCTF;
    private JButton okB;
    private JButton cancelB;

    public ClientCreationPanel() {
        nameL = new JLabel("Nombre Completo:");
        birthdayL = new JLabel("Nombre Completo:");
        genderL = new JLabel("Nombre Completo:");
        RFCL = new JLabel("Nombre Completo:");
        nameTF = new JTextField(20);
        dayCB = new JComboBox<Integer>();
        monthCB = new JComboBox<String>();
        yearCB = new JComboBox<Integer>();
        addDates();
        genderTF = new JTextField(20);
        RFCTF = new JTextField(20);
        okB = new JButton("Registrar");
        cancelB = new JButton("Cancelar");

        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        //Add labels
        gb.gridx = 0;
        gb.gridy = 0;
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
        add(nameL, gb);

        gb.gridy++;
        gb.gridwidth = 1;
        gb.gridx = 1;
        add(dayCB, gb);

        gb.gridx++;
        add(monthCB, gb);

        gb.gridx++;
        add(yearCB, gb);

        gb.gridx = 1;
        gb.gridy++;
        gb.gridwidth = 3;
        add(genderTF, gb);

        gb.gridy++;
        add(RFCTF, gb);
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
        for(int i = 0; i < 2; i++) {
            yearCB.addItem(Calendar.getInstance().get(Calendar.YEAR) + i);
        }
    }

    public void addOkButtonActionListener (ActionListener actionListener) {
        okB.addActionListener(actionListener);
    }

    public void addCancelActionListener (ActionListener actionListener) {
        cancelB.addActionListener(actionListener);
    }

}
