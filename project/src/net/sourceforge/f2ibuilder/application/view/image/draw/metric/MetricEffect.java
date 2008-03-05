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
package net.sourceforge.f2ibuilder.application.view.image.draw.metric;

import java.awt.Dimension;
import java.awt.Point;

import net.sourceforge.f2ibuilder.application.model.FontText;
import net.sourceforge.f2ibuilder.components.type.Counter;

/**
 * Aplica o algoritmo para utiliza��o m�tricas.
 * 
 * Designer Pattern: Strategy
 * 
 * @author David Ferreira - davidferreira.fz@gmail.com
 */
public class MetricEffect extends MetricStrategy
{

    @Override
    /**
     * {@inheritDoc}
     */    
    public Dimension adjust(Dimension ajuste, Dimension dimensao, FontText fontText)
    {
        return ajuste;        
    }
    /**
     * {@inheritDoc}
     */
    public Point position(Counter count, Dimension dimensao, Dimension ajuste, FontText fontText)
    {
        Point p = new Point(0,0);
        
        p.x=(count.column()*dimensao.width)+ajuste.width;
        p.y=(count.line()*dimensao.height)+ajuste.height+fontText.getFontAscent();
        
        return p;
    }
   

}
