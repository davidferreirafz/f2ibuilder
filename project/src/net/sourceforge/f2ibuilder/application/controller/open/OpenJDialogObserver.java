package net.sourceforge.f2ibuilder.application.controller.open;

import javax.swing.JDialog;

import com.wordpress.dukitan.componentes.gof.observer.Observer;

public class OpenJDialogObserver extends OpenJDialog
{
    public OpenJDialogObserver(JDialog window)
    {
        super(window);
    }

    @Override
    protected void windowStyle()
    {
        window.setModal(false);
    }
    
    @Override
    protected void update()
    {
        if (window instanceof Observer) {
            Observer observer = (Observer) window;
            observer.update();
        }
    }
}
