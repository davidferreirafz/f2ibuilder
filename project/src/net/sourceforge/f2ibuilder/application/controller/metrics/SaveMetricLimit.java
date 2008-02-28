package net.sourceforge.f2ibuilder.application.controller.metrics;

import javax.swing.JTextField;

import net.sourceforge.f2ibuilder.application.controller.generics.base.FontTextAction;
import net.sourceforge.f2ibuilder.application.model.FontText;


public class SaveMetricLimit extends FontTextAction
{
    private JTextField minor;
    private JTextField higher;  
    
    public SaveMetricLimit(FontText fontText, JTextField minor, JTextField higher)
    {
        super(fontText);
        this.minor=minor;
        this.higher=higher;
    }

    @Override
    protected void action()
    {
        int menor=Integer.parseInt(minor.getText());
        int maior=Integer.parseInt(higher.getText());
        
        fontText.setLimits(menor, maior);
    }
    

}
