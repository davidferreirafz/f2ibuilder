package net.sourceforge.f2ibuilder.application.controller.metrics;

import javax.swing.JTable;

import net.sourceforge.f2ibuilder.application.controller.generics.SaveItemTable;
import net.sourceforge.f2ibuilder.application.model.FontText;


public class SaveMetric extends SaveItemTable
{
    public SaveMetric(FontText fontText, JTable table)
    {
        super(fontText,table);       
    }

    @Override
    protected void setValue(int caracter, int value)
    {
        fontText.setCharacterMetric(caracter,value);
    }
}
