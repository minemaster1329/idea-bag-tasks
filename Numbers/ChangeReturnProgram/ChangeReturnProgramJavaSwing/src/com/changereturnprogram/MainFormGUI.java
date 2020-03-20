package com.changereturnprogram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFormGUI{

    private JTextField costInput;
    private JTextField paidInput;
    private JButton calculateButton;
    private JButton clearButton;
    private JScrollPane outputPanel;
    private JPanel mainPanel;
    private JList outputList;
    private DefaultListModel listModel;

    public MainFormGUI() {
        listModel = new DefaultListModel();
        outputList.setModel(listModel);
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cost_str = costInput.getText();
                String paid_str = paidInput.getText();

                if (canParse(cost_str.replace(',', '.')) && canParse(paid_str.replace(',', '.'))){

                    float cost = Float.parseFloat(cost_str.replace(',', '.'));
                    float paid = Float.parseFloat(paid_str.replace(',', '.'));

                    if (negativeNumbersGiven(cost, paid)) JOptionPane.showMessageDialog(null, "Cost and amount paid must be greater than 0.", "Invalid input.", JOptionPane.ERROR_MESSAGE);
                    else if (cost > paid) JOptionPane.showMessageDialog(null, "Cost must be lower or equal to amount paid..", "Invalid input.", JOptionPane.ERROR_MESSAGE);
                    else {
                        listModel.clear();
                        int cost_int = (int) (cost * 100);
                        int paid_int = (int) (paid * 100);
                        paid_int -= cost_int;

                        int[] nominals = {50000,20000,10000,5000,2000,1000,500,200,100,50,20,10,5,2,1};

                        for (int i = 0; i < 9; i++){
                            int count = paid_int / nominals[i];
                            listModel.addElement(printOutNomAndCountToString(nominals[i] / 100, "zl", count));
                            paid_int -= count * nominals[i];
                        }

                        for (int i = 9; i < 15; i++){
                            int count = paid_int / nominals[i];
                            listModel.addElement(printOutNomAndCountToString(nominals[i], "gr", count));
                            paid_int -= count * nominals[i];
                        }
                    }
                }

                else JOptionPane.showMessageDialog(null, "Invalid parameters given.", "Invalid input.", JOptionPane.ERROR_MESSAGE);
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.clear();
                costInput.setText("0");
                paidInput.setText(("0"));
            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("IdeaBag - Numbers - Change Return Program");
        MainFormGUI mainFormGUI = new MainFormGUI();
        frame.setContentPane(mainFormGUI.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 500);
        mainFormGUI.mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    }

    static boolean negativeNumbersGiven(float ... args){
        for (float i : args) if (i <=0) return true;
        return false;
    }

    static boolean canParse(String str){
        try {
            float num = Float.parseFloat(str);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    static String printOutNomAndCountToString(int nominal, String currency, int nomCount){
        return (Integer.toString(nominal) + currency+": "+Integer.toString(nomCount));
    }
}
