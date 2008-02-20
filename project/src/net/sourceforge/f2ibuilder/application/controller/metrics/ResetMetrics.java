package net.sourceforge.f2ibuilder.application.controller.metrics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.sourceforge.f2ibuilder.application.model.FontText;




public class ResetMetrics implements ActionListener
{
    protected FontText tableChar;
    
    public ResetMetrics(FontText tableChar)
    {
        this.tableChar = tableChar;        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        reset();
    }
    
    private void reset()
    {
        tableChar.resetMetrics();
    }
    

}
