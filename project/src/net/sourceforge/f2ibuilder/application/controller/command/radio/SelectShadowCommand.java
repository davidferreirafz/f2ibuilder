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
package net.sourceforge.f2ibuilder.application.controller.command.radio;

import javax.swing.JRadioButtonMenuItem;

import net.sourceforge.f2ibuilder.application.model.FontText;
import net.sourceforge.f2ibuilder.application.model.Options;


public class SelectShadowCommand extends RadioCommand
{
    public SelectShadowCommand(Options options, FontText fontText)
    {
        super(options,fontText);
    }
    
    @Override
    protected void action(JRadioButtonMenuItem radio)
    {
        String label = radio.getName();
        
        if (label.startsWith("Horizontal")){
            options.setSombraHorizontal(getValue(label));
        } else if (label.startsWith("Vertical")){
            options.setSombraVertical(getValue(label));
        }
    }

    private int getValue(String label)
    {
        int retorno = 0;
        
        if (label.endsWith("None")){
            retorno = 0;
        } else if ((label.endsWith("Up"))||(label.endsWith("Left"))){
            retorno = -1;            
        } else if ((label.endsWith("Down")||(label.endsWith("Right")))){
            retorno = 1;
        }
        
        return retorno;
    }
}
