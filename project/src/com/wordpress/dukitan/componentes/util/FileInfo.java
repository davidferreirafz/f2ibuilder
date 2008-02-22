package com.wordpress.dukitan.componentes.util;

import java.io.File;

public class FileInfo
{
    private File file;
    private String extension = "";
    
    public FileInfo(File file)
    {
        this.file = file;
        process();
    }
    
    /* @see http://java.sun.com/docs/books/tutorial/uiswing/components/example-1dot4/Utils.java
     * Get the extension of a file.
     */
    
    protected void process()
    {
        if (file!=null){
            String nome = file.getName();
            
            int i = nome.lastIndexOf('.');              
            
            if (i > 0 &&  i < nome.length() - 1) {
                extension = nome.substring(i+1).toLowerCase();
            }
        }
    }
    
    public String getExtension()
    {
        return extension;
    }
    
    public boolean isImage()
    {
        if ((extension.equalsIgnoreCase("bmp"))||
            (extension.equalsIgnoreCase("png"))){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isMetrics()
    {
        if (extension.equalsIgnoreCase("dat")){
            return true;
        } else {
            return false;
        }
    }    
}
