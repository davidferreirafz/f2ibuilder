/*****************************************************************************/
/* DukItan         -  DukItan Software Components                            */
/* E-Mail          -  davidferreira.fz@gmail.com                             */
/* Site            -  http://davidferreirafz.wordpress.com                   */ 
/* ICQ: 21877381      MSN: davidaf@uol.com.br                                */
/* G.talk: davidferreira.fz@gmail.com                                        */
/* Copyright (C) 2008  David de Almeida Ferreira                             */
/*****************************************************************************/
/*                                                                           */
/* Este arquivo � parte do projeto DSC - DukItan Software Components         */
/*                                                                           */
/* DSC � um software livre; voc� pode redistribui-lo e/ou                    */
/* modifica-lo dentro dos termos da Licen�a P�blica Geral (GPL) GNU          */
/* como publicada pela Funda��o do Software Livre (FSF); na vers�o 2 da      */
/* Licen�a                                                                   */
/*                                                                           */
/*****************************************************************************/
/*                                                                           */
/* This file is part of project DSC - DukItan Software Components            */
/*                                                                           */
/* DSC is free software; you can redistribute it and/or modify               */
/* it under the terms of the GNU  Lesser General Public License (LGPL) as    */
/* published by the Free Software Foundation; either version 2 of the        */
/* License.                                                                  */
/*                                                                           */
/*****************************************************************************/
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
