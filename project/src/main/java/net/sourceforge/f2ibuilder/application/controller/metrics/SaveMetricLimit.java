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
package net.sourceforge.f2ibuilder.application.controller.metrics;

import javax.swing.JTextField;

import net.sourceforge.f2ibuilder.application.controller.generics.base.FontTextAction;
import net.sourceforge.f2ibuilder.application.model.FontText;


public class SaveMetricLimit extends FontTextAction
{
    private JTextField minor;
    private JTextField higher;  
    
    public SaveMetricLimit(FontText fontText, JTextField minor, JTextField higher)
    {
        super(fontText);
        this.minor=minor;
        this.higher=higher;
    }

    @Override
    protected void action()
    {
        int menor=Integer.parseInt(minor.getText());
        int maior=Integer.parseInt(higher.getText());
        
        fontText.setLimits(menor, maior);
    }
    

}
