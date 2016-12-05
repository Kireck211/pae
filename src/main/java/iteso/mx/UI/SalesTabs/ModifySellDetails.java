package iteso.mx.UI.SalesTabs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by simio on 27/10/2016.
 */
public class ModifySellDetails extends JPanel {

    //JLabel clientNameLabel;
    //public JTextField clientNameField;

    //JComboBox<String> srcStateComboBox;
    //JComboBox<String> destStateComboBox;

    //JComboBox<String> srcCityCBox;
    //JComboBox<String> destCityCBox;

    JLabel commentLabel;
    public JTextArea commentField;

    //JLabel srcStateLabel;
    //JLabel destStateLabel;

    //JLabel srcCityLabel;
    //JLabel destCityLabel;

    //ArrayList<Integer> srcStateIDs;
    //ArrayList<Integer> destStateIDs;

    //ArrayList<Integer> srcCityIDs;
    //ArrayList<Integer> destCityIDs;

    JButton deleteButton;
    JButton modifyButton;

    public ModifySellDetails(){
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        //clientNameLabel = new JLabel("Nombre:");
        //clientNameField = new JTextField(15);
        //srcStateLabel = new JLabel("Estado (Origen):");
        //destStateLabel = new JLabel("Estado (Destino):");
        //srcStateComboBox = new JComboBox<String>();
        //destStateComboBox = new JComboBox<String>();
        //srcStateIDs = new ArrayList<Integer>();
        //destStateIDs = new ArrayList<Integer>();
        //srcCityLabel = new JLabel("Ciudad (Origen):");
        //destCityLabel = new JLabel("Ciudad (Destino):");
        //srcCityCBox = new JComboBox<String>();
        //destCityCBox = new JComboBox<String>();
        //srcCityIDs = new ArrayList<Integer>();
        //destCityIDs = new ArrayList<Integer>();
        commentField = new JTextArea(10, 30);
        commentLabel = new JLabel("Comentarios:");
        deleteButton = new JButton("Borrar Venta");
        modifyButton = new JButton("Modicar Venta");

        // Add labels
        //gb.gridx = 0;
        //gb.gridy = 0;
        //gb.insets = new Insets(0, 0, 20, 0);
        //add(clientNameLabel, gb);

        /*gb.gridy++;
        add(srcStateLabel, gb);

        gb.gridx = 2;
        add(destStateLabel, gb);

        gb.gridx = 0;
        gb.gridy++;
        add(srcCityLabel, gb);

        gb.gridx = 2;
        add(destCityLabel, gb);*/

        gb.gridx = 0;
        gb.gridy++;
        add(commentLabel, gb);

        // Add text fields

        //gb.gridx = 1;
        //gb.gridy = 0;
        //gb.gridwidth = 3;
        //gb.fill = GridBagConstraints.HORIZONTAL;
        //add(clientNameField, gb);

        /*gb.gridy++;
        gb.gridwidth = 1;
        add(srcStateComboBox, gb);

        gb.gridx = 3;
        add(destStateComboBox, gb);

        gb.gridx = 1;
        gb.gridy++;
        add(srcCityCBox, gb);

        gb.gridx = 3;
        add(destCityCBox, gb);*/

        gb.gridx = 1;
        gb.gridy++;
        gb.gridwidth = 3;
        add(commentField, gb);

        gb.gridx = 0;
        gb.gridy++;
        gb.gridwidth = 4;
        add(modifyButton, gb);

        gb.gridy++;
        add(deleteButton, gb);
    }

    public JButton getDeleteButton(){
        return this.deleteButton;
    }

    public JButton getModifyButton(){
        return this.modifyButton;
    }
}
