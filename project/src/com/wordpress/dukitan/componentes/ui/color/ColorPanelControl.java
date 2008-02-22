package com.wordpress.dukitan.componentes.ui.color;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JColorChooser;

public class ColorPanelControl extends MouseAdapter
{
    private String title;
    
    ColorPanelControl()
    {
        setTitle("Choose Color");
    }
            
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {       
        if (e.getComponent() instanceof ColorPanel) {
            execute(e.getComponent());
        }
    }
    
    protected void execute(Component component)
    {
        Color cor = JColorChooser.showDialog(component,getTitle(),component.getForeground());

        component.setBackground(cor);
    }    

}
