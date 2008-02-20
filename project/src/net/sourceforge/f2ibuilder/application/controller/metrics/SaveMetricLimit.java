package net.sourceforge.f2ibuilder.application.controller.metrics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import net.sourceforge.f2ibuilder.application.model.FontText;




public class SaveMetricLimit implements ActionListener
{
    protected FontText tableChar;
    private JTextField minor;
    private JTextField higher;  
    
    public SaveMetricLimit(FontText tableChar, JTextField minor, JTextField higher)
    {
        this.tableChar = tableChar;
        this.minor=minor;
        this.higher=higher;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        salvar();
    }
    
    private void salvar()
    {        
        int menor=Integer.parseInt(minor.getText());
        int maior=Integer.parseInt(higher.getText());
        
        tableChar.setLimits(menor, maior);
    }
    

}
