package iteso.mx.UI.SalesTabs;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;


public class Sell extends JPanel {
    public JLabel clientNameLabel;
    public JTextField clientNameField;
    public JLabel srcStateLabel;
    public JLabel destStateLabel;
    public JLabel commentJLabel;
    public JComboBox<String> srcStateComboBox;
    public JComboBox<String> destStateComboBox;
    public ArrayList<Integer> srcStateIDs;
    public ArrayList<Integer> destStateIDs;
    public JLabel srcCityLabel;
    public JLabel destCityLabel;
    public JComboBox<String> srcCityCBox;
    public JComboBox<String> destCityCBox;
    public ArrayList<Integer> srcCityIDs;
    public ArrayList<Integer>  destCityIDs;
    public JLabel numberTicketsLabel;
    public JComboBox<Integer> numberTicketsCBox;
    public JLabel dateLab;
    public JComboBox<Integer> dayCBox;
    public JComboBox<String> monthCBox;
    public JComboBox<Integer> yearCBox;
    public JTextArea comment;
    public JLabel priceLabel;
    public JLabel totalLabel;
    public JButton sellButton;
    public int totalPrice;


    public Sell() {
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        clientNameLabel = new JLabel("Nombre:");
        clientNameField = new JTextField(15);
        srcStateLabel = new JLabel("Estado (Origen):");
        destStateLabel = new JLabel("Estado (Destino):");
        srcStateComboBox = new JComboBox<String>();
        destStateComboBox = new JComboBox<String>();
        srcStateIDs = new ArrayList<Integer>();
        destStateIDs = new ArrayList<Integer>();
        srcCityLabel = new JLabel("Ciudad (Origen):");
        destCityLabel = new JLabel("Ciudad (Destino):");
        srcCityCBox = new JComboBox<String>();
        destCityCBox = new JComboBox<String>();
        srcCityIDs = new ArrayList<Integer>();
        destCityIDs = new ArrayList<Integer>();
        dateLab = new JLabel("Fecha:");
        dayCBox = new JComboBox<Integer>();
        monthCBox = new JComboBox<String>();
        yearCBox = new JComboBox<Integer>();
        numberTicketsLabel = new JLabel("Número de boletos");
        numberTicketsCBox = new JComboBox<Integer>(new Vector<Integer>(Arrays.asList(1,2,3,4,5)));
        commentJLabel = new JLabel("Comentarios:");
        comment = new JTextArea(10, 30);
        priceLabel = new JLabel("Precio:");
        totalLabel = new JLabel("$ 0.00");
        sellButton = new JButton("Realizar venta");
        totalPrice = 0;
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

        gb.gridy = 6;
        add(numberTicketsLabel, gb);

        gb.gridy = 7;
        add(priceLabel, gb);

        gb.gridy = 8;
        add(commentJLabel, gb);


        // Add second column
        gb.gridwidth = 3;
        gb.gridx = 2;
        gb.gridy = 0;
        add(clientNameField, gb);

        gb.gridy = 1;
        add(srcStateComboBox, gb);

        gb.gridy = 2;
        add(srcCityCBox, gb);

        gb.gridy = 3;
        add(destStateComboBox, gb);

        gb.gridy = 4;
        add(destCityCBox, gb);

        gb.gridy = 6;
        add(numberTicketsCBox, gb);

        gb.gridy = 7;
        add(totalLabel, gb);

        gb.gridy = 8;
        add(comment, gb);


        // Add date in second column
        gb.gridwidth = 1;
        gb.gridx = 3;
        gb.gridy = 5;
        add(dayCBox, gb);

        gb.gridx = 4;
        add(monthCBox, gb);

        gb.gridx = 5;
        add(yearCBox, gb);

        // Add sell button
        gb.gridx = 1;
        gb.gridy = 9;
        gb.gridwidth = 5;
        gb.fill = GridBagConstraints.HORIZONTAL;
        add(sellButton, gb);

    }

    public void addStates(HashMap<Integer, String> states) {
        if(srcStateIDs != null)
            srcStateIDs = new ArrayList<Integer>();
        if(destCityIDs != null)
            destCityIDs = new ArrayList<Integer>();
        if(srcStateComboBox.getItemCount() != 0)
            srcStateComboBox.removeAllItems();
        if(destStateComboBox.getItemCount() != 0)
            destStateComboBox.removeAllItems();
        for(Integer key: states.keySet()) {
            srcStateIDs.add(key);
            srcStateComboBox.addItem(states.get(key));
            destStateIDs.add(key);
            destStateComboBox.addItem(states.get(key));
        }
    }

    public void addSrcStateComboBoxActionListener(ActionListener actionListener){
        srcStateComboBox.addActionListener(actionListener);
    }

    public void addSrcCities(HashMap<Integer, String> cities) {
        if(srcCityIDs != null)
            srcCityIDs = new ArrayList<Integer>();
        if(srcCityCBox.getItemCount() != 0)
            srcCityCBox.removeAllItems();
        for(Integer key: cities.keySet()) {
            srcCityIDs.add(key);
            srcCityCBox.addItem(cities.get(key));
        }
    }

    public void addDestCities(HashMap<Integer, String> cities) {
        if(destCityIDs != null)
            destCityIDs = new ArrayList<Integer>();
        if(destCityCBox.getItemCount() != 0)
            destCityCBox.removeAllItems();
        for(Integer key: cities.keySet()) {
            destCityIDs.add(key);
            destCityCBox.addItem(cities.get(key));
        }
    }

    public void addDestStateComboBoxActionListener(ActionListener actionListener) {
        destStateComboBox.addActionListener(actionListener);
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
        srcStateComboBox.setSelectedIndex(0);
        destStateComboBox.setSelectedIndex(1);
        numberTicketsCBox.setSelectedIndex(0);
        dayCBox.setSelectedIndex(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)-1);
        monthCBox.setSelectedIndex(Calendar.getInstance().get(Calendar.MONTH));
        yearCBox.setSelectedIndex(0);
    }

    public void addSellButtonActionListener(ActionListener actionListener) {
        sellButton.addActionListener(actionListener);
    }

    public void addNumberTicketsActionListener(ActionListener actionListener) {
        numberTicketsCBox.addActionListener(actionListener);
    }
}
