package iteso.mx.UI.SalesTabs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by simio on 27/10/2016.
 */
public class ModifySellDetails extends JPanel {

    JLabel clientNameLabel;
    JTextField clientNameField;

    JComboBox<String> srcStateComboBox;
    JComboBox<String> destStateComboBox;

    JComboBox<String> srcCityCBox;
    JComboBox<String> destCityCBox;

    JLabel commentLabel;
    JTextArea commentField;

    JLabel srcStateLabel;
    JLabel destStateLabel;

    JLabel srcCityLabel;
    JLabel destCityLabel;

    ArrayList<Integer> srcStateIDs;
    ArrayList<Integer> destStateIDs;

    ArrayList<Integer> srcCityIDs;
    ArrayList<Integer> destCityIDs;

    JButton deleteButton;
    JButton modifyButton;

    public ModifySellDetails(){
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
        commentField = new JTextArea(10, 30);
        commentLabel = new JLabel("Comentarios:");
        deleteButton = new JButton("Borrar Venta");
        modifyButton = new JButton("Modicar Venta");

        gb.gridx = 0;
        gb.gridy = 0;
        add(clientNameLabel,gb);

        gb.gridy = 1;
        add(srcStateLabel,gb);

        gb.gridy = 2;
        add(srcCityLabel);

        gb.gridy = 3;
        add(commentLabel,gb);

        gb.gridx = 1;
        gb.gridy = 0;
        add(clientNameField,gb);

        gb.gridy = 1;
        add(srcStateComboBox,gb);

        gb.gridy = 2;
        add(srcCityCBox,gb);

        gb.gridy = 3;
        add(commentField,gb);

        gb.gridx = 2;
        gb.gridy = 1;
        add(destStateLabel,gb);

        gb.gridy = 2;
        add(destCityLabel,gb);

        gb.gridx = 3;
        gb.gridy = 1;
        add(destStateComboBox,gb);

        gb.gridy = 2;
        add(destCityCBox,gb);

        gb.gridy = 3;
        add(deleteButton);

        gb.gridy = 4;
        add(modifyButton);
    }

    public JButton getDeleteButton(){
        return this.deleteButton;
    }

    public JButton getModifyButton(){
        return this.modifyButton;
    }
}
