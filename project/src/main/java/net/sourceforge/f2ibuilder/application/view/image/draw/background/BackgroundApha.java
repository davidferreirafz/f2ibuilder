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
package net.sourceforge.f2ibuilder.application.view.image.draw.background;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


/**
 * Aplica o algoritmo para usar alpha no background.
 * 
 * Designer Pattern: Strategy
 * 
 * @author David Ferreira - davidferreira.fz@gmail.com
 */
public class BackgroundApha extends BackgroundStrategy
{
    /**
     * {@inheritDoc}
     */    
    public void draw(Graphics graphics, Color color, Dimension dimension)
    {
        Graphics2D g2 = (Graphics2D) graphics;
        AlphaComposite ac =AlphaComposite.getInstance(AlphaComposite.SRC,1.0f);         
        g2.setComposite(ac);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getColorChannel()
    {
        //Caso a imagem seja PNG, usar RGB com Alpha
        return BufferedImage.TYPE_INT_ARGB;
    }
}
