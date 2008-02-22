package net.sourceforge.f2ibuilder.application.controller.open;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;

import net.sourceforge.f2ibuilder.application.model.FontText;


public class LoadApplication extends WindowAdapter 
{
    private FontText fontText;
    private JComboBox comboBox;
    private JComboBox comboBox2;


    public LoadApplication(FontText fontText, JComboBox comboBox, JComboBox comboBox2)
    {
        this.fontText=fontText;
        this.comboBox=comboBox;
        this.comboBox2=comboBox2;
    }
    
    @Override
    public void windowOpened(WindowEvent e)
    {
        fontText.setFontName(comboBox.getSelectedItem().toString());
        int size = Integer.parseInt(comboBox2.getSelectedItem().toString());
        fontText.setFontSize(size);
        fontText.make();
    }
}
