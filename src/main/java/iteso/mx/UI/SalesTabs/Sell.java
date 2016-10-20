package iteso.mx.UI.SalesTabs;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;


public class Sell extends JPanel {
    public JLabel clientNameLabel;
    public JTextField clientNameField;
    public JLabel stateLabel;
    public JComboBox<String> stateComboBox;
    public ArrayList<Integer> stateIDs;
    public JLabel cityLabel;
    public JComboBox<String> cityCBox;
    public ArrayList<Integer> cityIDs;


    public Sell() {
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        clientNameLabel = new JLabel("Nombre:");
        clientNameField = new JTextField(15);
        stateLabel = new JLabel("Estado:");
        stateComboBox = new JComboBox<String>();
        stateIDs = new ArrayList<Integer>();
        cityLabel = new JLabel("Ciudad:");
        cityCBox = new JComboBox<String>();
        cityIDs = new ArrayList<Integer>();

        gb.gridx = 0;
        gb.gridy = 0;
        gb.weightx = 1;
        gb.weighty = 1;
        add(clientNameLabel, gb);

        gb.gridx = 1;
        add(clientNameField, gb);

        gb.gridx = 0;
        gb.gridy = 1;
        add(stateLabel, gb);

        gb.gridx = 1;
        add(stateComboBox, gb);

        gb.gridx = 0;
        gb.gridy = 2;
        add(cityLabel, gb);

        gb.gridx = 1;
        add(cityCBox, gb);
    }

    public void addStates(HashMap<Integer, String> states) {
        if(stateIDs != null)
            stateIDs = new ArrayList<Integer>();
        if(stateComboBox.getItemCount() != 0)
            stateComboBox.removeAllItems();
        for(Integer key: states.keySet()) {
            stateIDs.add(key);
            stateComboBox.addItem(states.get(key));
        }
    }

    public void addStateComboBoxActionListener(ActionListener actionListener){
        stateComboBox.addActionListener(actionListener);
    }

    public void addCities(HashMap<Integer, String> cities) {
        if(cityIDs != null)
            cityIDs = new ArrayList<Integer>();
        if(cityCBox.getItemCount() != 0)
            cityCBox.removeAllItems();
        for(Integer key: cities.keySet()) {
            cityIDs.add(key);
            cityCBox.addItem(cities.get(key));
//            System.out.println(key);
        }
    }
}
