package net.sourceforge.f2ibuilder.application.controller.open;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
/**
 * Design Pattern: GoF - Template Method
 * 
 * @author david
 *
 */
public class OpenJDialog implements ActionListener
{
    protected JDialog window;
    
    public OpenJDialog(JDialog window)
    {
        if (window==null){
            System.err.println("No JDialog set! Please see OpenJDialog constructor");
        } else {
            this.window=window;
            windowStyle();
        }        
    }

    protected void windowStyle()
    {
        this.window.setModal(true);
    }

    @Override
    final public void actionPerformed(ActionEvent e)
    {
        show();
        update();
    }
    
    private void show()
    {
        window.setVisible(true);
    }

    protected void update(){}

}
