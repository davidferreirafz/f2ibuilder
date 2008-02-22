package com.wordpress.dukitan.componentes.browser.type;

import java.io.IOException;

/**
 * Design Pattern: GoF - Factory Method
 * 
 * @author david
 *
 */
public class BrowserLinux implements Browser
{   
    @Override
    public boolean execute(String url)
    {
        boolean open = true;
        
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("firefox "+url);
        } catch (IOException e) {
            try {
                rt.exec("mozilla-firefox "+url);
            } catch (IOException e1) {
                open = false;
            }
        }
        
        return open;
    }

}
