package net.sourceforge.f2ibuilder.application.controller.charset;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTable;

import net.sourceforge.f2ibuilder.application.model.FontText;




public class SelectChar extends MouseAdapter
{
    protected JTable table;
    private JLabel asciiPreview;
    private JLabel formatPreview;
    private FontText fontText;    
    
    public SelectChar(JTable table,JLabel asciiPreview, JLabel formatPreview, FontText fontText)
    {
        this.table = table;
        this.asciiPreview = asciiPreview;
        this.formatPreview = formatPreview;
        this.fontText = fontText;        
    }
    
    @Override
    public void mouseClicked(MouseEvent e)
    {
        int x = table.getSelectedColumn();
        int y = table.getSelectedRow();
        
        String t =(String) table.getModel().getValueAt(y,x);
        
        if ((t==null)||(t.equals(""))){
            t = "0";
        }
        
        int a = Integer.parseInt(t);
        char ac = (char) a;
                
        asciiPreview.setText(String.valueOf(ac));
        
        int tamanho = fontText.getFontSize();        
        if (tamanho > 26){
            tamanho = 26;
        }
        
        formatPreview.setFont(new Font(fontText.getFontName(),Font.PLAIN,tamanho));
        formatPreview.setText(asciiPreview.getText());
    }
    

}
