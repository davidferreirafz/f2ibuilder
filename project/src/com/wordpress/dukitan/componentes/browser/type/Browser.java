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

package com.wordpress.dukitan.componentes.browser.type;

/**
 * Interface para defini��o de abertura do 
 * browser no sistema operacional.
 * 
 * Design Pattern: GoF - Factory Method
 * 
 * @author David Ferreira - davidferreira.fz@gmail.com
 */
public interface Browser
{
    /**
     * Executa a url passada abrindo-a no browser.
     * @param url a ser aberta no navegador
     * @return retorna true em caso de abertura com sucesso.
     */
    public boolean open(String url);
}
