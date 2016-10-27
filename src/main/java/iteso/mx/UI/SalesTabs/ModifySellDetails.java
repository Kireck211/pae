package iteso.mx.UI.SalesTabs;

import javax.swing.*;
import java.awt.*;

/**
 * Created by simio on 27/10/2016.
 */
public class ModifySellDetails extends JPanel {

    JLabel clientNameLabel;
    JTextField clientNameField;

    JComboBox<String> srcStateComboBox;
    JComboBox<String> destStateComboBox;

    JLabel commentLabel;
    JTextArea commentField;


    public ModifySellDetails(){
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        clientNameLabel = new JLabel("Nombre del cliente");
        commentLabel = new JLabel("Comentarios");
        srcStateComboBox = new JComboBox<String>();
        destStateComboBox = new JComboBox<String>();
        clientNameField = new JTextField();
        commentField = new JTextArea(10, 30);


    }
}
