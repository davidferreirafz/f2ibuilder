package net.sourceforge.f2ibuilder.application.controller.command.radio;

import java.awt.event.ItemEvent;

import javax.swing.JRadioButtonMenuItem;

import net.sourceforge.f2ibuilder.application.controller.generics.base.SelectCommand;
import net.sourceforge.f2ibuilder.application.model.FontText;
import net.sourceforge.f2ibuilder.application.model.Options;


public abstract class RadioCommand extends SelectCommand
{   
    public RadioCommand(Options options, FontText fontText)
    {
        super(options,fontText);
    }

    @Override
    final public void itemStateChanged(ItemEvent e)
    {                       
        if (e.getSource() instanceof JRadioButtonMenuItem) {
            if (e.getStateChange() == ItemEvent.SELECTED) { 
                action((JRadioButtonMenuItem) e.getSource());
            } else {
                deselect();
            }
        }
    }
    
    protected abstract void action(JRadioButtonMenuItem radio);
    
    protected void deselect()
    {}
}
