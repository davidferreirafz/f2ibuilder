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
package net.sourceforge.f2ibuilder.application.controller.open;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
/**
 * Design Pattern: GoF - Template Method
 * 
 * @author David Ferreira <davidferreira.fz@gmail.com>
 *
 * Project: F2IBuilder
 * Date: 08/03/2008
 *
 */
public class OpenJDialog implements ActionListener
{
    protected JDialog window;
    
    public OpenJDialog(JDialog window)
    {
        if (window==null){
            System.err.println("No JDialog set! Please see OpenJDialog constructor");
        } else {
            this.window=window;
            windowStyle();
        }        
    }

    protected void windowStyle()
    {
        this.window.setModal(true);
    }

    @Override
    final public void actionPerformed(ActionEvent e)
    {
        show();
        update();
    }
    
    private void show()
    {
        window.setVisible(true);
    }

    protected void update(){}

}
