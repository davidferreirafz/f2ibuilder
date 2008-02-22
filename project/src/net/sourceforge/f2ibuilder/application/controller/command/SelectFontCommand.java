package net.sourceforge.f2ibuilder.application.controller.command;

import java.awt.event.ItemEvent;

import net.sourceforge.f2ibuilder.application.model.FontText;


public class SelectFontCommand implements java.awt.event.ItemListener 
{
    private FontText fontText;
    
    public SelectFontCommand(FontText fontText)
    {
        this.fontText=fontText;
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {                
        if (e.getStateChange()==ItemEvent.SELECTED){
            //System.out.println("SelectFontCommand.itemStateChanged()"+e.getItem().toString());
            fontText.setFontName(e.getItem().toString());
        }          
    }   
}
