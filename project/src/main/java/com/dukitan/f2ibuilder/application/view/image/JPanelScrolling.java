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
package com.dukitan.f2ibuilder.application.view.image;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;

/**
 * Panel com barra de Scrolling.
 * 
 * 
 * @author David Ferreira - davidferreira.fz@gmail.com
 */
@SuppressWarnings("serial")
public abstract class JPanelScrolling extends JPanel implements Scrollable
{
    /**
     * Construtor
     */
    public JPanelScrolling()
    {
        setDoubleBuffered(true);
    }
    

    final public Dimension getPreferredScrollableViewportSize()
    {
        return getWindowSize();
    }
    

    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction)
    {
        return getScrollableUnitIncrement(visibleRect, orientation, direction)*4;
    }  


    public boolean getScrollableTracksViewportHeight()
    {
        return false;
    }


    public boolean getScrollableTracksViewportWidth()
    {
        return false;
    }
   

    final public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction)
    {
        int retorno=0;
        
        Dimension d=getSize();
        
        if (orientation==SwingConstants.VERTICAL) {
            retorno=d.height/16;
        } else {
            retorno=d.width/16;         
        }

        return retorno;
    }

    /**
     * Retorna o tamanho da area do panel.
     * @return Dimens�o do panel
     */
    abstract protected Dimension getWindowSize();
}
