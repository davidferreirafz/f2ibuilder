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
package net.sourceforge.f2ibuilder.application.view.image.draw.shadow;

import java.awt.Dimension;

/**
 * Algoritmo para Aplica��o de Sombra a Fonte.
 * 
 * Design Pattern: GoF - Strategy 
 * 
 * @author David Ferreira - davidferreira.fz@gmail.com
 */
public abstract class ShadowStrategy
{
    private int horizontal;
    private int vertical;
    
    /**
     * Construtor
     * @param horizontal posi��o horizontal da sombra em rela��o a fonte
     * @param vertical posi��o vertical da sombra em rela��o a fonte
     */
    public ShadowStrategy(int horizontal, int vertical)
    {
        this.horizontal=horizontal;
        this.vertical=vertical;
    }
    
    /**
     * Informa se o desenho da sombra est� ativo
     * @return true em caso de ativo
     */
    public boolean isActive()
    {
        return ((horizontal!=0)||(vertical!=0));
    }
    
    protected int horizontal()
    {
        return horizontal;
    }
    
    protected int vertical()
    {
        return vertical;
    }
    
    /**
     * Ajusta a posi��o a ser desenhada para a Sombra.
     * @return deslocamento para desenho da sombra.
     */
    abstract public Dimension adjustShadow();
    
    /**
     * Ajusta a posi��o a ser desenhada para a Fonte. 
     * @return deslocamento para desenho da fonte.
     */
    abstract public Dimension adjustFont();    
}
