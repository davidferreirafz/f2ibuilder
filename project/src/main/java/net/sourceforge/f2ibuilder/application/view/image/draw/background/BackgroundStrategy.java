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
package net.sourceforge.f2ibuilder.application.view.image.draw.background;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 * Algoritmo para desenhar o background da imagem.
 * 
 * Design Pattern: GoF - Strategy 
 * 
 * @author David Ferreira - davidferreira.fz@gmail.com
 */
abstract public class BackgroundStrategy
{
    /**
     * Desenha a cor de fundo
     * @param graphics Contexto Gr�fico
     * @param color cor de fundo
     * @param dimension dimens�o da imagem
     */
    public abstract void draw(Graphics graphics, Color color, Dimension dimension);

    /**
     * Retorna o tipo de sistema de cores a ser utilizado na imagem
     * @return Tipo de cores a ser utilizado
     */
    public abstract int getColorChannel();

}
