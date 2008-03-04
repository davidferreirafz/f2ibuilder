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

import java.io.IOException;

/**
 * Implementa��o da Interface Browser para abertura
 * do navegador no GNU/Linux
 * 
 * Design Pattern: GoF - Factory Method
 *  
 * @author David Ferreira 
 * @email davidferreira.fz@gmail.com 
 */
public class BrowserLinux implements Browser
{   
    @Override
    public boolean open(String url)
    {
        boolean open = true;        
        Runtime rt = Runtime.getRuntime();
        
        try {
            //tenta executar o firefox pelo comando 'firefox'
            rt.exec("firefox "+url);
        } catch (IOException e) {
            //caso n�o consiga executar pelo comando 'firefox'
            //tenta executar pelo comando mozilla-firefox
            try {
                rt.exec("mozilla-firefox "+url);
            } catch (IOException e1) {
                open = false;
            }
        }
        
        return open;
    }

}
