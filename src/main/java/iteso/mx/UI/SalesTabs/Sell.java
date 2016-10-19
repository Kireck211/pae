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
    public JComboBox<String> stateComboBox;
    public ArrayList<Integer> stateIDs;
    public JLabel stateLabel;
    public JComboBox<String> cityCBox;
    public ArrayList<Integer> cityIDs;


    public Sell() {
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        clientNameLabel = new JLabel("Nombre:");
        clientNameField = new JTextField(15);
        countryLabel = new JLabel("Estado:");
        stateComboBox = new JComboBox<String>();
        stateIDs = new ArrayList<Integer>();
        stateLabel = new JLabel("Ciudad:");
        cityCBox = new JComboBox<String>();

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
        add(stateComboBox, gb);

        gb.gridx = 0;
        gb.gridy = 2;
        add(stateLabel, gb);

        gb.gridx = 1;
        add(cityCBox, gb);
    }

    public void addStates(HashMap<Integer, String> countries) {
        for(Integer key: countries.keySet()) {
            stateIDs.add(key);
            stateComboBox.addItem(countries.get(key));
        }
    }

    public void addStateComboBoxActionListener(ActionListener actionListener){
        stateComboBox.addActionListener(actionListener);
    }
}
