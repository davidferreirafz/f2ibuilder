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
package com.dukitan.f2ibuilder.application.view.image.draw.metric;

import java.awt.Dimension;
import java.awt.Point;

import com.dukitan.f2ibuilder.application.model.FontText;
import com.dukitan.f2ibuilder.components.type.Counter;

/**
 * Algoritmo para Aplica��o de M�tricas a Fonte.
 * 
 * Design Pattern: GoF - Strategy 
 * 
 * @author David Ferreira - davidferreira.fz@gmail.com
 */
abstract public class MetricStrategy
{
    public abstract Dimension adjust(Dimension ajuste, Dimension posicao, FontText fontText);
    
    public abstract Point position(Counter count, Dimension posicao, Dimension ajuste, FontText fontText);    
}
