package iteso.mx.UI.SalesTabs;

import javax.swing.*;

/**
 * Created by Erick on 06/10/2016.
 */
public class Sell extends JComponent {
    public JPanel mainPannel;
    public JLabel countryFrLb;
    //    public JComboBox<String> countryFrTF;
    public JLabel stateFrLb;
    //    public JComboBox<String> stateFrTF;
    public JLabel cityFrLb;
    //    public JComboBox<String> cityFrTF;
    public JLabel countryToLb;
    public JTextField countryToTF;
    public JLabel stateToLb;
    public JTextField stateToTF;
    public JLabel cityToLb;
    public JTextField cityToTF;
    public JButton sellBt;

    public Sell() {
        mainPannel = new JPanel();
        countryFrLb = new JLabel("País origen: ");
//        countryFrTF = new JComboBox<String>(["", ""]);
        stateFrLb = new JLabel("Estado origen: ");
//        stateFrTF = new JTextField(15);
        cityFrLb = new JLabel("Ciudad origen: ");
//        cityFrTF = new JTextField(15);


        mainPannel.add(countryFrLb);
        mainPannel.add(stateFrLb);
        mainPannel.add(cityFrLb);

        add(mainPannel);
    }
}
