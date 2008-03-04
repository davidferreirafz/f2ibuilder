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
package com.wordpress.dukitan.componentes.browser;

import com.wordpress.dukitan.componentes.browser.type.BrowserLinux;
import com.wordpress.dukitan.componentes.browser.type.BrowserMsWindows;
import com.wordpress.dukitan.componentes.browser.type.Browser;

/**
 * Classe Factory para determinar qual implementa��o
 * concreta de Browser deve ser utilizada. 
 * 
 * Design Pattern: GoF - Factory Method
 * 
 * @author David Ferreira 
 * @email davidferreira.fz@gmail.com
 */
public class BrowserFactory
{
    /**
     * Retorna uma implementa��o concreta da Interface Browser
     * @return inst�ncia de Browser
     */
    public static Browser getBrowser()
    {
        //Pega a propriedade com o nome do Sistema Operacional
        String so = System.getProperty("os.name");
        Browser browser;
        
        //Se o nome do sistema operacional come�a com Windows
        if (so.startsWith("Windows")){
            browser = new BrowserMsWindows();
        } else {
            //Nos outros casos, assume-se que o sistema � Linux
            System.out.println(so);
            browser = new BrowserLinux();
        }        

        return browser;
    }

}
