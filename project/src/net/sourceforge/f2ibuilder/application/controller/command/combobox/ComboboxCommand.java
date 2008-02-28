package net.sourceforge.f2ibuilder.application.controller.command.combobox;

import java.awt.event.ItemEvent;

import net.sourceforge.f2ibuilder.application.controller.generics.base.SelectCommand;
import net.sourceforge.f2ibuilder.application.model.FontText;
import net.sourceforge.f2ibuilder.application.model.Options;


public abstract class ComboboxCommand extends SelectCommand
{    
    public ComboboxCommand(Options options, FontText fontText)
    {
        super(options,fontText);
    }

    @Override
    final public void itemStateChanged(ItemEvent e)
    {                
        if (e.getStateChange()==ItemEvent.SELECTED){
            String value = e.getItem().toString();
            
            if (value!=null){
                action(value);
            }
        } 
    }   
    
    protected abstract void action(String value);
}
