package iteso.mx.UI.SalesTabs;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;


public class Sell extends JPanel {
    public JLabel clientNameLabel;
    public JTextField clientNameField;
    public JLabel srcStateLabel;
    public JLabel destStateLabel;
    public JComboBox<String> stateComboBox;
    public ArrayList<Integer> stateIDs;
    public JLabel srcCityLabel;
    public JLabel destCityLabel;
    public JComboBox<String> cityCBox;
    public ArrayList<Integer> cityIDs;
    public JLabel dateLab;
    public JComboBox<Integer> dayCBox;
    public JComboBox<String> monthCBox;
    public JComboBox<Integer> yearCBox;


    public Sell() {
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        clientNameLabel = new JLabel("Nombre:");
        clientNameField = new JTextField(15);
        srcStateLabel = new JLabel("Estado (Origen):");
        destStateLabel = new JLabel("Estado (Destino):");
        stateComboBox = new JComboBox<String>();
        stateIDs = new ArrayList<Integer>();
        srcCityLabel = new JLabel("Ciudad (Origen):");
        destCityLabel = new JLabel("Ciudad (Destino):");
        cityCBox = new JComboBox<String>();
        cityIDs = new ArrayList<Integer>();
        dateLab = new JLabel("Fecha:");
        dayCBox = new JComboBox<Integer>();
        monthCBox = new JComboBox<String>();
        yearCBox = new JComboBox<Integer>();
        addDates();

        // Add first column
        gb.gridx = 0;
        gb.gridy = 0;
        gb.weightx = 1;
        gb.weighty = 1;
        gb.gridwidth = 2;
        add(clientNameLabel, gb);

        gb.gridy = 1;
        add(srcStateLabel, gb);

        gb.gridy = 2;
        add(srcCityLabel, gb);

        gb.gridy = 3;
        add(destStateLabel, gb);

        gb.gridy = 4;
        add(destCityLabel, gb);

        gb.gridy = 5;
        add(dateLab, gb);


        // Add second column
        gb.gridwidth = 3;
        gb.gridx = 2;
        gb.gridy = 0;
        add(clientNameField, gb);

        gb.gridy = 1;
        add(stateComboBox, gb);

        gb.gridy = 2;
        add(cityCBox, gb);


        // Add date in second column
        gb.gridwidth = 1;
        gb.gridx = 3;
        gb.gridy = 5;
        add(dayCBox, gb);

        gb.gridx = 4;
        add(monthCBox, gb);

        gb.gridx = 5;
        add(yearCBox, gb);
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
        }
    }

    public void addDates() {
        for(int i = 1; i < 32; i++) {
            dayCBox.addItem(new Integer(i));
        }
        monthCBox.addItem("Enero");
        monthCBox.addItem("Febrero");
        monthCBox.addItem("Marzo");
        monthCBox.addItem("Abril");
        monthCBox.addItem("Mayo");
        monthCBox.addItem("Junio");
        monthCBox.addItem("Julio");
        monthCBox.addItem("Agosto");
        monthCBox.addItem("Septiembre");
        monthCBox.addItem("Octubre");
        monthCBox.addItem("Noviembre");
        monthCBox.addItem("Diciembre");
        for(int i = 0; i < 2; i++) {
            yearCBox.addItem(Calendar.getInstance().get(Calendar.YEAR) + i);
        }
    }

    public void selectDefault() {
        stateComboBox.setSelectedIndex(0);
        dayCBox.setSelectedIndex(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)-1);
        monthCBox.setSelectedIndex(Calendar.getInstance().get(Calendar.MONTH));
        yearCBox.setSelectedIndex(0);
    }
}
