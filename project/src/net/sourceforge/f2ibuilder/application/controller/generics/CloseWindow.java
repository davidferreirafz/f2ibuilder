package net.sourceforge.f2ibuilder.application.controller.generics;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CloseWindow implements ActionListener 
{
    protected Window window;
    
    public CloseWindow(Window window)
    {
        this.window=window;
    }
    
    public Window getWindow()
    {
        return window;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (window!=null){
            window.dispose();
        } else {
            System.err.println("No window set! Please see CloseWindow constructor");
        }
    }

}
