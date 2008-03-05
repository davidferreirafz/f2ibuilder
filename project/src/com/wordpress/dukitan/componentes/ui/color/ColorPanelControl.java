/*****************************************************************************/
/* DukItan         -  DukItan Software Components                            */
/* E-Mail          -  davidferreira.fz@gmail.com                             */
/* Site            -  http://davidferreirafz.wordpress.com                   */ 
/* ICQ: 21877381      MSN: davidaf@uol.com.br                                */
/* G.talk: davidferreira.fz@gmail.com                                        */
/* Copyright (C) 2008  David de Almeida Ferreira                             */
/*****************************************************************************/
/*                                                                           */
/* Este arquivo � parte do projeto DSC - DukItan Software Components         */
/*                                                                           */
/* DSC � um software livre; voc� pode redistribui-lo e/ou                    */
/* modifica-lo dentro dos termos da Licen�a P�blica Geral (GPL) GNU          */
/* como publicada pela Funda��o do Software Livre (FSF); na vers�o 2 da      */
/* Licen�a                                                                   */
/*                                                                           */
/*****************************************************************************/
/*                                                                           */
/* This file is part of project DSC - DukItan Software Components            */
/*                                                                           */
/* DSC is free software; you can redistribute it and/or modify               */
/* it under the terms of the GNU  Lesser General Public License (LGPL) as    */
/* published by the Free Software Foundation; either version 2 of the        */
/* License.                                                                  */
/*                                                                           */
/*****************************************************************************/
package com.wordpress.dukitan.componentes.ui.color;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JColorChooser;

/**
 * Classe de Controle para ColorPanel, encapsula as a��es de sele��o de cores
 * e muda a cor de ColorPanel para a cor selecionada.
 * 
 * @author David Ferreira - davidferreira.fz@gmail.com
 */
public class ColorPanelControl extends MouseAdapter
{
    private String title;

    /**
     * Constutor
     */
    ColorPanelControl()
    {
        setTitle("Choose Color");
    }

    /**
     * Informa t�tulo da janela de dialog
     * @param title t�tulo da janela
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Retorna o t�tulo da janela
     * @return t�tulo da janela
     */
    public String getTitle()
    {
        return title;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {       
        if (e.getComponent() instanceof ColorPanel) {
            execute(e.getComponent());
        }
    }
    
    /**
     * Executa a opera��o de abrir a caixa de dialog e selecionar a cor.
     * @param component
     */
    protected void execute(Component component)
    {
        Color cor = JColorChooser.showDialog(component,getTitle(),component.getForeground());

        component.setBackground(cor);
    }    

}
