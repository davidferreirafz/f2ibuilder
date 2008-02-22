package com.wordpress.dukitan.componentes.browser.type;

import java.io.IOException;

/**
 * Design Pattern: GoF - Factory Method
 * 
 * @author david
 *
 */
public class BrowserMsWindows implements Browser
{   
    @Override
    public boolean execute(String url)
    {
        boolean open = true;
        Runtime rt = Runtime.getRuntime();
        
        try {
            rt.exec("rundll32 SHELL32.DLL,ShellExec_RunDLL "+url);
        } catch (IOException e) {
            open = false;
        }
        
        return open;
    }

}
