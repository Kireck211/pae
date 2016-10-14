package iteso.mx.UI.SalesTabs;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Erick on 06/10/2016.
 */
public class Sell extends JPanel {
    public JLabel clientNameLabel;
    public JTextField clientNameField;
    public JLabel countryLabel;
    public JComboBox<String> countryBox;
    public ArrayList<Integer> countryID;
    public JLabel stateLabel;
    public JComboBox<String> stateBox;
    public ArrayList<Integer> stateID;


    public Sell() {
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        clientNameLabel = new JLabel("Nombre:");
        clientNameField = new JTextField(15);
        countryLabel = new JLabel("País:");
        countryBox = new JComboBox<String>();
        countryID = new ArrayList<Integer>();
        stateLabel = new JLabel("Estado:");
        stateBox = new JComboBox<String>();

        countryBox.setEditable(true);

        gb.gridx = 0;
        gb.gridy = 0;
        gb.weightx = 1;
        gb.weighty = 1;
        add(clientNameLabel, gb);

        gb.gridx = 1;
        add(clientNameField, gb);

        gb.gridx = 0;
        gb.gridy = 1;
        add(countryLabel, gb);

        gb.gridx = 1;
        add(countryBox, gb);

        gb.gridx = 0;
        gb.gridy = 2;
        add(stateLabel, gb);

        gb.gridx = 1;
        add(stateBox, gb);
    }

    public void addCountries(HashMap<Integer, String> countries) {
        for(Integer key: countries.keySet()) {
            countryID.add(key);
            countryBox.addItem(countries.get(key));
        }
    }

    public void addStates(HashMap<Integer, String> states) {
        for(Integer key: states.keySet()) {
            stateID.add(key);
            countryBox.addItem(states.get(key));
        }
        countryBox.setSelectedIndex(0);
    }

    public void addCountryComboBoxKeyListener (KeyAdapter keyAdapter) {
        countryBox.getEditor().getEditorComponent().addKeyListener(keyAdapter);
    }

    public void addCountryComboBoxActionListener(ActionListener actionListener){
        countryBox.addActionListener(actionListener);
    }

    public void addStateComboBoxActionListener(ActionListener actionListener) {
        stateBox.addActionListener(actionListener);
    }
}
