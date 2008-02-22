package net.sourceforge.f2ibuilder.application.controller.command;

import java.awt.event.ItemEvent;

import javax.swing.JToggleButton;

import net.sourceforge.f2ibuilder.application.model.FontText;


public class BoldCommand implements java.awt.event.ItemListener 
{
    private FontText model;
    
    public BoldCommand(FontText model)
    {
        this.model=model;
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        Object oSource = e.getSource();
        if (oSource instanceof JToggleButton) {
            JToggleButton button =(JToggleButton) oSource;

            // Seleção de Negrito                   
            if (button.getText().equalsIgnoreCase("Bold")){
                if (e.getStateChange()==1){
                    model.setBold(true);
                } else {
                    model.setBold(false);                   
                }
            }
        }
    }   
}
