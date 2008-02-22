package net.sourceforge.f2ibuilder.application.controller.command;

import java.awt.event.ItemEvent;

import net.sourceforge.f2ibuilder.application.model.FontText;


public class SelectSizeCommand implements java.awt.event.ItemListener 
{
    private FontText model;
    
    public SelectSizeCommand(FontText model)
    {
        this.model=model;
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        if (e.getStateChange()==ItemEvent.SELECTED){
            //System.out.println("SelectSizeCommand.itemStateChanged()"+e.getItem().toString());
            String t = e.getItem().toString();
            
            if (t!=null){
                int size =Integer.parseInt(e.getItem().toString()); 
                model.setFontSize(size);                
            }
        }                
    }   
}
