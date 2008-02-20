package net.sourceforge.f2ibuilder.application.controller.metrics;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTable;

import net.sourceforge.f2ibuilder.application.model.FontText;




public class SelectMetric extends MouseAdapter
{
    protected JTable table;
    private JLabel asciiPreview;
    private JLabel formatPreview;
    private FontText tableChar;
    
    public SelectMetric(JTable table,FontText tableChar ,JLabel asciiPreview, JLabel formatPreview)
    {
        this.table = table;
        this.tableChar = tableChar;
        this.asciiPreview = asciiPreview;
        this.formatPreview = formatPreview;

    }
    
    @Override
    public void mouseClicked(MouseEvent e)
    {
        int x = table.getSelectedColumn();
        int y = table.getSelectedRow();

        int position = (0+x)+(16*y);
        
        String text = tableChar.getCharacter(position);

        asciiPreview.setText(text);
        
        int tamanho = tableChar.getFontSize();
        if (tamanho > 26){
            tamanho = 26;
        }
        
        formatPreview.setFont(new Font(tableChar.getFontName(),Font.PLAIN,tamanho));
        formatPreview.setText(asciiPreview.getText());
    }
    

}
