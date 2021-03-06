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
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.dukitan.f2ibuilder.application.controller.generics.SaveFile;
import com.dukitan.f2ibuilder.application.model.Options;
import com.dukitan.f2ibuilder.application.view.image.FontImage;
import com.dukitan.f2ibuilder.components.dialog.FileDialog;

public class SaveFileImage extends SaveFile
{
    private FontImage fontImage;
    private Options options;
    
    public SaveFileImage(Options options,FontImage fontImage)
    {
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
