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
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.sourceforge.f2ibuilder.application.controller.generics.SaveFile;
import net.sourceforge.f2ibuilder.application.model.FontText;
import net.sourceforge.f2ibuilder.application.model.Options;
import net.sourceforge.f2ibuilder.application.view.image.FontImage;
import net.sourceforge.f2ibuilder.components.dialog.FileDialog;

public class SaveFileImage extends SaveFile
{
    private FontImage fontImage;
    private Options options;
    private FontText fontText;
    
    public SaveFileImage(FontText fontText, Options options,FontImage fontImage)
    {
        this.fontText=fontText;
        this.options=options;
        this.fontImage=fontImage;
    }

    @Override
    protected void action(Component component)
    {
        FileDialog fd = FileDialog.getInstance(); 
        
        if(fd.showSaveDialogImage(component)){
            
            String filename = fd.getFilePathImage();
            RenderedImage image = fontImage.getImage();
            
            try {
                if (image!=null){
                    if (!filename.endsWith(options.getImagemTipo())){
                        filename+="."+options.getImagemTipo();
                    }

                    ImageIO.write(image,options.getImagemTipo(),new File(filename));
                }
                
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

    }

}
