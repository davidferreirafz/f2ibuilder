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
package net.sourceforge.f2ibuilder.application.view.image.draw.shadow;

import java.awt.Dimension;

/**
 * Algoritmo para Aplicação de Sombra a Fonte.
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
     * @param horizontal posição horizontal da sombra em relação a fonte
     * @param vertical posição vertical da sombra em relação a fonte
     */
    public ShadowStrategy(int horizontal, int vertical)
    {
        this.horizontal=horizontal;
        this.vertical=vertical;
    }
    
    /**
     * Informa se o desenho da sombra está ativo
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
     * Ajusta a posição a ser desenhada para a Sombra.
     * @return deslocamento para desenho da sombra.
     */
    abstract public Dimension adjustShadow();
    
    /**
     * Ajusta a posição a ser desenhada para a Fonte. 
     * @return deslocamento para desenho da fonte.
     */
    abstract public Dimension adjustFont();    
}
