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
 * Determina o posicionamento para o efeito de sombra
 * 
 * Designer Pattern: Strategy
 * 
 * @author David Ferreira 
 * @email davidferreira.fz@gmail.com
 *
 */
public class ShadowEffect extends ShadowStrategy
{
    /**
     * Construtor
     * @param horizontal posi��o horizontal da sombra em rela��o a fonte
     * @param vertical posi��o vertical da sombra em rela��o a fonte
     */
    public ShadowEffect(int horizontal, int vertical)
    {
        super(horizontal, vertical);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Dimension adjustShadow()
    {
        Dimension ajuste = new Dimension(horizontal(),vertical());
        
        if (ajuste.width<0){
            ajuste.width=0;
        }

        if (ajuste.height<0){
            ajuste.height=0;
        }        
        
        return ajuste;
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public Dimension adjustFont()
    {
        Dimension ajuste = new Dimension(0,0);
        
        if (horizontal()<0){
            ajuste.width=horizontal()*(-1);
        }

        if (vertical()<0){
            ajuste.height=vertical()*(-1);
        }        
        
        return ajuste;
    }
}
