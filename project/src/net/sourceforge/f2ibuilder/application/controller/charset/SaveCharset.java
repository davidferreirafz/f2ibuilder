package net.sourceforge.f2ibuilder.application.controller.charset;

import javax.swing.JTable;

import net.sourceforge.f2ibuilder.application.controller.generics.SaveItemTable;
import net.sourceforge.f2ibuilder.application.model.FontText;


public class SaveCharset extends SaveItemTable
{
    protected JTable table;    
    
    public SaveCharset(FontText fontText, JTable table)
    {
        super(fontText,table);       
    }

    @Override
    protected void setValue(int caracter, int value)
    {
        fontText.setCharacter(caracter,value);
    }
}
