package net.sourceforge.f2ibuilder.application.controller.command;

import java.awt.event.ItemEvent;

import javax.swing.JCheckBoxMenuItem;

import net.sourceforge.f2ibuilder.application.model.Options;


public class UseAntialiasCommand implements java.awt.event.ItemListener 
{
    private Options options;
    
    public UseAntialiasCommand(Options options)
    {
        this.options=options;
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {                
        if (e.getSource() instanceof JCheckBoxMenuItem) {
            JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
            
            options.setAntialias(menuItem.getState());
        }          
    }   
}
