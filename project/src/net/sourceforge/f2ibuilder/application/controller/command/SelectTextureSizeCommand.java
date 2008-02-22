package net.sourceforge.f2ibuilder.application.controller.command;

import java.awt.event.ItemEvent;

import net.sourceforge.f2ibuilder.application.model.Options;


public class SelectTextureSizeCommand implements java.awt.event.ItemListener 
{
    private Options options;
    
    public SelectTextureSizeCommand(Options options)
    {
        this.options=options;
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {                
        if (e.getStateChange()==ItemEvent.SELECTED){
            //System.out.println("SelectTextureSizeCommand.itemStateChanged()"+e.getItem().toString());
            //fontText.setFontName(e.getItem().toString());
            
            String item = e.getItem().toString();
            int size = 0;
            
            if (!item.equalsIgnoreCase("auto")){
                size=Integer.parseInt(item);
            }           
            
            options.setTextureSize(size);
        }          
    }   
}
