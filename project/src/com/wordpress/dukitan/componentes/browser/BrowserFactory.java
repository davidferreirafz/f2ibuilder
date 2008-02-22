package com.wordpress.dukitan.componentes.browser;

import com.wordpress.dukitan.componentes.browser.type.BrowserLinux;
import com.wordpress.dukitan.componentes.browser.type.BrowserMsWindows;
import com.wordpress.dukitan.componentes.browser.type.Browser;

/**
 * Design Pattern: GoF - Factory Method
 * 
 * @author david
 *
 */
public class BrowserFactory
{
    public static Browser getBrowser()
    {
        String so = System.getProperty("os.name");
        Browser browser;
        
        if (so.startsWith("Windows")){
            browser = new BrowserMsWindows();
        } else {
            System.out.println(so);
            browser = new BrowserLinux();
        }        

        return browser;
    }

}
