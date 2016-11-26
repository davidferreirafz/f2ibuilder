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
package net.sourceforge.f2ibuilder.application.controller.file;

import java.awt.Component;
import java.io.File;

import javax.swing.JOptionPane;

import net.sourceforge.f2ibuilder.application.controller.generics.SaveFile;
import net.sourceforge.f2ibuilder.components.dialog.FileDialog;
import net.sourceforge.f2ibuilder.components.memento.IMementoSupported;
import net.sourceforge.f2ibuilder.components.memento.MementoXML;

public class SaveFileProject extends SaveFile
{
    private IMementoSupported form;
    
    public SaveFileProject(IMementoSupported form)
    {
        this.form=form;
    }

    @Override
    protected void action(Component component)
    {   
        FileDialog fd = FileDialog.getInstance();            
        
        if(fd.showSaveDialogProject(component)){
            
            String filename = fd.getFilePathProject();

            if (!filename.endsWith(".f2i")){
                filename+=".f2i";
            }
            
            MementoXML xml = new MementoXML(new File(filename));

            try {
                xml.toFile(form.createMemento());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Save Project: "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
