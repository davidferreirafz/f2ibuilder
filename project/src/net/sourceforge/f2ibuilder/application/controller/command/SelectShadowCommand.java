package net.sourceforge.f2ibuilder.application.controller.command;

import java.awt.event.ItemEvent;

import javax.swing.JRadioButtonMenuItem;

import net.sourceforge.f2ibuilder.application.model.Options;


public class SelectShadowCommand implements java.awt.event.ItemListener 
{
    private Options options;
    
    public SelectShadowCommand(Options options)
    {
        this.options=options;
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {                
        if (e.getStateChange() == ItemEvent.SELECTED){
            if (e.getSource() instanceof JRadioButtonMenuItem) {
                JRadioButtonMenuItem menuItem = (JRadioButtonMenuItem) e.getSource();
                
                String label = menuItem.getName();
                
                if (label.startsWith("Horizontal")){
                    options.setSombraHorizontal(getValue(label));
                } else if (label.startsWith("Vertical")){
                    options.setSombraVertical(getValue(label));
                }
            }          
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
