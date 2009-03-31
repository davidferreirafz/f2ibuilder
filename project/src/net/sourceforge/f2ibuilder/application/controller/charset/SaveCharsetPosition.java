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

import javax.swing.JTextField;

import net.sourceforge.f2ibuilder.application.controller.generics.base.FontTextAction;
import net.sourceforge.f2ibuilder.application.model.FontText;


public class SaveCharsetPosition extends FontTextAction
{
    private JTextField width;
    private JTextField height;  
    
    public SaveCharsetPosition(FontText fontText, JTextField width, JTextField height)
    {
        super(fontText);
        this.width=width;
        this.height=height;
    }

    @Override
    protected void action()
    {
        int largura=Integer.parseInt(width.getText());
        int altura=Integer.parseInt(height.getText());
        
        fontText.setPositionAdjust(largura, altura);
    }
    

}
