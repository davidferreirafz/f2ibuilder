package net.sourceforge.f2ibuilder.application.controller.command.radio;

import javax.swing.JRadioButtonMenuItem;

import net.sourceforge.f2ibuilder.application.model.FontText;
import net.sourceforge.f2ibuilder.application.model.Options;


public class SelectShadowCommand extends RadioCommand
{
    public SelectShadowCommand(Options options, FontText fontText)
    {
        super(options,fontText);
    }
    
    @Override
    protected void action(JRadioButtonMenuItem radio)
    {
        String label = radio.getName();
        
        if (label.startsWith("Horizontal")){
            options.setSombraHorizontal(getValue(label));
        } else if (label.startsWith("Vertical")){
            options.setSombraVertical(getValue(label));
        }
    }

    private int getValue(String label)
    {
        int retorno = 0;
        
        if (label.endsWith("None")){
            retorno = 0;
        } else if ((label.endsWith("Up"))||(label.endsWith("Left"))){
            retorno = -1;            
        } else if ((label.endsWith("Down")||(label.endsWith("Right")))){
            retorno = 1;
        }
        
        return retorno;
    }
}
