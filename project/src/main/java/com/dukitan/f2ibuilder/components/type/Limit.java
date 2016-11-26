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
package com.dukitan.f2ibuilder.components.type;

/**
 * Classe para representar os limites m�ximo e m�nimo
 * 
 * @author David Ferreira - davidferreira.fz@gmail.com
 */
public class Limit
{
    /**
     * limite m�nimo.
     */
    public int min;

    /**
     * limite m�ximo. 
     */
    public int max;
   
    /**
     * Construtor
     * @param min limite m�nimo
     * @param max limite m�ximo
     */
    public Limit(int min, int max)
    {
        this.min=min;
        this.max=max;
    }
    
    @Override
    public String toString()
    {
        return  "Limit ("+min+","+max+")";
    }
    
}
