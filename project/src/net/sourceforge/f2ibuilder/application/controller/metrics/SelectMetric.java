package net.sourceforge.f2ibuilder.application.controller.metrics;

import javax.swing.JLabel;
import javax.swing.JTable;

import net.sourceforge.f2ibuilder.application.controller.generics.SelectItemTable;
import net.sourceforge.f2ibuilder.application.model.FontText;


public class SelectMetric extends SelectItemTable
{  
    public SelectMetric(JTable table,FontText fontText,JLabel asciiPreview, JLabel formatPreview)
    {
        super(fontText,table,asciiPreview,formatPreview);
    }

    @Override
    protected String getPreview(int x, int y)
    {
        int position = (0+x)+(16*y);
        
        return fontText.getCharacter(position);
    }
    

}
