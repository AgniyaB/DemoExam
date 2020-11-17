package org.company.app.ui;

import org.company.app.util.BaseForm;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

public class ThirdForm extends BaseForm
{
    private static final String[] CHOICES = {"Услуга 1", "Услуга 2", "Услуга 3", "Услуга 4", "Услуга 5", "Услуга 6", "Услуга 7"};

    private JPanel mainPanel;
    private JComboBox comboBox1;
    private JButton chechButton;

    public ThirdForm()
    {
        setContentPane(mainPanel);

        comboBox1.addItem("Выберите услугу");
        for(String s : CHOICES) {
            comboBox1.addItem(s);
        }


        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1) {
                    System.out.println(e.getItem());
                }
            }
        });

        chechButton.addActionListener(e -> {
            System.out.println(comboBox1.getSelectedItem());
            System.out.println(comboBox1.getSelectedIndex());
        });
    }

    @Override
    public int getFormWidth() {
        return 250;
    }

    @Override
    public int getFormHeight() {
        return 250;
    }
}
