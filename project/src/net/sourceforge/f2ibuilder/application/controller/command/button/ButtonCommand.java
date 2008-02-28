package net.sourceforge.f2ibuilder.application.controller.command.button;

import java.awt.event.ItemEvent;

import javax.swing.JToggleButton;

import net.sourceforge.f2ibuilder.application.controller.generics.base.SelectCommand;
import net.sourceforge.f2ibuilder.application.model.FontText;
import net.sourceforge.f2ibuilder.application.model.Options;


public abstract class ButtonCommand extends SelectCommand
{    
    public ButtonCommand(Options options, FontText fontText)
    {
        super(options,fontText);
    }

    @Override
    final public void itemStateChanged(ItemEvent e)
    {                
        if (e.getSource() instanceof JToggleButton) {
            action((JToggleButton) e.getSource());
        }         
    }
    
    protected abstract void action(JToggleButton button);  
}
