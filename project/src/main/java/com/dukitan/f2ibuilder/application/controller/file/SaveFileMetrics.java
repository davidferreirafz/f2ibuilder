/*****************************************************************************/
/* F2IBuilder      -  Font to Image Builder                                  */
/* E-Mail          -  davidferreira.fz@gmail.com                             */
/* Site            -  http://f2ibuilder.dukitan.com                          */
/* Blog            -  http://fztech.dukitan.com                              */ 
/* ICQ: 21877381      MSN: davidaf@uol.com.br                                */
/* G.talk: davidferreira.fz@gmail.com                                        */
/* Copyright (C) 2006-2008  David de Almeida Ferreira                        */
/*****************************************************************************/
/*                                                                           */
/* Este arquivo é parte do programa F2IBuilder.                              */
/*                                                                           */
/* F2IBuilder é um software livre; você pode redistribui-lo e/ou             */
/* modifica-lo dentro dos termos da Licença Pública Geral (GPL) GNU          */
/* como publicada pela Fundação do Software Livre (FSF); na versão 2 da      */
/* Licença                                                                   */
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
package com.dukitan.f2ibuilder.application.controller.file;

import java.awt.Component;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.dukitan.f2ibuilder.application.controller.generics.SaveFile;
import com.dukitan.f2ibuilder.application.model.FontText;
import com.dukitan.f2ibuilder.components.dialog.FileDialog;

public class SaveFileMetrics extends SaveFile
{
    private FontText fontText;
    
    public SaveFileMetrics(FontText fontText)
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

                if (!filename.endsWith("dat")){
                    filename+=".dat";
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
