package net.sourceforge.f2ibuilder.application.controller.command.checkbox;

import java.awt.event.ItemEvent;

import javax.swing.JCheckBoxMenuItem;

import net.sourceforge.f2ibuilder.application.controller.generics.base.SelectCommand;
import net.sourceforge.f2ibuilder.application.model.FontText;
import net.sourceforge.f2ibuilder.application.model.Options;


public abstract class CheckBoxCommand extends SelectCommand
{    
    public CheckBoxCommand(Options options, FontText fontText)
    {
        super(options,fontText);
    }

    @Override
    final public void itemStateChanged(ItemEvent e)
    {                
        if (e.getSource() instanceof JCheckBoxMenuItem) {
            action((JCheckBoxMenuItem) e.getSource());
        }         
    }
    
    protected abstract void action(JCheckBoxMenuItem checkbox);  
}
