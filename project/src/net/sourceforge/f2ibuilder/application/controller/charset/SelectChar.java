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
package net.sourceforge.f2ibuilder.application.controller.charset;

import javax.swing.JLabel;
import javax.swing.JTable;

import net.sourceforge.f2ibuilder.application.controller.generics.SelectItemTable;
import net.sourceforge.f2ibuilder.application.model.FontText;


public class SelectChar extends SelectItemTable
{    
    public SelectChar(JTable table,JLabel asciiPreview, JLabel formatPreview, FontText fontText)
    {
        super(fontText,table,asciiPreview,formatPreview);
    }

    @Override
    protected String getPreview(int x, int y)
    {
        String t =(String) table.getModel().getValueAt(y,x);
        
        if ((t==null)||(t.equals(""))){
            t = "0";
        }
        
        int a = Integer.parseInt(t);
        char ac = (char) a;
                
        return String.valueOf(ac);
    }
    
    

}
