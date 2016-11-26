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
package net.sourceforge.f2ibuilder.application.controller.generics;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;

import net.sourceforge.f2ibuilder.application.controller.generics.base.FontTextAction;
import net.sourceforge.f2ibuilder.application.model.FontText;




public abstract class SelectItemTable extends FontTextAction
{
    protected JTable table;
    private JLabel asciiPreview;
    private JLabel formatPreview;
    
    public SelectItemTable(FontText fontText, JTable table, JLabel asciiPreview, JLabel formatPreview)
    {
        super(fontText);
        this.table = table;
        this.asciiPreview = asciiPreview;
        this.formatPreview = formatPreview;

    }

    @Override
    final protected void action()
    {
        int x = table.getSelectedColumn();
        int y = table.getSelectedRow();

        asciiPreview.setText(getPreview(x,y));
        
        display();
    }
    
    abstract protected String getPreview(int x, int y);

    
    protected void display()
    {
        int tamanho = fontText.getFontSize();
        if (tamanho > 26){
            tamanho = 26;
        }
        
        formatPreview.setFont(new Font(fontText.getFontName(),Font.PLAIN,tamanho));
        formatPreview.setText(asciiPreview.getText());
    }
    

}
