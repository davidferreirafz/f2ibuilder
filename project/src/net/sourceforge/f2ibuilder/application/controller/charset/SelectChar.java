package net.sourceforge.f2ibuilder.application.controller.charset;

import javax.swing.JLabel;
import javax.swing.JTable;

import net.sourceforge.f2ibuilder.application.controller.generics.SelectItemTable;
import net.sourceforge.f2ibuilder.application.model.FontText;


public class SelectChar extends SelectItemTable
{    
    public SelectChar(JTable table,JLabel asciiPreview, JLabel formatPreview, FontText fontText)
    {
        super(fontText,table,asciiPreview,formatPreview);
    }

    @Override
    protected String getPreview(int x, int y)
    {
        String t =(String) table.getModel().getValueAt(y,x);
        
        if ((t==null)||(t.equals(""))){
            t = "0";
        }
        
        int a = Integer.parseInt(t);
        char ac = (char) a;
                
        return String.valueOf(ac);
    }
    
    

}
