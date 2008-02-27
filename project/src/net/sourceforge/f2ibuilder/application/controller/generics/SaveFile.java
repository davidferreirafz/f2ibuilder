package net.sourceforge.f2ibuilder.application.controller.generics;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class SaveFile implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e)
    {       
        if (e.getSource() instanceof Component) {
            action((Component) e.getSource());        
        }    
    }
    
    abstract protected void action(Component component);

}
