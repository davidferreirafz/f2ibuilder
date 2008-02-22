package net.sourceforge.f2ibuilder.application.controller.command;

import java.awt.event.ItemEvent;

import javax.swing.JRadioButtonMenuItem;

import net.sourceforge.f2ibuilder.application.model.Options;


public class SelectImageTypeCommand implements java.awt.event.ItemListener 
{
    private Options options;
    
    public SelectImageTypeCommand(Options options)
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
                
                if (label.equalsIgnoreCase("BMP")){
                    options.setImageType(Options.IMAGE_TYPE_BMP);
                } else {
                    options.setImageType(Options.IMAGE_TYPE_PNG);                    
                }
            }          
        }
    }
}
