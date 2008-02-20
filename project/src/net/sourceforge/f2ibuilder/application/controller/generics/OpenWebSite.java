package net.sourceforge.f2ibuilder.application.controller.generics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.google.code.p.f2ibuilder.util.Constante;
import com.wordpress.dukitan.componentes.browser.FacadeBrowser;



public class OpenWebSite extends MouseAdapter implements ActionListener
{
    
    @Override
    public void mouseClicked(MouseEvent e)
    {
        action();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        action();
    }
    
    private void action()
    {
        FacadeBrowser.openURL(Constante.WEB_SITE);        
    }
    

}
