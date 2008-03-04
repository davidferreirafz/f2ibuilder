/*****************************************************************************/
/* F2IBuilder      -  Font to Image Builder                                  */
/* E-Mail          -  davidferreira.fz@gmail.com                             */
/* Site            -  http://f2ibuilder.sourceforge.net                      */
/* Blog            -  http://davidferreirafz.wordpress.com                   */ 
/* ICQ: 21877381      MSN: davidaf@uol.com.br                                */
/* G.talk: davidferreira.fz@gmail.com                                        */
/* Copyright (C) 2006-2008  David de Almeida Ferreira                        */
/*****************************************************************************/
/*                                                                           */
/* Este arquivo � parte do programa F2IBuilder.                              */
/*                                                                           */
/* F2IBuilder � um software livre; voc� pode redistribui-lo e/ou             */
/* modifica-lo dentro dos termos da Licen�a P�blica Geral (GPL) GNU          */
/* como publicada pela Funda��o do Software Livre (FSF); na vers�o 2 da      */
/* Licen�a                                                                   */
/*                                                                           */
/*****************************************************************************/
/*                                                                           */
/* This file is part of F2IBuilder.                                          */
/*                                                                           */
/* F2IBuilder is free software; you can redistribute it and/or modify        */
/* it under the terms of the GNU  Lesser General Public License (LGPL) as    */
/* published by the Free Software Foundation; either version 2 of the        */
/* License.                                                                  */
/*                                                                           */
/*****************************************************************************/
package net.sourceforge.f2ibuilder.application.controller.file;

import java.awt.Component;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import net.sourceforge.f2ibuilder.application.controller.generics.SaveFile;
import net.sourceforge.f2ibuilder.application.model.FontText;
import net.sourceforge.f2ibuilder.components.dialog.FileDialog;

public class SaveFileXNA extends SaveFile
{
    private FontText fontText;
    
    public SaveFileXNA(FontText fontText)
    {
        this.fontText=fontText;
    }

    @Override
    protected void action(Component component)
    {
        BufferedWriter out;        
        FileDialog fd = FileDialog.getInstance();            
        
        if(fd.showSaveDialogMetric(component)){
            
            String filename = fd.getFilePathMetric();
            
            try {
                char v[] = new char[256];           

                for (int i=0; i<256; i++)
                {
                    v[i]=(char) fontText.getCharacterMetric(i);
                }

                if (!filename.endsWith("spritefont")){
                    filename+=".spritefont";
                }

                out = new BufferedWriter(new FileWriter(filename));
                out.write(v);
                out.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

}
