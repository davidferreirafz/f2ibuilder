package net.sourceforge.f2ibuilder.application.controller.metrics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import net.sourceforge.f2ibuilder.application.model.FontText;




public class SaveMetric implements ActionListener
{
    protected FontText tableChar;
    protected JTable table;    
    
    public SaveMetric(FontText tableChar, JTable table)
    {
        this.tableChar = tableChar;
        this.table = table;        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        salvar();
    }
    
    private void salvar()
    {
        int caracter=0;
        
        tableChar.beginModify();
        
        for (int l=0; l<16; l++){
            for (int c=0;c<16;c++){               
                Object o = table.getModel().getValueAt(l,c);
                
                if (o!=null){
                    int valor = Integer.parseInt((String) o);
                    
                    tableChar.setCharacterMetric(caracter,valor);
                }
                caracter++;
            }
        }
        
        tableChar.endModify();
    }
    

}
